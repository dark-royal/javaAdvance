package diaryPackage.ExceptionClass;

public class EntryNotChangedException extends RuntimeException {
    public EntryNotChangedException(String message){
        super(message);
    }
}
