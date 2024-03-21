package repositories;

import data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImplementation implements DiaryRepository {

    private List<Diary> diaries = new ArrayList<>();
    private int counter = 0;

    @Override
    public Diary save(Diary diary) {
        if (isNew(diary)) {
            addIdTo(diary);
            diaries.add(diary);
            return diary;
        } else {
            update(diary);
            return diary;

        }
    }

    @Override
    public List<Diary> findAll() {
        return diaries;    }

    @Override
    public Diary findByUsername(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equalsIgnoreCase(username)) {
                return diary;
            }
        }
        return null;

    }

    @Override
    public long count() {
        System.out.println(diaries.size());
        return diaries.size();
    }

    @Override
    public void delete(String username) {
        Diary diary= findByUsername(username);
        System.err.println(diary);
        diaries.remove(diary);
    }

    @Override
    public void delete(Diary diary) {
        diaries.remove(diary);
    }


//        for (Diary diary1 : diaries) {
//            if (diary.getUsername().equalsIgnoreCase(diary1.getUsername())) {
//                diaries.set(diaries.indexOf(diary), diary);
//            } else {
//                diaries.add(diary);
//                System.out.println(diaries.size());
//
//            }
//
//        }
//        return diary;












    private void addIdTo(Diary diary) {
        diary.setId(generateId());
    }

    private int generateId() {
        return ++counter;
    }

    private boolean isNew(Diary diary) {
        return diary.getId() == 0;
    }

    public void update(Diary diary) {
        for (Diary diary1 : diaries) {
            if (diary1.getId() == diary.getId()) delete(diary1);
            }
        }
    }



