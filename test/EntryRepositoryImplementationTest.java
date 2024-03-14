import data.models.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.EntryRepository;
import repositories.EntryRepositoryImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryRepositoryImplementationTest {
    private EntryRepositoryImplementation entryRepositoryImplementation;

    @BeforeEach
    public void initializer() {
        entryRepositoryImplementation = new EntryRepositoryImplementation();
    }

    @Test
    public void testThatEntriesCanAddOneEntry() {
        Entry entry = new Entry(1, "title", "body");
        entryRepositoryImplementation.save(entry);
        assertEquals(1, entryRepositoryImplementation.count());

    }

    @Test
    public void testThatEntriesCanAddTwoEntry() {
        Entry entry = new Entry(1, "title", "body");
        entryRepositoryImplementation.save(entry);
        entryRepositoryImplementation.save(entry);
        assertEquals(2, entryRepositoryImplementation.count());

    }

    @Test
    public void testThatEntryCanAddTwoEntry_removeOneEntry() {
        Entry entry = new Entry(1, "title", "body");
        entryRepositoryImplementation.save(entry);
        Entry entry1 = new Entry(2,"title1","body1");
        entryRepositoryImplementation.save(entry1);
        entryRepositoryImplementation.delete(1);
        assertEquals(1, entryRepositoryImplementation.count());

    }

    @Test
    public void testThatEntryCanAddEntry_removeOneEntry() {
        Entry entry = new Entry(1, "title", "body");
        entryRepositoryImplementation.save(entry);
        entryRepositoryImplementation.delete(1);
        assertEquals(0, entryRepositoryImplementation.count());

    }



    }



