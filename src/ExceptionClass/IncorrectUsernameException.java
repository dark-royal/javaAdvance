package ExceptionClass;

public class IncorrectUsernameException extends RuntimeException{
    public IncorrectUsernameException(String message){
        super(message);

    }
}
