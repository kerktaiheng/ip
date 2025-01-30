package task;

public abstract class Task {
    protected String name;
    protected Boolean isMarked = false;

    public Task(String name) {
        this.name = name;
        this.isMarked = false;
    }

    public Task(String name, Boolean isMarked) {
        this.name = name;
        this.isMarked = isMarked;
    }

    public void mark() {
        this.isMarked = true;
    }

    public void unmark() {
        this.isMarked = false;
    }

    @Override
    public String toString() {
        return "[" + (isMarked ? "X" : " ") + "] " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task task) {
            return this.name.equals(task.name) && this.isMarked.equals(task.isMarked);
        }
        return false;
    }

    public abstract String toDataString();
}