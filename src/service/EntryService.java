package service;

import data.models.Entry;
import dto.request.LoginRequest;

import java.util.List;

public interface EntryService {
    void createEntry(CreateEntryRequest createEntryRequest);
    void deleteEntry(int id);
    void updateEntry(String userName);

    List<Entry> findEntryById();

    Long count();

}
