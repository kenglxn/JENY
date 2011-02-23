package hudson.plugins.jeny;

import java.io.IOException;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Result;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;

public class JenyRecorder extends Recorder {

    @DataBoundConstructor
    public JenyRecorder() {}

    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
        boolean success = Result.SUCCESS.equals(build.getResult());
        if(!success) {
            build.setResult(Result.FAILURE);
        }
        return success;
    }
}
