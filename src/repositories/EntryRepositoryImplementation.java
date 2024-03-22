package repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImplementation implements EntryRepository{
private List<Entry> entries = new ArrayList<>();

    @Override
    public Entry save(Entry entry) {
        for (Entry entry1 : entries){
            if (entry.getId() == entry1.getId()){
                entries.set(entries.indexOf(entry), entry);
            }else {
                entries.add(entry);
            }


        }
        return entry;

    }

    @Override
    public List<Entry> findAll() {
        return entries;
    }

    @Override
    public Entry findById(int id) {
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }

        }
        return null;

    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public void delete(int id) {
        Entry entry = findById(id);
        entries.remove(entry);


    }

    @Override
    public void delete(Entry entry) {
        entries.remove(entry);


    }

    private int generateId()
}
