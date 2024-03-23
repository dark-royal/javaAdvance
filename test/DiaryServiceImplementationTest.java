import ExceptionClass.DiaryNotFoundException;
import ExceptionClass.IncorrectUsernameException;
import data.models.Diary;
import data.models.Entry;
import dto.request.CreateEntryRequest;
import dto.request.UpdateRequest;
import dto.request.LoginRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.*;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryServiceImplementationTest {

    private DiaryService diaryService;
    private RegisterRequest registerRequest;
    private LoginRequest loginRequest;
    private CreateEntryRequest createEntryRequest;
    private Diary diary;

    private UpdateRequest updateRequest;

    @BeforeEach
    public void initializer(){
        diaryService = new DiaryServiceImplementation();
        registerRequest = new RegisterRequest();
        loginRequest = new LoginRequest();
        diary = new Diary();
        createEntryRequest = new CreateEntryRequest();
        updateRequest = new UpdateRequest();

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
        assertThrows(DiaryNotFoundException.class,()->diaryService.logout("username1"));
        assertTrue(diary.setLogStatus(true));
    }

    @Test
    public void userCanRegister_Login_createEntry(){
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.registerUser(registerRequest);
        assertEquals(1, diaryService.count());
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        assertTrue(diary.setLogStatus(true));
        createEntryRequest.setTitle("semicolon");
        createEntryRequest.setBody("i love semicolon");
        System.out.println(createEntryRequest.getDateAndTimeCreated());
        diaryService.createEntry(createEntryRequest);
        assertEquals(1,diaryService.count());


    }

    @Test
    public void userCanRegister_Login_createEntry_andCanUpdateTheEntry() {
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryService.registerUser(registerRequest);
        assertEquals(1, diaryService.count());
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryService.login(loginRequest);
        assertTrue(diary.setLogStatus(true));
        createEntryRequest.setTitle("semicolon");
        createEntryRequest.setBody("i love semicolon");
        System.out.println(createEntryRequest.getDateAndTimeCreated());
        Entry entyr1 = diaryService.createEntry(createEntryRequest);
        assertEquals(1, diaryService.count());
        updateRequest.setTitle("semicolon");
        diary.createEntry("title","body");
        diary.updateEntry(1,"new title","new body");
        Entry foundEntry = diaryRfindEntryById(1);
        assertEquals("new title",foundEntry.getTitle());
        assertEquals("new body",foundEntry.getBody());

        //System.out.println(STR."\{updateRequest.getId()} nothing");
        assertEquals(1, diaryService.updateEntry(updateRequest).getTitle());


    }


    }
