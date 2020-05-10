package teme.w12_jdbc.Ex1_PetShop;

import teme.w12_jdbc.Ex1_PetShop.db.PersonsDao;
import teme.w12_jdbc.Ex1_PetShop.db.Pet_TypesDao;
import teme.w12_jdbc.Ex1_PetShop.db.PetsDao;
import teme.w12_jdbc.Ex1_PetShop.dto.Gender;
import teme.w12_jdbc.Ex1_PetShop.dto.PersonsDto;
import teme.w12_jdbc.Ex1_PetShop.dto.Pet_TypesDto;
import teme.w12_jdbc.Ex1_PetShop.dto.PetsDto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Runner {
    public static void main(String[] args) {
        DbInitService.createMissingTables();
        //DbInitService.deleteAllTables();

        PersonsDao dao = new PersonsDao();
        System.out.println(dao.getAll());

        PersonsDto item1 = new PersonsDto("Mark", "Fisher", 24, Gender.M);
        dao.insert(item1);
        Optional<PersonsDto> maybeItem = dao.getAll().stream().filter(o -> o.getFirst_name().equals("Mark")).findFirst();
        System.out.println(dao.getById(maybeItem.get().getId()));

        dao.insertPersonsFromCsv();

        List<PersonsDto> allPersons = PersonsDao.getAll();

        Pet_TypesDao petsType = new Pet_TypesDao();
        petsType.insertTypeFromCsv();
        List<Pet_TypesDto> allTypes = Pet_TypesDao.getAll();
        PetsDao petsDao = new PetsDao();
        petsDao.insertPetsFromCsv(allPersons, allTypes);
        PersonsDto persForUpdate = new PersonsDto("Clara", "Rar", 12, Gender.F);
        dao.insert(persForUpdate);
        List<PersonsDto> allPer = PersonsDao.getAll();

        petsDao.updatePersonIdForPet(6, 6);
        List<PetsDto> allPets = petsDao.getAll();
        System.out.println("\nAll pets after update: ");
        System.out.println(Arrays.asList(allPets));

        System.out.println("\nAll same type pets: ");
        System.out.println(petsDao.getByTypeId(43));
    }
}
