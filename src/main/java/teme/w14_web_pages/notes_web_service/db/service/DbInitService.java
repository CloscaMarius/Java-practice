package teme.w14_web_pages.notes_web_service.db.service;

import teme.w14_web_pages.notes_web_service.db.DbManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static teme.w14_web_pages.notes_web_service.db.dto.Priority.*;
import static teme.w14_web_pages.notes_web_service.db.dto.State.ACTIVE;
import static teme.w14_web_pages.notes_web_service.db.dto.State.COMPLETED;
import static teme.w14_web_pages.notes_web_service.db.service.NotesTable.*;

/**
 * Initializes the DB as needed - creates missing tables, etc..
 * Should be called once, on app startup.
 */
public class DbInitService {

    public static void createMissingTables() {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " +

                FLD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FLD_DESCRIPTION + " TEXT NOT NULL, " +
                FLD_DUE_DATE + " DATETIME," +

                //field + constraint to limit its values only to values of Priority enum
                FLD_PRIORITY + " TEXT CHECK( " + FLD_PRIORITY + " IN ('" + LOW + "', '" + MEDIUM + "', '" + HIGH + "')) NOT NULL," +

                //field + constraint to limit its values only to values of State enum
                FLD_STATE + " TEXT CHECK (" + FLD_STATE + " IN ('" + ACTIVE + "', '" + COMPLETED + "')) NOT NULL," +

                //extra constraint, to avoid duplicate notes
                " CONSTRAINT DESC_DATE_UQ UNIQUE (" + FLD_DESCRIPTION + ", " + FLD_DUE_DATE + "));";

        try (Connection conn = DbManager.getConnection();
             Statement st = conn.createStatement()) {

            st.execute(sql);

        } catch (SQLException e) {
            System.err.println("Error creating missing tables: " + e.getMessage());
        }
    }
}
