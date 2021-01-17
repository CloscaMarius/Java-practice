package teme.w12_jdbc.notes_text_app.ui.text;

import teme.w12_jdbc.notes_text_app.db.dto.NoteDto;
import teme.w12_jdbc.notes_text_app.db.dto.Priority;
import teme.w12_jdbc.notes_text_app.db.dto.State;

import java.sql.Date;

import static teme.w12_jdbc.notes_text_app.ui.text.TextMenuUtil.readChoice;
import static teme.w12_jdbc.notes_text_app.ui.text.TextMenuUtil.readString;

public class EditNoteController {

    public static NoteDto readNewNote() {
        System.out.println("Enter details of new note:");

        String description = readString("- Description: ", false);
        Priority priority = readPriority();
        Date dueDate = readDueDate();

        return new NoteDto(description, dueDate, priority, State.ACTIVE);
    }

    private static Priority readPriority() {
        char pc = readChoice("- Priority - Low/Medium/High (L/M/H): ", 'L', 'M', 'H');
        return
                pc == 'L' ? Priority.LOW :
                        pc == 'M' ? Priority.MEDIUM :
                                Priority.HIGH;
    }

    private static Date readDueDate() {
        Date dueDate = null;
        boolean isValidDate = false;
        do {
            String dateStr = readString("- Due date (empty, or date in YYYY-MM-DD format): ", true);
            if (dateStr.isEmpty()) {
                isValidDate = true; //date will remain empty (null)
            } else {
                try {
                    dueDate = Date.valueOf(dateStr);
                    isValidDate = true;
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid date value: " + e.getMessage());
                }
            }
        } while (!isValidDate);
        return dueDate;
    }
}
