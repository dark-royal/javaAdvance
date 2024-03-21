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
        Diary diary = diaryRepository.findByUsername(userName);
        if(Objects.equals(diary.getUsername(), userName) && Objects.equals(diary.getPassword(), password)){
            diary.setLogStatus(true);
        }

        else{
            throw  new IncorrectUsernameException("username or password is incorrect");
        }


    }

    @Override
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
