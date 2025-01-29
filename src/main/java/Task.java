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
        isMarked = true;
    }

    public void unmark() {
        isMarked = false;
    }

    @Override
    public String toString() {
        return "[" + (isMarked ? "X" : " ") + "] " + name;
    }

    public static Task parseTask(String taskString) {
        String[] taskParts = taskString.split("|");
        boolean isMarked = taskParts[1].equals("1");
        switch(taskParts[0]) {
        case "T":
            return new Todo(taskParts[2], isMarked);
        case "D":
            return new Deadline(taskParts[2], taskParts[3], isMarked);
        case "E":
            return new Event(taskParts[2], taskParts[3], taskParts[4], isMarked);
        default:
            return null;
        }
    }

    public abstract String toDataString();

}
