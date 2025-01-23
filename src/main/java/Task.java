public class Task {
    protected String name;
    protected Boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + name;
    }
}
