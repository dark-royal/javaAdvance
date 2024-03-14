package repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.List;

public class EntryRepositoryImplementation implements EntryRepository{


    @Override
    public Entry save(Entry entry) {
        return null;
    }

    @Override
    public List<Diary> findAll() {
        return null;
    }

    @Override
    public Entry findById(int id) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(Entry entry) {

    }
}
