package service;

import dto.request.LoginRequest;

public interface DiaryService {
    void registerUser(RegisterRequest registerRequest);
    void login(LoginRequest loginReques);
    void logout(String userName);
    //void addDiaries(AddDiaryRequest addDiaryRequest);

    Long count();




}
