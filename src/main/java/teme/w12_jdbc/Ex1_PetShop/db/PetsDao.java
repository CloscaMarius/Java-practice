package teme.w12_jdbc.Ex1_PetShop.db;

import teme.w12_jdbc.Ex1_PetShop.DbManager;
import teme.w12_jdbc.Ex1_PetShop.dto.Gender;
import teme.w12_jdbc.Ex1_PetShop.dto.PersonsDto;
import teme.w12_jdbc.Ex1_PetShop.dto.Pet_TypesDto;
import teme.w12_jdbc.Ex1_PetShop.dto.PetsDto;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static teme.w12_jdbc.Ex1_PetShop.db.PetsTable.*;

public class PetsDao {

    public List<PetsDto> getAll() {
        String sql = "SELECT * FROM " + NAME +
                " ORDER BY " + FLD_BIRTH_DATE +
                " DESC ";
        List<PetsDto> results = new ArrayList<>();
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql);
             ResultSet r = p.executeQuery()) {
            while (r.next()) {
                results.add(getItem(r));
            }
        } catch (SQLException e) {
            System.err.println("An error occurred(getAll): " + e.getLocalizedMessage());
        }
        return results;
    }

    public List<PetsDto> getAllOwnedPets() {
        String sql = "SELECT " + NAME + "." + FLD_NAME + ", " +
                Pet_TypesTable.NAME + "." + Pet_TypesTable.FLD_DESC + ", " +
                PersonsTable.NAME + "." + PersonsTable.FLD_FIRST_NAME + "||\" \"||" +
                PersonsTable.NAME + "." + PersonsTable.FLD_LAST_NAME + " AS owner, " +
                PersonsTable.NAME + "." + PersonsTable.FLD_AGE + ", " +
                PersonsTable.NAME + "." + PersonsTable.FLD_GENDER +
                " FROM " + NAME +
                " JOIN " + PersonsTable.NAME +
                " ON " + PersonsTable.FLD_ID + " = " + FLD_PERSON_ID +
                " JOIN " + Pet_TypesTable.NAME +
                " ON " + Pet_TypesTable.FLD_ID + " = " + FLD_TYPE_ID;

        List<PetsDto> results = new ArrayList<>();
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

    public Optional<PetsDto> getById(long id) {
        String sql = "SELECT * FROM " + NAME + " WHERE " + FLD_ID + " = ?";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setLong(1, id);
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    PetsDto item = getItem(r);
                    return Optional.of(item);
                }
            }
        } catch (SQLException e) {
            System.err.println("An error occurred(@getById): " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    public List<PetsDto> getByTypeId(long id) {
        String sql = "SELECT * FROM " + NAME + " WHERE " + FLD_TYPE_ID + " = ?";
        List<PetsDto> results = new ArrayList<>();
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setLong(1, id);
            try (ResultSet r = p.executeQuery()) {
                while (r.next()) {
                    results.add(getItem(r));
                }
            }
        } catch (SQLException e) {
            System.err.println("An error occurred(@getByTypeId): " + e.getLocalizedMessage());
        }
        return results;
    }

    public void insert(PetsDto pet) {
        String sql = "INSERT INTO " + NAME + "(" + FLD_TYPE_ID + ", "
                + FLD_NAME + ", " + FLD_BIRTH_DATE + ", " + FLD_GENDER + ", "
                + FLD_PERSON_ID + ")" + " VALUES(?,?,?,?,?)";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setLong(1, pet.getType_id());
            p.setString(2, pet.getName());
            p.setDate(3, pet.getBirth_date());
            p.setString(4, pet.getGender().name());
            p.setLong(5, pet.getPerson_id());
            p.execute();
        } catch (SQLException e) {
            System.err.println("An error occurred(@insert): " + e.getLocalizedMessage());
        }
    }

    public void insertPetsFromCsv(List<PersonsDto> allPersons, List<Pet_TypesDto> allTypes) {
        String sql = "INSERT INTO " + NAME + "(" + FLD_TYPE_ID + ", "
                + FLD_NAME + ", " + FLD_BIRTH_DATE + ", " + FLD_GENDER + ", "
                + FLD_PERSON_ID + ")" + " VALUES(?,?,?,?,?)";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            File file = new File("src/main/java/teme/w12_jdbc/Ex1_PetShop/dto/pets.csv");

            try (Scanner scanner = new Scanner(file)) {

                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",\\s*");

                    int count1 = 0;
                    for (Pet_TypesDto type : allTypes) {
                        if (type.getId() == Long.parseLong(parts[0])) {
                            p.setLong(1, Long.parseLong(parts[0]));
                            count1++;
                        }
                    }
                    if (count1 == 0) {
                        p.setNull(1, Types.INTEGER);
                    }

                    p.setString(2, parts[1]);
                    DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        java.util.Date dobj = dFormat.parse(parts[2]);
                        java.sql.Date dobDate = new java.sql.Date(dobj.getTime());
                        p.setDate(3, dobDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    p.setString(4, parts[3]);
                    int count2 = 0;
                    for (PersonsDto pers : allPersons) {
                        if (pers.getId() == Integer.parseInt(parts[4])) {
                            p.setLong(5, pers.getId());
                            count2++;
                        }
                    }

                    if (count2 == 0) {
                        p.setNull(5, Types.INTEGER);
                    }

                    p.execute();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("An error occurred(@insertcsvFromPets): " + e.getLocalizedMessage());
        }
    }

    public void updatePersonIdForPet(long petId, long personId) {

        String sql = "UPDATE " + NAME + " SET " + FLD_PERSON_ID + " = ? WHERE " + FLD_ID + " = ?";
        try (Connection c = DbManager.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setLong(1, personId);
            p.setLong(2, petId);
            p.execute();
        } catch (SQLException e) {
            System.err.println("An error occurred(@updatePersonIdForPet): " + e.getLocalizedMessage());
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

    private PetsDto getItem(ResultSet r) throws SQLException {
        PetsDto newItem = new PetsDto();
        newItem.setId(r.getLong(FLD_ID));
        newItem.setType_id(r.getLong(FLD_TYPE_ID));
        newItem.setName(r.getString(FLD_NAME));
        newItem.setBirth_date(r.getDate(FLD_BIRTH_DATE));
        newItem.setGender(Gender.valueOf(r.getString(FLD_GENDER)));
        newItem.setPerson_id(r.getLong(FLD_PERSON_ID));
        return newItem;
    }

}
