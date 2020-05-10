package teme.w12_jdbc.Ex0_TodoList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Initializes the DB as needed - creates missing tables, etc..
 * Should be called once, on app startup.
 */
public class DbInitService {

    public static void createMissingTables() {
        String sql = "create table if not exists todo (" +
                "    id integer primary key autoincrement," +
                "    description text not null unique," +
                "    priority text check (priority in ('LOW', 'MEDIUM', 'HIGH')) not null," +
                "    due_date datetime," +
                "    state text check (state in ('ACTIVE', 'COMPLETED')) not null" +
                ")";

        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error creating missing tables: " + e.getMessage());
        }
    }

    public static void deleteAllTables() {
        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement()) {
            st.execute("drop table if exists todo");
        } catch (SQLException e) {
            System.err.println("Error deleting tables: " + e.getMessage());
        }
    }
}
