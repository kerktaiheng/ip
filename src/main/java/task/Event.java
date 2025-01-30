package task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Event(String name, LocalDateTime from, LocalDateTime to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public Event(String name, LocalDateTime from, LocalDateTime to, boolean isMarked) {
        super(name, isMarked);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.format(FORMATTER) + " to: " + to.format(FORMATTER) + ")";
    }

    @Override
    public String toDataString() {
        return "E|" + (isMarked ? "1" : "0") + "|" + name + "|" + from.format(FORMATTER) + "|" + to.format(FORMATTER);
    }
}
