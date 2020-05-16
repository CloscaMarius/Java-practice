package teme.w14_web_pages.notes_app_web.db.service;

import teme.w14_web_pages.notes_app_web.db.DbManager;
import teme.w14_web_pages.notes_app_web.db.dto.CategoryDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static teme.w14_web_pages.notes_app_web.db.dto.Priority.*;
import static teme.w14_web_pages.notes_app_web.db.dto.State.ACTIVE;
import static teme.w14_web_pages.notes_app_web.db.dto.State.COMPLETED;

/**
 * Initializes the DB as needed - creates missing tables, etc..
 * Should be called once, on app startup.
 */
public class DbInitService {

    private static final String CREATE_CATEGORIES_SQL = "CREATE TABLE IF NOT EXISTS CATEGORIES ( " +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "DESCRIPTION TEXT NOT NULL UNIQUE" +
            ");";

    private static final String CREATE_NOTES_SQL = "CREATE TABLE IF NOT EXISTS NOTES ( " +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "DESCRIPTION TEXT NOT NULL, " +
            "CATEGORY_ID TEXT REFERENCES CATEGORIES(ID)," +
            "DUE_DATE DATETIME," +
            //field + constraint to limit its values only to values of Priority enum
            "PRIORITY TEXT CHECK( PRIORITY IN ('" + LOW + "', '" + MEDIUM + "', '" + HIGH + "')) NOT NULL," +
            //field + constraint to limit its values only to values of State enum
            "STATE TEXT CHECK( STATE IN ('" + ACTIVE + "', '" + COMPLETED + "')) NOT NULL," +
            //extra constraint, to avoid duplicate notes
            " CONSTRAINT DESC_DATE_UQ UNIQUE (DESCRIPTION, DUE_DATE)" +
            ");";

    public static void createTablesAndInitialData() {
        createMissingTables();
        insertInitialData();
    }

    private static void createMissingTables() {
        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement()) {

            st.execute(CREATE_CATEGORIES_SQL);
            st.execute(CREATE_NOTES_SQL);

        } catch (SQLException e) {
            System.err.println("Error creating missing tables: " + e.getMessage());
        }
    }

    private static void insertInitialData() {
        CategoryDao catDao = new CategoryDao();
        if (catDao.getAll().isEmpty()) { //add only if empty db
            catDao.insert(new CategoryDto(1, "personal"));
            catDao.insert(new CategoryDto(2, "work"));
        }
    }
}
