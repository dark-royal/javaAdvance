package diaryPackage.ExceptionClass;

public class EntryNotFoundException extends RuntimeException {

    public EntryNotFoundException(String message){
        super(message);
    }
}
