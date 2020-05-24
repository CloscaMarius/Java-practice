package teme.w14_web_pages.notes_web_service.db.service;

import teme.w14_web_pages.notes_web_service.db.DbManager;
import teme.w14_web_pages.notes_web_service.db.dto.NoteDto;
import teme.w14_web_pages.notes_web_service.db.dto.Priority;
import teme.w14_web_pages.notes_web_service.db.dto.State;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static teme.w14_web_pages.notes_web_service.db.service.NotesTable.*;

/**
 * Simple DAO which take cares of loading/persisting objects of type NoteDTO to db.
 */
public class NoteDao {

    /**
     * Load list of notes from DB (all found)
     */
    public List<NoteDto> getAll() {

        String sql = "SELECT *" +
                " FROM " + TABLE_NAME +
                " ORDER BY " + FLD_DUE_DATE + " DESC, " + FLD_PRIORITY;

        List<NoteDto> notes = new ArrayList<>();

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                notes.add(extractNoteFromResult(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error loading all notes: " + e.getMessage());
        }

        return notes;
    }

    /**
     * Load one specific note from DB (by id)
     */
    public Optional<NoteDto> get(long id) {

        String sql = "SELECT *" +
                " FROM " + TABLE_NAME +
                " WHERE " + FLD_ID + " = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    NoteDto note = extractNoteFromResult(rs);
                    return Optional.of(note);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error loading note with id " + id + " : " + e.getMessage());
        }
        return Optional.empty(); //default value
    }

    private NoteDto extractNoteFromResult(ResultSet rs) throws SQLException {

        long id = rs.getLong(FLD_ID);
        String description = rs.getString(FLD_DESCRIPTION);
        Date dueDate = rs.getDate(FLD_DUE_DATE);

        //these ones need to be translated from String to their enum value
        Priority priority = Priority.valueOf(rs.getString(FLD_PRIORITY));
        State state = State.valueOf(rs.getString(FLD_STATE));

        return new NoteDto(id, description, dueDate, priority, state);
    }


    /**
     * Add a new note to DB
     */
    public void insert(NoteDto note) {

        String sql = "INSERT INTO " + TABLE_NAME +
                " (" + FLD_DESCRIPTION + ", " + FLD_PRIORITY + ", " + FLD_DUE_DATE + ", " + FLD_STATE + ")" +
                " VALUES(?,?,?,?)";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, note.getDescription());
            ps.setString(2, note.getPriority().name());
            ps.setDate(3, note.getDueDate());
            ps.setString(4, note.getState().name());

            ps.execute();

        } catch (SQLException e) {
            System.err.println("Error inserting in db note " + note + " : " + e.getMessage());
        }
    }

    /**
     * Update an existing note in DB
     */
    public void update(NoteDto note) {

        String sql = "UPDATE " + TABLE_NAME +
                " SET " + FLD_DESCRIPTION + " = ?, " +
                FLD_PRIORITY + " = ?, " +
                FLD_DUE_DATE + " = ?, " +
                FLD_STATE + " = ? " +
                " WHERE " + FLD_ID + " = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            //set params for the prepared statement (based on dto data)
            ps.setString(1, note.getDescription());
            ps.setString(2, note.getPriority().name());
            ps.setDate(3, note.getDueDate());
            ps.setString(4, note.getState().name());
            ps.setLong(5, note.getId());

            //execute it (no results to read after this one)
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error while updating note " + note + " : " + e.getMessage());
        }
    }

    /**
     * Delete a note from DB (by id)
     */
    public void delete(long id) {

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + FLD_ID + " = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            //set params for the prepared statement
            ps.setLong(1, id);

            //execute it (no results to read after this one)
            ps.execute();

        } catch (SQLException e) {
            System.err.println("Error while deleting note " + id + ": " + e.getMessage());
        }
    }
}