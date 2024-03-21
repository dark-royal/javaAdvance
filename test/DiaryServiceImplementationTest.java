import ExceptionClass.DiaryNotFoundException;
import ExceptionClass.IncorrectUsernameException;
import data.models.Diary;
import dto.request.LoginRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.*;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryServiceImplementationTest {

    private DiaryService diaryService;
    private RegisterRequest registerRequest;
    private LoginRequest loginRequest;
    private Diary diary;

    @BeforeEach
    public void initializer(){
        diaryService = new DiaryServiceImplementation();
        registerRequest = new RegisterRequest();
        loginRequest = new LoginRequest();
        diary = new Diary();

    }



    @Test
    public void userCanRegisterCustomer(){

        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.registerUser(registerRequest);
        assertEquals(1,diaryService.count());
    }

    @Test
    public void userCanLogin(){
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.registerUser(registerRequest);
        assertEquals(1,diaryService.count());
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        assertTrue(diary.setLogStatus(true));

    }

    @Test
    public void userCan_register_login_andlogout() {
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.registerUser(registerRequest);
        assertEquals(1, diaryService.count());
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        assertTrue(diary.setLogStatus(true));
        diaryService.logout("username");
        assertFalse(diary.setLogStatus(false));
    }

    @Test
    public void test_user_cannot_login_with_incorrect_username_or_password(){
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.registerUser(registerRequest);
        assertEquals(1, diaryService.count());
        loginRequest.setUsername("username1");
        loginRequest.setPassword("password");
        assertThrows(DiaryNotFoundException.class,()->diaryService.login(loginRequest));


    }
    @Test
     public void test_user_cannot_login_while_not_registered_throw_diary_not_found_exception(){
        loginRequest.setUsername(loginRequest.getUsername());
        loginRequest.setPassword(loginRequest.getPassword());
        assertThrows(DiaryNotFoundException.class,()->diaryService.login(loginRequest));

    }

    @Test
    public void userCan_register_login_andlogout_with_incorrect_username() {
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.registerUser(registerRequest);
        assertEquals(1, diaryService.count());
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        assertTrue(diary.setLogStatus(true));
        assertThrows(IncorrectUsernameException.class,()->diaryService.logout("username1"));
        assertTrue(diary.setLogStatus(true));
    }



}
