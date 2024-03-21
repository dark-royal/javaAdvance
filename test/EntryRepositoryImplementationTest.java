import data.models.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.EntryRepository;
import repositories.EntryRepositoryImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryRepositoryImplementationTest {
    private EntryRepository repository;

    @BeforeEach
    public void initializer() {
        repository = new EntryRepositoryImplementation();
    }

    @Test
    public void testThatEntriesCanAddOneEntry() {
        Entry entry = new Entry(1, "title", "body");
        repository.save(entry);
        assertEquals(1, repository.count());

    }

    @Test
    public void testThatEntriesCanAddTwoEntry() {
        Entry entry = new Entry(1, "title", "body");
        repository.save(entry);
        repository.save(entry);
        assertEquals(2, repository.count());

    }



    @Test
    public void testThatEntryCanAddTwoEntry_removeOneEntry() {
        Entry entry = new Entry(1, "title", "body");
        repository.save(entry);
        Entry entry1 = new Entry(2,"title1","body1");
        repository.save(entry1);
        repository.delete(1);
        assertEquals(1, repository.count());

    }

    @Test
    public void testThatEntryCanAddEntry_removeOneEntry() {
        Entry entry = new Entry(1, "title", "body");
        repository.save(entry);
        repository.delete(1);
        assertEquals(0, repository.count());

    }


    @Test
    public void testThatEntryCanAddTwoEntry_removeTwoEntry() {
        Entry entry = new Entry(1, "title", "body");
        repository.save(entry);
        Entry entry1 = new Entry(2,"title1","body");
        repository.save(entry1);
        repository.delete(1);
        repository.delete(2);
        assertEquals(0, repository.count());

    }

    @Test
    public void testThatEntryCanAddEntry_removeOneEntryByTheObject() {
        Entry entry = new Entry(1, "title", "body");
        repository.save(entry);
        repository.delete(entry);
        assertEquals(0, repository.count());

    }

    @Test
    public void testThatEntryCanAddThreeEntry_removeTwoEntry() {
        Entry entry = new Entry(1, "title", "body");
        repository.save(entry);
        Entry entry1 = new Entry(2,"title1","body1");
        repository.save(entry);
        repository.delete(entry);
        repository.delete(entry1);
        assertEquals(1, repository.count());

    }

    @Test
    public void testThatEntriesCanFindAllEntry(){
        Entry entry = new Entry(1, "title", "body");
        repository.save(entry);
        repository.save(entry);
        repository.findAll();
        assertEquals(2, repository.count());
        }


    }







