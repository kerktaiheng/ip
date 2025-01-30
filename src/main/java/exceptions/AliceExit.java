package exceptions;

/**
 * Represents an exception that indicates the program should exit. Maybe this
 * should be an Interrupt instead?
 *
 */
public class AliceExit extends AliceException {
    /**
     * Constructs a new AliceExit with no detail message.
     */
    public AliceExit() {
        super();
    }
}
