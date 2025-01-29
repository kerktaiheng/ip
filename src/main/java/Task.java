import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    protected String name;
    protected Boolean isMarked = false;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

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
        String[] taskParts = taskString.split("\\|");
        boolean isMarked = taskParts[1].equals("1");
        switch(taskParts[0]) {
        case "T":
            return new Todo(taskParts[2], isMarked);
        case "D":
            LocalDateTime by = LocalDateTime.parse(taskParts[3], FORMATTER);
            return new Deadline(taskParts[2], by.format(FORMATTER), isMarked);
        case "E":
            LocalDateTime from = LocalDateTime.parse(taskParts[3], FORMATTER);
            LocalDateTime to = LocalDateTime.parse(taskParts[4], FORMATTER);
            return new Event(taskParts[2], from.format(FORMATTER), to.format(FORMATTER), isMarked);
        default:
            return null;
        }
    }

    public abstract String toDataString();
}
