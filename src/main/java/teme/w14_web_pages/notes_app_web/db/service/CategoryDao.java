package teme.w14_web_pages.notes_app_web.db.service;

import teme.w14_web_pages.notes_app_web.db.DbManager;
import teme.w14_web_pages.notes_app_web.db.dto.CategoryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    /**
     * Load list of categories from DB (all found)
     */
    public List<CategoryDto> getAll() {

        String sql = "SELECT * FROM CATEGORIES ORDER BY ID";

        List<CategoryDto> categs = new ArrayList<>();

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                categs.add(extractNoteFromResult(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error loading all notes: " + e.getMessage());
        }

        return categs;
    }

    private CategoryDto extractNoteFromResult(ResultSet rs) throws SQLException {

        long id = rs.getLong("ID");
        String description = rs.getString("DESCRIPTION");

        return new CategoryDto(id, description);
    }

    /**
     * Add a new category to DB
     */
    public void insert(CategoryDto categ) {

        String sql = "INSERT INTO CATEGORIES (DESCRIPTION) VALUES(?)";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categ.getDescription());
            ps.execute();

        } catch (SQLException e) {
            System.err.println("Error inserting in db category " + categ + " : " + e.getMessage());
        }
    }

    /**
     * Update an existing category in DB
     */
    public void update(CategoryDto categ) {

        String sql = "UPDATE CATEGORIES SET DESCRIPTION = ? WHERE ID = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categ.getDescription());
            ps.setLong(2, categ.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error while updating category " + categ + " : " + e.getMessage());
        }
    }

    /**
     * Delete a category from DB (by id)
     */
    public void delete(long id) {

        String sql = "DELETE FROM CATEGORIES WHERE ID = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.execute();

        } catch (SQLException e) {
            System.err.println("Error while deleting category " + id + ": " + e.getMessage());
        }
    }
}
