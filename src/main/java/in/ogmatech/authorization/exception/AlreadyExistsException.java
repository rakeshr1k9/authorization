package in.ogmatech.authorization.exception;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(final String message){
        super(message);
    }
}
