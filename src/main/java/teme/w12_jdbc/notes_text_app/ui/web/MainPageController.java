package teme.w12_jdbc.notes_text_app.ui.web;

import spark.Request;
import spark.Response;
import teme.w12_jdbc.notes_text_app.db.dto.NoteDto;
import teme.w12_jdbc.notes_text_app.db.dto.State;
import teme.w12_jdbc.notes_text_app.db.service.NoteDao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static teme.w12_jdbc.notes_text_app.ui.web.SparkUtil.render;

public class MainPageController {

    public enum SortBy {
        DATE, PRIORITY
    }

    private static final NoteDao dao = new NoteDao();

    public static String showMainPage(Request req, Response res) {

        List<NoteDto> allNotes = dao.getAll();
        long completedCount = allNotes.stream().filter(i -> i.getState() == State.COMPLETED).count();
        long activeCount = allNotes.size() - completedCount;

        boolean hideCompleted = getHideCompletedFromParamOrSes(req);
        SortBy sortBy = getSortByFromParamOrSes(req);

        List<NoteDto> notes = getNotesToDisplay(allNotes, hideCompleted, sortBy);

        Map<String, Object> model = new HashMap<>();
        model.put("notes", notes);
        model.put("activeCount", activeCount);
        model.put("completedCount", completedCount);
        model.put("hideCompleted", hideCompleted);
        model.put("sortBy", sortBy);
        return render(model, "notes/main.vm");
    }

    private static List<NoteDto> getNotesToDisplay(List<NoteDto> allNotes, boolean hideCompleted, SortBy sortBy) {
        List<NoteDto> notes = allNotes;
        if (hideCompleted) {
            notes = allNotes.stream()
                    .filter(i -> i.getState() != State.COMPLETED)
                    .collect(toList());
        }
        return notes.stream()
                .sorted((n1, n2) -> {
                    if (sortBy == SortBy.PRIORITY) {
                        return n1.getPriority().compareTo(n2.getPriority());
                    } else { //by date, but must also handle null values!
                        Date d1 = n1.getDueDate();
                        Date d2 = n2.getDueDate();
                        return Long.compare(
                                d1 != null ? d1.getTime() : 0,
                                d2 != null ? d2.getTime() : 0);
                    }
                })
                .collect(toList());
    }

    private static boolean getHideCompletedFromParamOrSes(Request req) {
        String param = req.queryParams("hideCompleted"); //read it from current request (if sent)
        if (param != null) {
            req.session().attribute("hideCompleted", param); //save it to session for later
        } else {
            param = req.session().attribute("hideCompleted"); //try to read it from session
        }
        return "true".equals(param); //reverse comparison to avoid NPE if param is still null
    }

    private static SortBy getSortByFromParamOrSes(Request req) {
        String param = req.queryParams("sortBy"); //read it from current request (if sent)
        if (param != null) {
            req.session().attribute("sortBy", param); //save it to session for later
        } else {
            param = req.session().attribute("sortBy"); //try to read it from session
        }
        return param != null ? SortBy.valueOf(param) : SortBy.PRIORITY;
    }


    public static Object handleChangeStateRequest(Request req, Response res) {
        String idParam = req.params("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                long id = Long.parseLong(idParam);
                Optional<NoteDto> optionalNote = dao.get(id);
                optionalNote.ifPresent(note -> {
                    State newState = note.getState() == State.COMPLETED ? State.ACTIVE : State.COMPLETED;
                    NoteDto updatedNote = new NoteDto(note.getId(), note.getDescription(), note.getDueDate(), note.getPriority(), newState);
                    dao.update(updatedNote);
                });
            } catch (Exception e) {
                System.out.println("Failed to handle change state request for id '" + idParam + "': " + e.getMessage());
            }
        }
        res.redirect("/main");
        return res;
    }

    public static Object handleDeleteRequest(Request req, Response res) {
        String id = req.params("id");
        try {
            dao.delete(Long.parseLong(id));
        } catch (Exception e) {
            System.out.println("Error deleting note with id '" + id + "': " + e.getMessage());
        }
        res.redirect("/main");
        return res;
    }
}