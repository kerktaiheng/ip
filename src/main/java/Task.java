public abstract class Task {
    protected String name;
    protected Boolean isMarked = false;

    public Task(String name) {
        this.name = name;
        this.isMarked = false;
    }

    public void mark() {
        isMarked = true;
    }

    public void unmark() {
        isMarked = false;
    }

    @Override
    public String toString() {
        return "[" + (isMarked ? "X" : " ") + "] " + name;
    }
}
