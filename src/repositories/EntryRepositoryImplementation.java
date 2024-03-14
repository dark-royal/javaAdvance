package repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImplementation implements EntryRepository{
private List<Entry> entries = new ArrayList<>();

    @Override
    public Entry save(Entry entry) {
        entries.add(entry);
        return entry;

    }

    @Override
    public List<Diary> findAll() {
        return null;
    }

    @Override
    public Entry findById(int id) {
        for (Entry entry : entries) {
            if (entry.getId() == id) ;

        }

    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public void delete(int id) {
            entries.remove(id);



    }

    @Override
    public void delete(Entry entry) {

    }
}
