package teme.w12_jdbc.notes_text_app.ui.text;

import teme.w12_jdbc.notes_text_app.db.dto.NoteDto;
import teme.w12_jdbc.notes_text_app.db.dto.State;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static teme.w12_jdbc.notes_text_app.ui.text.NotesListController.Order.BY_PRIORITY;
import static teme.w12_jdbc.notes_text_app.ui.text.TextMenuUtil.readChoice;

public class NotesListController {

    enum Order {
        BY_PRIORITY, BY_DUE_DATE
    }

    private static Order order = BY_PRIORITY;
    private static boolean hideCompleted = false;

    public static Order getOrder() {
        return order;
    }

    public static boolean isHideCompleted() {
        return hideCompleted;
    }

    public static void changeSortOrder() {
        char choice = readChoice("Sort order:\nP - by priority (High to Low)\nD - by due date (ascending)", 'P', 'D');
        order = choice == 'P' ? BY_PRIORITY : Order.BY_DUE_DATE;
    }

    public static void toggleCompleted() {
        hideCompleted = !hideCompleted;
        System.out.println("Will hide completed notes: " + hideCompleted);
    }

    public static void display(List<NoteDto> notes) {
        System.out.println("\n------ NOTES (" + order + ") ----------------------------------------------------------------");

        //TODO: make this display nicer! (print as a table, with fixed-width columns..)
        notes.stream()
                .filter(i -> i.getState() == State.ACTIVE || !hideCompleted)
                .sorted(getDisplayComparator())
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------------------------");
    }


    private static Comparator<NoteDto> getDisplayComparator() {
        if (order == BY_PRIORITY) {
            return Comparator.comparing(NoteDto::getPriority);
        } else {
            //by due date - more complex case, need to handle NULL values too
            Date defaultDate = new Date(0); //start of time, to force them to appear first in list
            return (i1, i2) -> {
                Date d1 = i1.getDueDate() != null ? i1.getDueDate() : defaultDate;
                Date d2 = i2.getDueDate() != null ? i2.getDueDate() : defaultDate;
                return d1.compareTo(d2);
            };
        }
    }
}
