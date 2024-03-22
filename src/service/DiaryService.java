package service;

import dto.request.CreateEntryRequest;
import dto.request.LoginRequest;

public interface DiaryService {
    void registerUser(RegisterRequest registerRequest);
    void login(LoginRequest loginReques);
    void logout(String userName);

    void createEntry(CreateEntryRequest createEntryRequest);

    Long count();




}
