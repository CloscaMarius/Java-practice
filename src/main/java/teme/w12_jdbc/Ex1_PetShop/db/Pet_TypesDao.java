package teme.w12_jdbc.Ex1_PetShop.db;

import teme.w12_jdbc.Ex1_PetShop.DbManager;
import teme.w12_jdbc.Ex1_PetShop.dto.Pet_TypesDto;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static teme.w12_jdbc.Ex1_PetShop.db.Pet_TypesTable.*;

public class Pet_TypesDao {

    public static List<Pet_TypesDto> getAll() {
        String sql = "SELECT * FROM " + NAME;

        List<Pet_TypesDto> results = new ArrayList<>();
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql);
             ResultSet r = p.executeQuery()) {
            while (r.next()) {
                results.add(getItem(r));
            }
        } catch (SQLException e) {
            System.err.println("An error occurred(@getAll): " + e.getLocalizedMessage());
        }
        return results;
    }

    public Optional<Pet_TypesDto> getById(long id) {
        String sql = "SELECT * FROM " + NAME + "WHERE" + FLD_ID + " = ?";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setLong(1, id);
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    Pet_TypesDto item = getItem(r);
                    return Optional.of(item);
                }
            }
        } catch (SQLException e) {
            System.err.println("An error occurred(@getById): " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    public void insert(Pet_TypesDto petType) {
        String sql = "INSERT INTO " + NAME + "(" + FLD_DESC + ")" +
                " VALUES(?)";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, petType.getDescription());
            p.execute();
        } catch (SQLException e) {
            System.err.println("An error occurred(@insert): " + e.getLocalizedMessage());
        }
    }

    public void insertTypeFromCsv() {
        String sql = "INSERT INTO " + NAME + "(" + FLD_ID + ", " + FLD_DESC + ")" +
                " VALUES(?,?)";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            File file = new File("C:\\Users\\Marius\\Desktop\\teme_marius_closca\\src\\main\\java\\teme\\w12_jdbc\\Ex1_PetShop\\dto\\petsType.csv");

            try (Scanner scanner = new Scanner(file)) {
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",\\s*");

                    p.setLong(1, Long.parseLong(parts[0]));
                    p.setString(2, parts[1]);
                    p.execute();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("An error occurred(@insertTypeFromCsv): " + e.getLocalizedMessage());
        }
    }

    public void delete(long id) {
        String sql = "SELECT * FROM " + NAME + " WHERE " + FLD_ID + " = ?";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setLong(1, id);
            p.execute();
        } catch (SQLException e) {
            System.err.println("An error occurred(@delete): " + e.getLocalizedMessage());
        }
    }

    private static Pet_TypesDto getItem(ResultSet r) throws SQLException {
        Pet_TypesDto newItem = new Pet_TypesDto();
        newItem.setId(r.getLong(FLD_ID));
        newItem.setDescription(r.getString(FLD_DESC));
        return newItem;
    }
}
