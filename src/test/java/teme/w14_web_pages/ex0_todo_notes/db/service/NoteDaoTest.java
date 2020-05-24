package teme.w14_web_pages.ex0_todo_notes.db.service;

import org.junit.*;
import teme.w14_web_pages.notes_web_service.db.DbManager;
import teme.w14_web_pages.notes_web_service.db.dto.NoteDto;
import teme.w14_web_pages.notes_web_service.db.dto.Priority;
import teme.w14_web_pages.notes_web_service.db.dto.State;
import teme.w14_web_pages.notes_web_service.db.service.DbInitService;
import teme.w14_web_pages.notes_web_service.db.service.NoteDao;

import java.io.File;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NoteDaoTest {

    private static final String TEST_DB_FILE = "w13_notes_test.db";

    private static final long baseTime = System.currentTimeMillis();
    private static final List<NoteDto> sampleItems = Arrays.asList(
            new NoteDto("item1", new Date(baseTime), Priority.HIGH, State.ACTIVE),
            new NoteDto("item2", new Date(baseTime + 1000), Priority.LOW, State.ACTIVE),
            new NoteDto("item3", new Date(baseTime - 1000), Priority.MEDIUM, State.COMPLETED));

    private final NoteDao dao = new NoteDao();

    /**
     * This will be called only once before running the tests, due to @BeforeClass
     */
    @BeforeClass
    public static void initDbBeforeAnyTests() {
        DbManager.setDbFile(TEST_DB_FILE); //use a separate db for test, to avoid overwriting the real one
        DbInitService.createMissingTables();
    }

    /**
     * This will be called once before each test! due to @Before
     */
    @Before
    public void insertRowsBeforeTest() {
        assertTrue(dao.getAll().isEmpty());
        for (NoteDto item : sampleItems) {
            dao.insert(item);
        }
    }

    @After
    public void deleteRowsAfterTest() {
        for (NoteDto item : dao.getAll()) {
            dao.delete(item.getId());
        }
        assertTrue(dao.getAll().isEmpty());
    }

    @AfterClass
    public static void deleteDbFileAfterAllTests() {
        new File(TEST_DB_FILE).delete();
    }


    @Test
    public void getAll() {
        checkOnlyTheSampleItemsArePresentInDb();
    }

    private void assertEqualItemsExceptId(NoteDto item1, NoteDto item2) {
        assertTrue("items should be equal (except id): " + item1 + ", " + item2,
                item1.getDescription().equals(item2.getDescription()) &&
                        item1.getDueDate().equals(item2.getDueDate()) &&
                        item1.getPriority() == item2.getPriority() &&
                        item1.getState() == item2.getState());
    }

    @Test
    public void get() {
        NoteDto item1fromDb = dao.getAll().get(0);

        assertEquals(item1fromDb, dao.get(item1fromDb.getId()).get());
    }

    @Test
    public void get_forInvalidId() {
        assertFalse(dao.get(-99).isPresent());
    }

    @Test
    public void insert() {
        assertEquals(3, dao.getAll().size());

        NoteDto newItem = new NoteDto("item4", new Date(baseTime + 3000), Priority.HIGH, State.ACTIVE);
        dao.insert(newItem);

        assertEqualItemsExceptId(newItem, dao.getAll().get(0));
    }

    @Test
    public void insert_descriptionAndDateMustBeUnique() {
        assertEquals(3, dao.getAll().size());
        NoteDto existing = sampleItems.get(0);

        NoteDto newItem = new NoteDto(existing.getDescription(), existing.getDueDate(), Priority.HIGH, State.ACTIVE);
        dao.insert(newItem); //should fail, but with no exception thrown

        //still 3 items in db, newItem is not among them
        checkOnlyTheSampleItemsArePresentInDb();
    }

    private void checkOnlyTheSampleItemsArePresentInDb() {
        List<NoteDto> itemsFromDb = dao.getAll();
        assertEquals(3, itemsFromDb.size());
        assertEqualItemsExceptId(itemsFromDb.get(0), sampleItems.get(1));
        assertEqualItemsExceptId(itemsFromDb.get(1), sampleItems.get(0));
        assertEqualItemsExceptId(itemsFromDb.get(2), sampleItems.get(2));
    }

    @Test
    public void update() {
        NoteDto item1fromDb = dao.getAll().get(0);
        NoteDto updatedItem = new NoteDto(item1fromDb.getId(), item1fromDb.getDescription() + "!", item1fromDb.getDueDate(), Priority.LOW, State.COMPLETED);
        dao.update(updatedItem);
        assertEquals(updatedItem, dao.getAll().get(0));
    }

    @Test
    public void update_forInvalidId() {
        dao.update(new NoteDto(-77, "updated", new Date(baseTime), Priority.HIGH, State.COMPLETED));
        checkOnlyTheSampleItemsArePresentInDb();
    }

    @Test
    public void delete() {
        List<NoteDto> itemsFromDb = dao.getAll();
        dao.delete(itemsFromDb.get(0).getId());

        List<NoteDto> itemsInDBAfterDelete = dao.getAll();
        assertEquals(2, itemsInDBAfterDelete.size());
        assertEqualItemsExceptId(itemsFromDb.get(1), itemsInDBAfterDelete.get(0));
        assertEqualItemsExceptId(itemsFromDb.get(2), itemsInDBAfterDelete.get(1));
    }

    @Test
    public void delete_forInvalidId() {
        checkOnlyTheSampleItemsArePresentInDb();
        dao.delete(-66);
        checkOnlyTheSampleItemsArePresentInDb();
    }
}