package controllers;

import dto.request.CreateEntryRequest;
import dto.request.LoginRequest;
import service.DiaryService;
import service.DiaryServiceImplementation;
import service.RegisterRequest;

public class DiaryController {


    private final DiaryService diaryService = new DiaryServiceImplementation();
    private final RegisterRequest registerRequest = new RegisterRequest();
    private final LoginRequest loginRequest = new LoginRequest();
    private final CreateEntryRequest createEntryRequest = new CreateEntryRequest();
    private String registerUser() {
        try {
            diaryService.registerUser(registerRequest);
            return "request successfull";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String login(){
        try{
            diaryService.login(loginRequest);
            return "login successfully";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String logout(String username){
        try{
            diaryService.logout(username);
            return "login successfully";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String createEntry(){
        try{
            diaryService.createEntry(createEntryRequest);
            return "entry created successfully";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
