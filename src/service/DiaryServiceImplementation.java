package service;

import ExceptionClass.DiaryNotFoundException;
import ExceptionClass.IncorrectUsernameException;
import data.models.Diary;
import dto.request.LoginRequest;
import repositories.DiaryRepository;
import repositories.DiaryRepositoryImplementation;

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
    public void login(LoginRequest loginRequest) {
            Diary diary = diaryRepository.findByUsername(loginRequest.getUsername());
            if(diary == null)throw new DiaryNotFoundException("diary not found");
            if (!diary.getUsername().equalsIgnoreCase(loginRequest.getUsername()) && diary.getPassword().equalsIgnoreCase(loginRequest.getPassword()))throw new IncorrectUsernameException("invalid username or password");
                else {
                diary.setLogStatus(true);
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
