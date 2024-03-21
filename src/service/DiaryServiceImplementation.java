package service;

import data.models.Diary;
import repositories.DiaryRepository;
import repositories.DiaryRepositoryImplementation;

import java.util.Objects;

public class DiaryServiceImplementation implements DiaryService{

    private DiaryRepository diaryRepository = new DiaryRepositoryImplementation();
    @Override
    public void registerUser(RegisterRequest registerRequest) {
        Diary diary = new Diary();
            diary.setUsername(registerRequest.getUsername());
            diary.setPassword(registerRequest.getPassword());
            diaryRepository.save(diary);


    }

    @Override
    public void login(String userName, String password) {
        try {
            Diary diary = diaryRepository.findByUsername(userName);
            if (diary.getUsername().equalsIgnoreCase(userName) && diary.getPassword().equalsIgnoreCase(password)) {
                diary.setLogStatus(true);
            }
        } catch (IncorrectUsernameException e) {
            System.out.println(e.getMessage());
        }
    }
    public void logout(String userName) {

        Diary diary = diaryRepository.findByUsername(userName);
        diary.setLogStatus(false);
        diaryRepository.save(diary);
    }
    @Override
    public Long count() {
        return diaryRepository.count();
    }


}
