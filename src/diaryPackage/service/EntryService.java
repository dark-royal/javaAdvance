package diaryPackage.service;

import diaryPackage.data.models.Entry;
import diaryPackage.dto.request.CreateEntryRequest;
import diaryPackage.dto.request.UpdateRequest;

import java.util.List;

public interface EntryService {
    Entry createEntry(CreateEntryRequest createEntryRequest);
    void deleteEntry(int id);
    void updateEntry(UpdateRequest updateRequest);

    Entry findEntryById(int id);

    Long count();

}
