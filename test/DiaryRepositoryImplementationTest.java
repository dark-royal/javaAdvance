import data.models.Diary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.DiaryRepository;
import repositories.DiaryRepositoryImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaryRepositoryImplementationTest {

    private DiaryRepository repository;
    @BeforeEach
    public void initializer(){
        repository = new DiaryRepositoryImplementation();
    }
    @Test
    public void testDiaryCanAddDiary(){
        Diary diary = new Diary("username","password");
        repository.save(diary);
        assertEquals(1,repository.count());

    }

    @Test
    public void testDiariesCanAddTwoDiary(){
        Diary diary = new Diary("username","password");
        repository.save(diary);
        Diary diary1 = new Diary("bimbim","1234");
        repository.save(diary1);
        assertEquals(2,repository.count());
    }

    @Test
    public void testDiariesCanAddTwoDiary_findOneDiary(){
        Diary diary = new Diary("username","password");
        repository.save(diary);
        Diary diary1 = new Diary("username","password");
        repository.save(diary1);
        assertEquals(2,repository.count());
        Diary foundDiary = repository.findByUsername("username");
        assertEquals(foundDiary,repository.findByUsername("username"));

    }

    @Test
    public void testDiariesCanAddTwoDiary_findSecondDiary_DeleteFoundDiary(){
        Diary diary = new Diary("username","password");
        repository.save(diary);
        Diary diary1 = new Diary("username","password");
        repository.save(diary1);
        assertEquals(2,repository.count());
        repository.delete("username");
        assertEquals(1,repository.count());

    }

    @Test
    public void testDiariesCanAddTwoDiary_DeleteTwoDiary(){
        Diary diary = new Diary("username","password");
        repository.save(diary);
        Diary diary1 = new Diary("username1","password1");
        repository.save(diary1);
        assertEquals(2,repository.count());
        repository.delete("username");
        repository.delete("username1");
        assertEquals(0,repository.count());

    }

    @Test
    public void testDiariesCanAddTwoDiaries_deleteDiaryUsinObject(){
        Diary diary = new Diary("username","password");
        repository.save(diary);
        Diary diary1 = new Diary("username1","password1");
        repository.save(diary1);
        assertEquals(2,repository.count());
        repository.delete(diary);
        repository.delete(diary1);
        assertEquals(0,repository.count());

    }
    @Test
    public void testDiariesCanFindAllDiaryInTheDiary(){
    Diary diary = new Diary("username","password");
        repository.save(diary);
    Diary diary1 = new Diary("username1","password1");
        repository.save(diary1);
    assertEquals(2,repository.count());
        repository.findAll();
    assertEquals(2,repository.count());

}

    @Test
    public void testDiariesCanSaveNoDiary_FindAllDiaryInTheDiary(){
//        Diary diary = new Diary("username","password");
//        repository.save(diary);
//        Diary diary1 = new Diary("username1","password1");
//        repository.save(diary1);
//        assertEquals(2,repository.count());
        repository.findAll();
        assertEquals(0,repository.count());

    }

    @Test
    public void testDiariesCanSaveDiary_DeleteDiary_FindAllDiaryInTheDiaries(){
        Diary diary = new Diary("username","password");
        repository.save(diary);
        Diary diary1 = new Diary("username1","password1");
        repository.save(diary1);
        assertEquals(2,repository.count());
        repository.delete("username");
        repository.findAll();
        assertEquals(1,repository.count());

    }

    @Test
    public void testDiariesCanSaveDiary_findDiaryByUsername_deleteDiaryByUsernameAndObject_FindAllDiaryInTheDiary(){
        Diary diary = new Diary("username","password");
        repository.save(diary);
        Diary diary1 = new Diary("username1","password1");
        repository.save(diary1);
        assertEquals(2,repository.count());
        repository.findByUsername("username");
        repository.delete("username");
        repository.delete(diary1);
        repository.findAll();
        assertEquals(0,repository.count());

    }






}










