package teme.w12_jdbc.Ex0_TodoList.db;

import teme.w12_jdbc.Ex0_TodoList.DbManager;
import teme.w12_jdbc.Ex0_TodoList.dto.Priority;
import teme.w12_jdbc.Ex0_TodoList.dto.State;
import teme.w12_jdbc.Ex0_TodoList.dto.ToDoItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static teme.w12_jdbc.Ex0_TodoList.db.TodoTable.*;

public class TodoDao {

    public List<ToDoItemDto> getAll() {
        String sql = "SELECT * FROM " + NAME +
                " ORDER BY " + FLD_DUE_DATE + ", "
                + FLD_PRIORITY + " DESC";
        List<ToDoItemDto> results = new ArrayList<>();
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql);
             ResultSet r = p.executeQuery()) {
            while (r.next()) {
                results.add(getItem(r));
            }
        } catch (SQLException e) {
            System.err.println("An error occurred: " + e.getLocalizedMessage());
        }
        return results;
    }

    public Optional<ToDoItemDto> getById(long id) {
        String sql = "SELECT * FROM " + NAME + " WHERE " + FLD_ID + " = ?";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setLong(1, id);
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    ToDoItemDto item = getItem(r);
                    return Optional.of(item);
                }
            }
        } catch (SQLException e) {
            System.err.println("An error occurred: " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    public void insert(ToDoItemDto item) {
        String sql = "INSERT INTO " + NAME + "(" + FLD_DESC + ", " + FLD_PRIORITY
                + ", " + FLD_DUE_DATE + ", " + FLD_STATE + ")" +
                " VALUES(?,?,?,?)";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, item.getDescription());
            p.setString(2, item.getPriority().name());
            p.setDate(3, item.getDueDate());
            p.setString(4, item.getState().name());
            p.execute();
        } catch (SQLException e) {
            System.err.println("An error occurred: " + e.getLocalizedMessage());
        }
    }

    public void updateState(long id, State state) {
        String sql = "UPDATE " + NAME + " SET " + FLD_STATE + " = ? WHERE " + FLD_ID + " = ?";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, state.name());
            p.setLong(2, id);
            p.execute();
        } catch (SQLException e) {
            System.err.println("An error occurred: " + e.getLocalizedMessage());
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM " + NAME + " WHERE " + FLD_ID + " = ?";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setLong(1, id);
            p.execute();
        } catch (SQLException e) {
            System.err.println("An error occurred: " + e.getLocalizedMessage());
        }
    }

    private ToDoItemDto getItem(ResultSet r) throws SQLException {
        ToDoItemDto newItem = new ToDoItemDto();
        newItem.setId(r.getLong(FLD_ID));
        newItem.setDescription(r.getString(FLD_DESC));
        newItem.setDueDate(r.getDate(FLD_DUE_DATE));
        newItem.setPriority(Priority.valueOf(r.getString(FLD_PRIORITY)));
        newItem.setState(State.valueOf(r.getString(FLD_STATE)));
        return newItem;
    }
}
