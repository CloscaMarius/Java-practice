package teme.w12_jdbc.Ex0_TodoList;


import org.junit.*;
import teme.w12_jdbc.Ex0_TodoList.db.TodoDao;
import teme.w12_jdbc.Ex0_TodoList.dto.Priority;
import teme.w12_jdbc.Ex0_TodoList.dto.State;
import teme.w12_jdbc.Ex0_TodoList.dto.ToDoItemDto;

import java.util.Optional;

public class Ex0_TodoListTest {

    private static final String TEST_DESCRIPTION = "test_description";

    @BeforeClass // before any of the tests
    public static void switchToTestDb() {
        DbManager.setDbFile("w12_todo_test.db");
    }

    @AfterClass // after ALL the tests
    public static void teardown() {
        // probably remove db test file
    }

    @Before // before each test (method with @Test)
    public void createMissingTables() {
        DbInitService.createMissingTables();
    }

    @After // after each test
    public void deleteTables() {
        DbInitService.deleteAllTables();
    }

    @Test
    public void testSomethingElse() {

    }

    @Test
    public void test() {
        // 1. check not exists - getAll - filter for TEST_DESCRIPTION
        // 2. create (with TEST_DESCRIPTION)
        // 3. check created - getAll - filter for TEST_DESCRIPTION (check that exists and store)
        // 4. get by id - check with previous object (test loaded object is equal to the one from
        //    step 3)
        // 5. update
        // 6. check updated - get by id and check updated fields are loaded
        // 7. delete
        // 8. check it does not exist anymore - getAll - filter for TEST_DESCRIPTION and check
        //    that it doesn't exist anymore
        TodoDao dao = new TodoDao();
        ToDoItemDto testObj = getTestObj();

        // 1
        Optional<ToDoItemDto> maybeItem = dao.getAll().stream()
                .filter(o -> o.getDescription().equals(TEST_DESCRIPTION)).findAny();
        Assert.assertFalse(maybeItem.isPresent());

        // 2
        dao.insert(testObj);
        maybeItem = dao.getAll().stream().filter(o -> o.getDescription().equals(TEST_DESCRIPTION)).findAny();

        // 3
        Assert.assertTrue(maybeItem.isPresent());
        Optional<ToDoItemDto> maybeItemAgain = dao.getById(maybeItem.get().getId());
        // 4
        Assert.assertEquals(maybeItem.get(), maybeItemAgain.get());
        // 5
        dao.updateState(maybeItem.get().getId(), State.COMPLETED);
        // 6
        maybeItemAgain = dao.getById(maybeItem.get().getId());
        Assert.assertEquals(State.COMPLETED, maybeItemAgain.get().getState());
        // 7
        dao.delete(maybeItem.get().getId());
        maybeItem = dao.getById(maybeItem.get().getId());
        // 8
        Assert.assertTrue(maybeItem.isEmpty());
    }

    private ToDoItemDto getTestObj() {
        return new ToDoItemDto(TEST_DESCRIPTION, Priority.HIGH, null, State.ACTIVE);
    }
}
