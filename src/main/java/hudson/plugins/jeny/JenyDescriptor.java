package hudson.plugins.jeny;

import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;
import net.sf.json.JSONObject;

@Extension
public class JenyDescriptor extends BuildStepDescriptor<Publisher> {

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
}