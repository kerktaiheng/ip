package task;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    protected String name;
    protected Boolean isMarked = false;
    public static final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

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

    public abstract String toDataString();
}