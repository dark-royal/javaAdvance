package service;

import data.models.Entry;
import dto.request.CreateEntryRequest;
import dto.request.UpdateRequest;

import java.util.List;

public interface EntryService {
    Entry createEntry(CreateEntryRequest createEntryRequest);
    void deleteEntry(int id);
    void updateEntry(UpdateRequest updateRequest);

    Entry findEntryById(int id);

    Long count();

}
