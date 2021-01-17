package teme.w12_jdbc.notes_text_app.ui.web;

import spark.Request;
import spark.Response;
import teme.w12_jdbc.notes_text_app.db.dto.NoteDto;
import teme.w12_jdbc.notes_text_app.db.dto.Priority;
import teme.w12_jdbc.notes_text_app.db.dto.State;
import teme.w12_jdbc.notes_text_app.db.service.NoteDao;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static teme.w12_jdbc.notes_text_app.ui.web.SparkUtil.render;

/**
 * Handles the user interaction for adding or updating a note.
 */
public class NotePageController {

    private static final NoteDao dao = new NoteDao();

    public static String showAddUpdateForm(Request req, Response res) {
        String id = req.params("id");
        boolean isUpdate = id != null && !id.isEmpty();

        Optional<NoteDto> optNote = Optional.empty();
        if (isUpdate) {
            try {
                optNote = dao.get(Integer.parseInt(id));
            } catch (Exception e) {
                System.err.println("Error loading note with id '" + id + "': " + e.getMessage());
            }
            if (!optNote.isPresent()) {
                return "Error: note " + id + " not found!";
            }
        }

        return renderAddUpdateForm(
                optNote.map(i -> String.valueOf(i.getId())).orElse(""),
                optNote.map(NoteDto::getDescription).orElse(""),
                optNote.map(i -> i.getPriority().name()).orElse(Priority.MEDIUM.name()),
                optNote.map(i -> i.getDueDate() != null ? i.getDueDate().toString() : "").orElse(""),
                optNote.map(i -> i.getState().name()).orElse(State.ACTIVE.name()),
                "");
    }

    private static String renderAddUpdateForm(String id, String description, String priority,
                                              String dueDate, String state, String errorMessage) {
        Map<String, Object> model = new HashMap<>();
        model.put("prevId", id);
        model.put("prevDescription", description);
        model.put("prevPriority", priority);
        model.put("prevDueDate", dueDate);
        model.put("prevState", state);
        model.put("errorMsg", errorMessage);
        model.put("isUpdate", id != null && !id.isEmpty());
        return render(model, "notes/add.vm");
    }

    public static Object handleAddUpdateRequest(Request req, Response res) {
        //read form values (posted as params)
        String id = req.queryParams("id");
        String description = req.queryParams("description");
        String priority = req.queryParams("priority");
        String dueDate = req.queryParams("dueDate");
        String state = req.queryParams("state");

        boolean isUpdate = id != null && !id.isEmpty();

        try {
            NoteDto note = validateAndBuildNote(id, description, priority, dueDate, state);

            if (isUpdate) {
                dao.update(note);
            } else {
                dao.insert(note);
            }

            res.redirect("/main");
            return res;

        } catch (Exception e) {
            return renderAddUpdateForm(id, description, priority, dueDate, state, e.getMessage());
        }
    }

    public static NoteDto validateAndBuildNote(String id, String description,
                                               String priority, String dueDate, String state) {

        if (description == null || description.isEmpty()) {
            throw new RuntimeException("Description is required!");
        }

        if (priority == null || priority.isEmpty()) {
            throw new RuntimeException("Priority is required!");
        }
        Priority priorityValue;
        try {
            priorityValue = Priority.valueOf(priority);
        } catch (Exception e) {
            throw new RuntimeException("Invalid priority value: '" + priority +
                    "', must be one of: " + Arrays.toString(Priority.values()));
        }

        Date dueDateValue;
        if (dueDate != null && !dueDate.isEmpty()) {
            try {
                dueDateValue = Date.valueOf(dueDate);
            } catch (Exception e) {
                throw new RuntimeException("Invalid due date value: '" + dueDate +
                        "', must be a date in format: yyyy-[m]m-[d]d");
            }
        } else {
            dueDateValue = null;
        }

        if (state == null || state.isEmpty()) {
            throw new RuntimeException("State is required!");
        }
        State stateValue;
        try {
            stateValue = State.valueOf(state);
        } catch (Exception e) {
            throw new RuntimeException("Invalid state value: '" + state +
                    "', must be one of: " + Arrays.toString(State.values()));
        }

        return id != null && !id.isEmpty() ?
                new NoteDto(Long.parseLong(id), description, dueDateValue, priorityValue, stateValue) :
                new NoteDto(description, dueDateValue, priorityValue, stateValue);
    }
}
