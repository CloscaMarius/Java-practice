package teme.w14_web_pages.notes_app_web.db.service;

import teme.w14_web_pages.notes_app_web.db.dto.CategoryDto;
import teme.w14_web_pages.notes_app_web.db.dto.NoteDto;
import teme.w14_web_pages.notes_app_web.db.dto.Priority;
import teme.w14_web_pages.notes_app_web.db.dto.State;

import java.sql.Date;
import java.util.List;

/**
 * Example of some manual tests for NoteDAO.
 * <p>
 * Note: this can be used for easier manual testing,
 * but should normally be removed once we have full junit tests
 * (see the proper JUnit test: NoteDAOTest)
 */
public class NoteDao_TempManualTest {

    public static void main(String[] args) {

        //--- CATEGORIES ---//
        CategoryDao catDao = new CategoryDao();
        System.out.println("Current categories: " + catDao.getAll());
        System.out.println("\nInserting a new categ...");
        CategoryDto categ = new CategoryDto("default");
        catDao.insert(categ);
        List<CategoryDto> categs = catDao.getAll();
        System.out.println("Categories after insert: " + categ);

        long catId = categs.get(0).getId();
        CategoryDto updatedCateg = new CategoryDto(catId, "work");
        catDao.update(updatedCateg);
        System.out.println("Categories after update: " + categ);


        //--- NOTES ---//
        NoteDao dao = new NoteDao();

        List<NoteDto> notes = dao.getAll();
        System.out.println("\nCurrent notes: " + notes.size());
        notes.forEach(System.out::println);

        System.out.println("\nInserting a new note...");
        //build a new note - I don't have an ID yet (to set)
        NoteDto newNote = new NoteDto(
                "drink",
                catId,
                new Date(System.currentTimeMillis()),
                Priority.HIGH,
                State.ACTIVE);
        dao.insert(newNote);

        notes = dao.getAll();
        newNote = notes
                .stream()
                .filter(i -> i.getDescription().equalsIgnoreCase("drink"))
                .findFirst().orElse(null);
        System.out.println("Newest inserted note (from db, including id): " + newNote);

        System.out.println("\nUpdating description of newest note...");
        NoteDto updatedNote = new NoteDto(
                newNote.getId(),
                "drink and sleep", //UPDATED description!
                catId,
                newNote.getDueDate(), newNote.getPriority(), newNote.getState());
        dao.update(updatedNote);

        updatedNote = dao.get(updatedNote.getId()).orElse(null);
        System.out.println("Updated note: " + newNote);
        notes = dao.getAll();
        System.out.println("Current list size: " + notes.size());

        System.out.println("\nDeleting newest note...");
        dao.delete(newNote.getId());
        notes = dao.getAll();
        System.out.println("Current list size after delete: " + notes.size());

        //cleanup categs
        catDao.delete(catId);
        System.out.println("Categories after delete: " + categ);
    }
}
