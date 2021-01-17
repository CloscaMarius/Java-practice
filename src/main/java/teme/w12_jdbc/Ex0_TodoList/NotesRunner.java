package teme.w12_jdbc.Ex0_TodoList;

import teme.w12_jdbc.Ex0_TodoList.db.TodoDao;
import teme.w12_jdbc.Ex0_TodoList.dto.Priority;
import teme.w12_jdbc.Ex0_TodoList.dto.State;
import teme.w12_jdbc.Ex0_TodoList.dto.ToDoItemDto;

import java.util.Optional;

public class NotesRunner {
    public static void main(String[] args) {
        DbInitService.deleteAllTables();
        DbInitService.createMissingTables();

        TodoDao dao = new TodoDao();
        System.out.println(dao.getAll());
        ToDoItemDto item1 = new ToDoItemDto("first item", Priority.LOW, null, State.ACTIVE);
        dao.insert(item1);
        Optional<ToDoItemDto> maybeItem = dao.getAll().stream().filter(o -> o.getDescription().equals("first item")).findFirst();
        System.out.println(dao.getById(maybeItem.get().getId()));
    }
}
