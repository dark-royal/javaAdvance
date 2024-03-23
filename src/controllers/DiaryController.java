package controllers;

import dto.request.LoginRequest;
import service.DiaryService;
import service.DiaryServiceImplementation;
import service.RegisterRequest;

public class DiaryController {


    private DiaryService diaryService = new DiaryServiceImplementation();
    private RegisterRequest registerRequest = new RegisterRequest();
    private LoginRequest loginRequest = new LoginRequest();
    private String registerUser() {
        try {
            diaryService.registerUser(registerRequest);
            return "request successfull";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void login(){
        try{
            diaryService.login(loginRequest);
            return "login successfully";
        }
    }
}
