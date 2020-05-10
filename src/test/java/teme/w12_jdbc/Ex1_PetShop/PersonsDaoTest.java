package teme.w12_jdbc.Ex1_PetShop;

import org.junit.*;
import teme.w12_jdbc.Ex1_PetShop.db.PersonsDao;
import teme.w12_jdbc.Ex1_PetShop.dto.Gender;
import teme.w12_jdbc.Ex1_PetShop.dto.PersonsDto;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PersonsDaoTest {

    private static final String TEST_DB_FILE = "w12_notes_petshop.db";

    private static final long baseTime = System.currentTimeMillis();
    private static final List<PersonsDto> sampleItems = Arrays.asList(
            new PersonsDto("name1", "name1.1", 22, Gender.M),
            new PersonsDto("name2", "name2.2", 23, Gender.F),
            new PersonsDto("name3", "name3.3", 24, Gender.M));

    private final PersonsDao dao = new PersonsDao();

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
        assertTrue(PersonsDao.getAll().isEmpty());
        for (PersonsDto item : sampleItems) {
            dao.insert(item);
        }
    }

    @After
    public void deleteRowsAfterTest() {
        for (PersonsDto item : dao.getAll()) {
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

    private void assertEqualItemsExceptId(PersonsDto item1, PersonsDto item2) {
        assertTrue("items should be equal (except id): " + item1 + ", " + item2,
                item1.getFirst_name().equals(item2.getFirst_name()) &&
                        item1.getLast_name().equals(item2.getLast_name()) &&
                        item1.getAge() == item2.getAge() &&
                        item1.getGender() == item2.getGender());
    }

    @Test
    public void get() {
        PersonsDto item1fromDb = dao.getAll().get(0);

        assertEquals(item1fromDb, dao.getById(item1fromDb.getId()).get());
    }

    @Test
    public void get_forInvalidId() {
        assertFalse(dao.getById(-99).isPresent());
    }

    @Test
    public void insert() {
        assertEquals(3, PersonsDao.getAll().size());

        PersonsDto newPerson = new PersonsDto("name4", "name4.4", 21, Gender.F);
        dao.insert(newPerson);

        assertEquals(4, PersonsDao.getAll().size());
        System.out.println(PersonsDao.getAll());
    }


    private void checkOnlyTheSampleItemsArePresentInDb() {
        List<PersonsDto> itemsFromDb = PersonsDao.getAll();
        assertEquals(3, itemsFromDb.size());

    }

    @Test
    public void delete() {
        List<PersonsDto> itemsFromDb = dao.getAll();
        dao.delete(itemsFromDb.get(0).getId());

        List<PersonsDto> itemsInDBAfterDelete = dao.getAll();
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