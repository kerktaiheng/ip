package task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDateTime by;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Deadline(String name, LocalDateTime by) {
        super(name);
        this.by = by;
    }

    public Deadline(String name, LocalDateTime by, Boolean isMarked) {
        super(name, isMarked);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(FORMATTER) + ")";
    }

    @Override
    public String toDataString() {
        return "D|" + (isMarked ? "1" : "0") + "|" + name + "|" + by.format(FORMATTER);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Deadline deadline) {
            return super.equals(obj) && this.by.equals(deadline.by);
        }
        return false;
    }
}
