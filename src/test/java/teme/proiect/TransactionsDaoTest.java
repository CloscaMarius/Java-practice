package teme.proiect;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import teme.proiect.Budget_Tracker.DbInitService;
import teme.proiect.Budget_Tracker.DbManager;
import teme.proiect.Budget_Tracker.db.TransactionsDao;
import teme.proiect.Budget_Tracker.dto.TransactionsDto;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TransactionsDaoTest {

    private static final String TEST_DB_FILE = "budget_tracker_test.db";


    private static final List<TransactionsDto> sampleTransactions = Arrays.asList(
            new TransactionsDto(1, "2018-05-02", "rent payed", 150.47),
            new TransactionsDto(2, "2018-05-01", "salary", 500.0),
            new TransactionsDto(3, "2018-05-03", "bill payed", 75.83));


    private final TransactionsDao dao = new TransactionsDao();


    @BeforeClass
    public static void initDbBeforeAnyTests() {
        DbManager.setDbFile(TEST_DB_FILE); //use a separate db for test, to avoid overwriting the real one
        DbInitService.createMissingTables();
    }


    @Before
    public void insertTransactionsRowsBeforeTest() {
        assertTrue(dao.getAllByDateDesc().isEmpty());


        for (TransactionsDto item : sampleTransactions) {
            dao.insert(item);
        }
    }

    @After
    public void deleteTransactionsRowsAfterTest() {
        for (TransactionsDto item : dao.getAllByDateDesc()) {
            dao.deleteById(item.getId());
        }
        assertTrue(dao.getAllByDateDesc().isEmpty());
    }

    //need a sample db file for Transactions test with foreign keys
    /*@AfterClass
    public static void deleteDbFileAfterAllTests() {
        new File(TEST_DB_FILE).delete();
    }*/


    @Test
    public void getAll() {
        checkOnlyTheSampleItemsArePresentInDb();
    }


    @Test
    public void get() {
        TransactionsDto item1fromDb = dao.getAllByDateDesc().get(0);

        assertEquals(item1fromDb, dao.getById(item1fromDb.getId()).get());
    }

    @Test
    public void getByDateAsc() {
        List<TransactionsDto> itemsFromDb = dao.getAllByDateAsc();
        assertEquals(3, itemsFromDb.size());
        assertEquals("2018-05-01", itemsFromDb.get(0).getDate().toString());
    }

    @Test
    public void getByDateDesc() {
        List<TransactionsDto> itemsFromDb = dao.getAllByDateDesc();
        assertEquals(3, itemsFromDb.size());
        assertEquals("2018-05-03", itemsFromDb.get(0).getDate().toString());

    }

    @Test
    public void getByAmountAsc() {
        List<TransactionsDto> itemsFromDb = dao.getAllByAmountAsc();
        assertEquals(3, itemsFromDb.size());
        assertEquals(75.83, itemsFromDb.get(0).getAmount(), 0);
    }

    @Test
    public void getByAmountDesc() {
        List<TransactionsDto> itemsFromDb = dao.getAllByAmountDesc();
        assertEquals(3, itemsFromDb.size());
        assertEquals(500.0, itemsFromDb.get(0).getAmount(), 0);

    }

    @Test
    public void getByDate() {
        List<TransactionsDto> itemsFromDb = dao.getByDate("2018-05-03");
        assertEquals(1, itemsFromDb.size());
        assertEquals("2018-05-03", itemsFromDb.get(0).getDate().toString());

    }

    @Test
    public void getByDateInterval() {
        List<TransactionsDto> itemsFromDb = dao.getByDateInterval("2018-05-02", "2018-05-04");
        assertEquals(2, itemsFromDb.size());
        assertEquals("2018-05-02", itemsFromDb.get(0).getDate().toString());
        assertEquals("2018-05-03", itemsFromDb.get(1).getDate().toString());
    }

    @Test
    public void getByAmount() {
        List<TransactionsDto> itemsFromDb = dao.getByAmount(500);
        assertEquals(1, itemsFromDb.size());
        assertEquals(500.0, itemsFromDb.get(0).getAmount(), 0);
    }

    @Test
    public void get_forInvalidId() {
        assertFalse(dao.getById(-99).isPresent());
    }

    @Test
    public void insert() {
        assertEquals(3, dao.getAllByDateDesc().size());

        TransactionsDto newItem = new TransactionsDto(4, "2018-05-05", "sales", 34.8);
        dao.insert(newItem);

        assertEquals(4, dao.getAllByDateDesc().size());
    }

    private void checkOnlyTheSampleItemsArePresentInDb() {
        List<TransactionsDto> itemsFromDb = dao.getAllByDateDesc();
        assertEquals(3, itemsFromDb.size());

    }

    @Test
    public void updateDate() {
        TransactionsDto item1fromDb = dao.getAllByDateDesc().get(0);
        dao.updateDate(item1fromDb.getId(), "2018-05-05");
        assertEquals(Date.valueOf("2018-05-05"), dao.getAllByDateDesc().get(0).getDate());

    }

    @Test
    public void updateDetails() {
        TransactionsDto item1fromDb = dao.getAllByDateDesc().get(0);
        dao.updateDetails(item1fromDb.getId(), "test");
        assertEquals("test", dao.getAllByDateDesc().get(0).getDetails());

    }

    @Test
    public void updateAmount() {
        TransactionsDto item1fromDb = dao.getAllByDateDesc().get(0);
        dao.updateAmount(item1fromDb.getId(), 551);
        assertEquals(551, dao.getAllByDateDesc().get(0).getAmount(), 0);

    }

    @Test
    public void update_forInvalidId() {
        dao.updateDetails(-77, "updated");
        assertEquals(3, dao.getAllByDateDesc().size());
    }

    @Test
    public void deleteById() {
        List<TransactionsDto> itemsFromDb = dao.getAllByAmountDesc();
        dao.deleteById(itemsFromDb.get(0).getId());

        List<TransactionsDto> itemsInDBAfterDelete = dao.getAllByAmountDesc();
        assertEquals(2, itemsInDBAfterDelete.size());

    }

    @Test
    public void deleteByCat_id() {
        List<TransactionsDto> itemsFromDb = dao.getAllByAmountDesc();
        dao.deleteByCat_id(itemsFromDb.get(0).getCategory_id());

        List<TransactionsDto> itemsInDBAfterDelete = dao.getAllByAmountDesc();
        assertEquals(2, itemsInDBAfterDelete.size());

    }

    @Test
    public void delete_forInvalidId() {
        checkOnlyTheSampleItemsArePresentInDb();
        dao.deleteById(-66);
        checkOnlyTheSampleItemsArePresentInDb();
    }

    @Test
    public void deleteByDate() {
        List<TransactionsDto> itemsFromDb = dao.getAllByAmountDesc();
        dao.deleteByDate(itemsFromDb.get(0).getDate().toString());

        List<TransactionsDto> itemsInDBAfterDelete = dao.getAllByAmountDesc();
        assertEquals(2, itemsInDBAfterDelete.size());

    }

    @Test
    public void deleteByAmount() {
        List<TransactionsDto> itemsFromDb = dao.getAllByAmountDesc();
        dao.deleteByAmount(itemsFromDb.get(0).getAmount());

        List<TransactionsDto> itemsInDBAfterDelete = dao.getAllByAmountDesc();
        assertEquals(2, itemsInDBAfterDelete.size());

    }

    @Test
    public void getIncomeByDateInterval() {
        List<TransactionsDto> itemsFromDb = dao.getIncomeByDateInterval("2018-04-25", "2018-05-03");
        assertEquals(1, itemsFromDb.size());
        assertEquals("2018-05-01", itemsFromDb.get(0).getDate().toString());
        assertEquals(500, itemsFromDb.get(0).getAmount(), 0);
    }

    @Test
    public void getAllIncome() {
        List<TransactionsDto> itemsFromDb = dao.getAllIncome();
        assertEquals(1, itemsFromDb.size());
        assertEquals("2018-05-01", itemsFromDb.get(0).getDate().toString());
        assertEquals(500, itemsFromDb.get(0).getAmount(), 0);
    }

    @Test
    public void getExpensesByDateInterval() {
        List<TransactionsDto> itemsFromDb = dao.getExpensesByDateInterval("2018-04-25", "2018-05-02");
        assertEquals(1, itemsFromDb.size());
        assertEquals("2018-05-02", itemsFromDb.get(0).getDate().toString());
        assertEquals(150.47, itemsFromDb.get(0).getAmount(), 0);
    }

    @Test
    public void getAllExpenses() {
        List<TransactionsDto> itemsFromDb = dao.getAllExpenses();
        assertEquals(2, itemsFromDb.size());
        assertEquals("2018-05-02", itemsFromDb.get(0).getDate().toString());
        assertEquals(150.47, itemsFromDb.get(0).getAmount(), 0);
    }

    @Test
    public void incomeByDateInterval() {
        double itemsFromDb = dao.incomeByDateInterval("2018-05-01", "2018-05-02");
        assertEquals(500, itemsFromDb, 0);
    }

    @Test
    public void expenseByDateInterval() {
        double itemsFromDb = dao.expensesByDateInterval("2018-05-01", "2018-05-05");
        assertEquals(226.3, itemsFromDb, 0);

        double itemsFromDb2 = dao.expensesByDateInterval("2018-05-03", "2018-05-05");
        assertEquals(75.83, itemsFromDb2, 0);

    }

    @Test
    public void allIncome() {
        double itemsFromDb = dao.allIncome();
        assertEquals(500, itemsFromDb, 0);
    }

    @Test
    public void allExpenses() {
        double itemsFromDb = dao.allExpenses();
        assertEquals(226.3, itemsFromDb, 0);
    }

    @Test
    public void getBalanceByDateInterval() {
        double itemsFromDb = dao.balanceByDateInterval("2018-05-01", "2018-05-02");
        assertEquals(349.53, itemsFromDb, 0);
    }

    @Test
    public void getBalance() {
        double itemsFromDb = dao.balance();
        assertEquals(273.7, itemsFromDb, 0);
    }


}
