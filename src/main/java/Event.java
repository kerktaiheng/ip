public class Event extends Task{
    protected String from;
    protected String to;

    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public Event(String name, String from, String to, boolean isMarked) {
        super(name, isMarked);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String toDataString() {
        return "E|" + (isMarked ? "1" : "0") + "|" + name + "|" + from + "|" + to;
    }
    
}
