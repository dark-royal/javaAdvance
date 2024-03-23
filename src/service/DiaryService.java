package service;

import data.models.Diary;
import data.models.Entry;
import dto.request.CreateEntryRequest;
import dto.request.LoginRequest;
import dto.request.UpdateRequest;

import java.util.List;

public interface DiaryService {
    void registerUser(RegisterRequest registerRequest);
    void login(LoginRequest loginReques);
    void logout(String userName);
    List<Diary> getAll();

    Entry findEntry(String title);

    Entry createEntry(CreateEntryRequest createEntryRequest);

    Entry updateEntry(UpdateRequest updateRequest);

    Long count();
    int countEntries();
    void deleteEntry(String title);




}
