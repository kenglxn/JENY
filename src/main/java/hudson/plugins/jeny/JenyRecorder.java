package hudson.plugins.jeny;

import java.io.IOException;
import java.util.logging.Logger;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Result;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;

public class JenyRecorder extends Recorder {
    private static final Logger LOGGER = Logger.getLogger(JenyRecorder.class.getName());


    @DataBoundConstructor
    public JenyRecorder() {}

    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
        return Result.SUCCESS.equals(build.getResult());
    }

    @Override
    public boolean needsToRunAfterFinalized() {
        return super.needsToRunAfterFinalized();
    }
}
