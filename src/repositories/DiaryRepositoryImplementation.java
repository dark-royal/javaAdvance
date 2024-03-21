package repositories;

import data.models.Diary;
import data.models.Entry;
import service.IncorrectUsernameException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiaryRepositoryImplementation implements DiaryRepository {

    private List<Diary> diaries = new ArrayList<>();

    @Override
    public Diary save(Diary diary) {
        diaries.add(diary);
        System.out.println(diaries.size());
        for (Diary diary1 : diaries) {
            if (Objects.equals(diary.getUsername(), diary1.getUsername())) {
                diaries.set(diaries.indexOf(diary), diary);
            } else {

            }

        }
        return diary;
    }

    @Override
    public List<Diary> findAll() {
        return diaries;
    }

    @Override
    public Diary findByUsername(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equalsIgnoreCase(username)) {
                return diary;
            }
        }
    throw new IncorrectUsernameException("invalid username");
    }

    @Override
    public long count() {
        System.out.println(diaries.size());
        return diaries.size();

    }

    @Override
    public void delete(Diary diary) {
        diaries.remove(diary);

    }

    @Override
    public void delete(String username) {
        Diary diary= findByUsername(username);
        System.err.println(diary);
        diaries.remove(diary);
    }



}