package hudson.plugins.jeny;

import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;
import net.sf.json.JSONObject;

@Extension
public class JenyDescriptor extends BuildStepDescriptor<Publisher> {

    private boolean isEnabled;

    /**
     * Constructs a {@link JenyDescriptor}.
     */
    public JenyDescriptor() {
        super(JenyRecorder.class);
    }

    @Override
    public final String getDisplayName() {
        return "Activate JENY";
    }

    @Override
    public String getHelpFile() {
        return "/plugin/jeny/help.html";
    }

    @Override
    public final boolean isApplicable(final Class<? extends AbstractProject> clazz) {
        return true;
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
        // To persist global configuration information,
        // set that to properties and call save().
        isEnabled = formData.getBoolean("isEnabled");
        // ^Can also use req.bindJSON(this, formData);
        //  (easier when there are many fields; need set* methods for this, like setUseFrench)
        save();
        return super.configure(req, formData);
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}