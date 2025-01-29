public class Deadline extends Task{
    protected String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    public Deadline(String name, String by, Boolean isMarked) {
        super(name, isMarked);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toDataString() {
        return "D|" + (isMarked ? "1" : "0") + "|" + name + "|" + by;
    }
}
