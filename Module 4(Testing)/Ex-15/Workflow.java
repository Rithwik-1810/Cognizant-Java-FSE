public class Workflow {
    private final TaskRunner runner;

    public Workflow(TaskRunner runner) {
        this.runner = runner;
    }

    public void execute() {
        runner.stepOne();
        runner.stepTwo();
    }
}
