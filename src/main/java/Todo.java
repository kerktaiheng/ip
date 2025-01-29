public class Todo extends Task {

    public Todo(String name) {
        super(name);
    }

    public Todo(String name, Boolean isMarked) {
        super(name, isMarked);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toDataString() {
        return "T|" + (isMarked ? "1" : "0") + "|" + name;
    }

}
