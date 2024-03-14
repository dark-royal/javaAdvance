package repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.List;

public interface EntryRepository {
    Entry save(Entry entry);
    List<Diary> findAll();
    Entry findById(int id);
    long count();
    void delete(int id);
    void delete(Entry entry);


}
