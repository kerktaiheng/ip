package model.exception;

/**
 * Represents an exception thrown when there is an I/O error during storage
 * operations.
 */
public class StorageIOException extends AliceException {

    /**
     * Constructs a new StorageIOException with no detail message.
     */
    public StorageIOException() {
        super();
    }
}
