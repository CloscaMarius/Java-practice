package teme.w14_web_pages.notes_web_service;

import com.google.gson.Gson;
import teme.w14_web_pages.notes_web_service.db.dto.NoteDto;
import teme.w14_web_pages.notes_web_service.db.dto.Priority;
import teme.w14_web_pages.notes_web_service.db.dto.State;
import teme.w14_web_pages.notes_web_service.db.service.DbInitService;
import teme.w14_web_pages.notes_web_service.db.service.NoteDao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static spark.Spark.*;

/**
 * Example of a web service API, allowing CRUD functionality for Notes app
 */
public class NotesWebService {

    public static void main(String[] args) {

        //---- INIT DB ----//
        DbInitService.createMissingTables();
        NoteDao dao = new NoteDao();
        addSampleNotes(dao);

        //---- REST API -----//
        // CRUD operations to implement:
        // - Get all notes:    GET    /notes     -> return list of all notes (as list of JSON objects, type NoteDTO)
        // - Get note details: GET    /notes/:id -> return note details, or error (404) if not found
        // - Add a new note:   POST   /notes     -> create new (use body as json)
        // - Update a note:    POST   /notes/:id
        // - Delete a note:    DELETE /notes/:id


        //--- GET ALL NOTES ---//
        get("/notes", (request, response) -> {
            response.type("application/json");
            List<NoteDto> notesList = dao.getAll();
            return new Gson().toJson(notesList);
        });


        //--- GET ONE SPECIFIC NOTE ---//
        get("/notes/:id", (request, response) -> {
            response.type("application/json");

            String idAsString = request.params("id");
            try {
                long id = Long.parseLong(idAsString);

                Optional<NoteDto> noteOptional = dao.get(id);

                if (noteOptional.isPresent()) {
                    NoteDto note = noteOptional.get();
                    return new Gson().toJson(note);
                } else {
                    response.status(404);
                    return "Note with id " + id + " not found!";
                }
            } catch (Exception e) {
                response.status(400);
                return "Error while loading note with id " + idAsString
                        + ": " + e;
            }
        });


        /* --- CREATE NEW NOTE ---
           Example request:
             POST http://localhost:4567/notes
             Body:
                    {
                        "description": "de iesit la plimbare iar",
                        "dueDate" : "May 12, 2020",
                        "priority": "LOW",
                        "state": "ACTIVE"
                    }
        */
        post("/notes", (request, response) -> {
            response.type("application/json");

            NoteDto note = new Gson().fromJson(request.body(), NoteDto.class);

            dao.insert(note);

            response.status(201); //Created
            return "Note created";
        });


        //--- UPDATE EXISTING NOTE ---//
        //Similar to create
        put("/notes/:id", (request, response) -> {
            response.type("application/json");

            String idAsString = request.params("id");
            String body = request.body();
            NoteDto noteToUpdate = new Gson().fromJson(body, NoteDto.class);
            try {
                long id = Long.parseLong(idAsString);
                Optional<NoteDto> noteDto = dao.get(id);
                if (!noteDto.isPresent()) {
                    response.status(404);
                    return "Note with id " + id + " not found";
                }
                dao.update(noteToUpdate);
                return "Note with id : " + id + " updated";
            } catch (Exception e) {
                response.status(400);
                return "Error loading note with id " + idAsString + " :" + e;
            }
        });


        //--- DELETE EXISTING NOTE ---//
        delete("/notes/:id", (request, response) -> {
            response.type("application/json");
            String idAsString = request.params("id");
            try {
                long id = Long.parseLong(idAsString);
                Optional<NoteDto> noteDto = dao.get(id);
                if (noteDto.isPresent()) {
                    dao.delete(id);
                    return "Note with id " + id + " was deleted";
                } else {
                    response.status(404);
                    return "Note with id " + id + " not found";
                }
            } catch (NumberFormatException e) {
                response.status(400);
                return "Error loading note with id " + idAsString + " :" + e;
            }
        });
    }

    private static void addSampleNotes(NoteDao dao) {
        //---- setup, add test notes ----
        DbInitService.createMissingTables();

        //insert some test notes (if db is empty)
        if (dao.getAll().isEmpty()) {
            dao.insert(
                    new NoteDto(-1,
                            "de participat la curs",
                            new Date(System.currentTimeMillis()),
                            Priority.MEDIUM, State.COMPLETED));
            dao.insert(
                    new NoteDto(-1,
                            "de reluat ce am facut in clasa",
                            new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(2)),
                            Priority.MEDIUM, State.ACTIVE));
            dao.insert(
                    new NoteDto(2,
                            "de lucrat la proiect!",
                            new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(7)),
                            Priority.HIGH, State.ACTIVE));
        }
    }
}
