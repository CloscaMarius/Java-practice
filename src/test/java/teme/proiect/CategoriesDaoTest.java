package teme.proiect;

import org.junit.*;
import teme.proiect.Budget_Tracker.DbInitService;
import teme.proiect.Budget_Tracker.DbManager;
import teme.proiect.Budget_Tracker.db.CategoriesDao;
import teme.proiect.Budget_Tracker.dto.CategoriesDto;
import teme.proiect.Budget_Tracker.dto.Type;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CategoriesDaoTest {
    private static final String TEST_DB_FILE = "budget_tracker_testCategories.db";

    private static final List<CategoriesDto> sampleItems = Arrays.asList(
            new CategoriesDto("rent", Type.EXPENSE),
            new CategoriesDto("salary", Type.INCOME),
            new CategoriesDto("bills", Type.EXPENSE));

    private final CategoriesDao dao = new CategoriesDao();

    @BeforeClass
    public static void initDbBeforeAnyTests() {
        DbManager.setDbFile(TEST_DB_FILE); //use a separate db for test, to avoid overwriting the real one
        DbInitService.createMissingTables();
    }

    @Before
    public void insertRowsBeforeTest() {
        assertTrue(dao.getAll().isEmpty());
        for (CategoriesDto item : sampleItems) {
            dao.insert(item);
        }
    }

    @After
    public void deleteRowsAfterTest() {
        for (CategoriesDto item : dao.getAll()) {
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


    @Test
    public void get() {
        CategoriesDto item1fromDb = dao.getAll().get(0);

        assertEquals(item1fromDb, dao.getById(item1fromDb.getId()).get());
    }

    @Test
    public void getByTypeExpense() {
        List<CategoriesDto> itemsFromDb = dao.getByType(Type.EXPENSE);
        assertEquals(2, itemsFromDb.size());
    }

    @Test
    public void getByTypeIncome() {
        List<CategoriesDto> itemsFromDb = dao.getByType(Type.INCOME);
        assertEquals(1, itemsFromDb.size());
    }


    @Test
    public void get_forInvalidId() {
        assertFalse(dao.getById(-99).isPresent());
    }

    @Test
    public void insert() {
        assertEquals(3, dao.getAll().size());

        CategoriesDto newItem = new CategoriesDto("sales", Type.INCOME);
        dao.insert(newItem);

        assertEquals(4, dao.getAll().size());
    }

    private void checkOnlyTheSampleItemsArePresentInDb() {
        List<CategoriesDto> itemsFromDb = dao.getAll();
        assertEquals(3, itemsFromDb.size());

    }

    @Test
    public void update() {
        CategoriesDto item1fromDb = dao.getAll().get(0);
        dao.updateDescription(item1fromDb.getId(), item1fromDb.getDescription() + "!");
        assertEquals(item1fromDb.getDescription() + "!", dao.getAll().get(0).getDescription());

    }

    @Test
    public void update_forInvalidId() {
        dao.updateDescription(-77, "updated");
        assertEquals(3, dao.getAll().size());
    }

    @Test
    public void delete() {
        List<CategoriesDto> itemsFromDb = dao.getAll();
        dao.delete(itemsFromDb.get(0).getId());

        List<CategoriesDto> itemsInDBAfterDelete = dao.getAll();
        assertEquals(2, itemsInDBAfterDelete.size());

    }

    @Test
    public void delete_forInvalidId() {
        checkOnlyTheSampleItemsArePresentInDb();
        dao.delete(-66);
        checkOnlyTheSampleItemsArePresentInDb();
    }
}
