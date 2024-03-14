package repositories;

import data.models.Diary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiaryRepositoryImplementation implements DiaryRepository {

    private List<Diary> diaries = new ArrayList<>();

    @Override
    public Diary save(Diary diary) {
        diaries.add(diary);
        return diary;

    }

    @Override
    public List<Diary> findAll() {
        return diaries;
    }

    @Override
    public Diary findByUsername(String username) {
        for (Diary diary : diaries) {
            if (Objects.equals(diary.getUsername(), username)) {
                return diary;
            }

        }
        return null;
    }

    @Override
    public long count() {
        return diaries.size();

    }

    @Override
    public void delete(Diary diary) {
        diaries.remove(diary);

    }

    @Override
    public void delete(String username) {
        Diary diary= findByUsername(username);
        System.out.println(diary);
        diaries.remove(diary);

    }

}