package model.exception;

import model.response.MessageGenerator;

/**
 * Represents an exception thrown when a command format is invalid.
 */
public class CommandFormatException extends AliceException {

    /**
     * Constructs a new CommandFormatException with no detail message.
     */
    public CommandFormatException() {
        super();
    }

    @Override
    public String getMessage() {
        return MessageGenerator.getCommandFormatExceptionMessage();
    }
}
