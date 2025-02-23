package model.exception;

import model.response.MessageGenerator;

/**
 * Represents an exception thrown when a task format is invalid.
 */
public class EventChronologyException extends AliceException {

    /**
     * Constructs a new TaskFormatException with no detail message.
     */
    public EventChronologyException() {
        super();
    }

    @Override
    public String getMessage() {
        return MessageGenerator.getEventChronologyExceptionMessage();
    }
}
