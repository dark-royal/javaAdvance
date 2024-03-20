package service;

import data.models.Diary;
import repositories.DiaryRepository;
import repositories.DiaryRepositoryImplementation;

public class DiaryServiceImplementation implements DiaryService{

    private DiaryRepository diaryRepository = new DiaryRepositoryImplementation();
    @Override
    public void registerUser(RegisterRequest registerRequest) {
        Diary diary = new Diary("username", "password");
        diary.setUsername("username1");
        diary.setPassword("password1");
        diaryRepository.save(diary);


    }

    @Override
    public void login(String userName, String password) {

    }

    @Override
    public void logout(String userName) {

    }
}
