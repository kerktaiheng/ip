package model.exception;

import model.response.MessageGenerator;

/**
 * Represents an exception thrown when an invalid index is provided.
 */
public class InvalidIndexException extends AliceException {

    /**
     * Constructs a new InvalidIndexException with no detail message.
     */
    public InvalidIndexException() {
        super();
    }

    @Override
    public String getMessage() {
        return MessageGenerator.getInvalidIndexExceptionMessage();
    }
}
