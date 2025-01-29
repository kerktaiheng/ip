import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    protected LocalDateTime by;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Deadline(String name, String by) {
        super(name);
        this.by = LocalDateTime.parse(by, FORMATTER);
    }

    public Deadline(String name, String by, Boolean isMarked) {
        super(name, isMarked);
        this.by = LocalDateTime.parse(by, FORMATTER);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(FORMATTER) + ")";
    }

    @Override
    public String toDataString() {
        return "D|" + (isMarked ? "1" : "0") + "|" + name + "|" + by.format(FORMATTER);
    }
}
