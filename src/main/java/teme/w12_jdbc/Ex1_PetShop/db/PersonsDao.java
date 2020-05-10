package teme.w12_jdbc.Ex1_PetShop.db;


import teme.w12_jdbc.Ex1_PetShop.DbManager;
import teme.w12_jdbc.Ex1_PetShop.dto.Gender;
import teme.w12_jdbc.Ex1_PetShop.dto.PersonsDto;

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

import static teme.w12_jdbc.Ex1_PetShop.db.PersonsTable.*;

public class PersonsDao {

    public static List<PersonsDto> getAll() {
        String sql = "SELECT * FROM " + NAME +
                " ORDER BY " + FLD_FIRST_NAME +
                " ASC ";
        List<PersonsDto> results = new ArrayList<>();
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

    public Optional<PersonsDto> getById(long id) {
        String sql = "SELECT * FROM " + NAME + " WHERE " + FLD_ID + " = ?";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setLong(1, id);
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    PersonsDto item = getItem(r);
                    return Optional.of(item);
                }
            }
        } catch (SQLException e) {
            System.err.println("An error occurred(@getById): " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    public void insert(PersonsDto person) {
        String sql = "INSERT INTO " + NAME + "(" + FLD_FIRST_NAME + ", "
                + FLD_LAST_NAME + ", " + FLD_AGE + ", " + FLD_GENDER + ")" +
                " VALUES(?,?,?,?)";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, person.getFirst_name());
            p.setString(2, person.getLast_name());
            p.setInt(3, person.getAge());
            p.setString(4, person.getGender().name());
            p.execute();
        } catch (SQLException e) {
            System.err.println("An error occurred(@insert): " + e.getLocalizedMessage());
        }
    }

    public void insertPersonsFromCsv() {
        String sql = "INSERT INTO " + NAME + "(" + FLD_FIRST_NAME + ", "
                + FLD_LAST_NAME + ", " + FLD_AGE + ", " + FLD_GENDER + ")" +
                " VALUES(?,?,?,?)";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            File file = new File("C:\\Users\\Marius\\Desktop\\teme_marius_closca\\src\\main\\java\\teme\\w12_jdbc\\Ex1_PetShop\\dto\\persons.csv");

            try (Scanner scanner = new Scanner(file)) {
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",\\s*");

                    p.setString(1, parts[0]);
                    p.setString(2, parts[1]);
                    p.setInt(3, Integer.parseInt(parts[2]));
                    p.setString(4, parts[3]);
                    p.execute();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("An error occurred(@insertPersonsFromCsv): " + e.getLocalizedMessage());
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM " + NAME + " WHERE " + FLD_ID + " = ?";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setLong(1, id);
            p.execute();
        } catch (SQLException e) {
            System.err.println("An error occurred(@delete): " + e.getLocalizedMessage());
        }
    }

    private static PersonsDto getItem(ResultSet r) throws SQLException {
        PersonsDto newItem = new PersonsDto();
        newItem.setId(r.getLong(FLD_ID));
        newItem.setFirst_name(r.getString(FLD_FIRST_NAME));
        newItem.setLast_name(r.getString(FLD_LAST_NAME));
        newItem.setAge(r.getInt(FLD_AGE));
        newItem.setGender(Gender.valueOf(r.getString(FLD_GENDER)));
        return newItem;
    }

}
