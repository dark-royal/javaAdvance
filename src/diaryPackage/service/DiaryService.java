package diaryPackage.service;

import diaryPackage.data.models.Diary;
import diaryPackage.data.models.Entry;
import diaryPackage.dto.request.CreateEntryRequest;
import diaryPackage.dto.request.LoginRequest;
import diaryPackage.dto.request.RegisterRequest;
import diaryPackage.dto.request.UpdateRequest;

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
