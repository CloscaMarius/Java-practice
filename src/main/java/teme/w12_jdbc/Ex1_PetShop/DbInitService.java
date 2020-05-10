package teme.w12_jdbc.Ex1_PetShop;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInitService {

    public static void createMissingTables() {
        String sqlPerson = "create table if not exists persons (" +
                "    id integer primary key autoincrement," +
                "    first_name text not null," +
                "    last_name text not null," +
                "    age integer not null," +
                "    gender text check (gender in ('M', 'F')) not null" +
                ")";

        String sqlPet_Type = "create table if not exists pet_types (" +
                "    id integer primary key autoincrement," +
                "    description text not null" +
                ")";

        String sqlPet = "create table if not exists pets (" +
                "    id integer primary key autoincrement," +
                "    type_id references pet_types(id) not null," +
                "    name text not null," +
                "    birth_date datetime not null," +
                "    gender text check (gender in ('M', 'F')) not null," +
                "    person_id references persons(id)" +
                ")";

        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement()) {
            st.execute(sqlPerson);
            st.execute(sqlPet_Type);
            st.execute(sqlPet);
        } catch (SQLException e) {
            System.err.println("Error creating missing tables: " + e.getMessage());
        }

    }

    public static void deleteAllTables() {
        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement()) {
            st.execute("drop table if exists persons");
            st.execute("drop table if exists pet_types");
            st.execute("drop table if exists pets");
        } catch (SQLException e) {
            System.err.println("Error deleting tables: " + e.getMessage());
        }
    }

}
