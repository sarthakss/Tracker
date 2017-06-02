package CarTracker.Exceptions;

/**
 * Created by sarth on 6/1/2017.
 */

public class NotFoundExceptions extends RuntimeException {

    public NotFoundExceptions(String message) {
        super(message);
    }

    public NotFoundExceptions(String message, Throwable cause) {

        super(message,cause);
    }
}