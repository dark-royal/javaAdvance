package service;

public class DiaryNotFoundException extends  RuntimeException {
    public DiaryNotFoundException(String message){
        super(message);
    }
}
