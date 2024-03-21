package service;

public interface DiaryService {
    void registerUser(RegisterRequest registerRequest);
    void login(String userName, String password);
    void logout(String userName);
    //void addDiaries(AddDiaryRequest addDiaryRequest);

    Long count();




}
