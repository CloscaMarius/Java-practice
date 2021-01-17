package teme.w12_jdbc.notes_text_app.ui.text;

import teme.w12_jdbc.notes_text_app.db.dto.NoteDto;
import teme.w12_jdbc.notes_text_app.db.dto.State;
import teme.w12_jdbc.notes_text_app.db.service.NoteDao;

import static teme.w12_jdbc.notes_text_app.ui.text.TextMenuUtil.readChoice;

public class MainMenuController {

    public static void showMainMenu(NoteDao dao) {

        while (true) {

            NotesListController.display(dao.getAll());

            char c = readChoice(
                    "A - Add new note\n" +
                            "C - Mark note as Completed\n" +
                            "D - Delete note\n" +
                            "S - Change sort order (current: " + NotesListController.getOrder() + ")\n" +
                            "H - Hide/show Completed notes (current: " + (NotesListController.isHideCompleted() ? "hidden" : "shown") + ")\n" +
                            "Q - Quit",
                    'A', 'C', 'D', 'S', 'H', 'Q');

            switch (c) {
                case 'A':
                    NoteDto newNote = EditNoteController.readNewNote();
                    dao.insert(newNote);
                    break;

                case 'C':
                    int id = TextMenuUtil.readInt("Id of note to complete: ");
                    dao.get(id).ifPresent(note ->
                            dao.update(new NoteDto(note.getId(), note.getDescription(), note.getDueDate(), note.getPriority(), State.COMPLETED)));
                    break;

                case 'D':
                    int idToDel = TextMenuUtil.readInt("Id of note to delete: ");
                    dao.delete(idToDel);
                    break;

                case 'S':
                    NotesListController.changeSortOrder();
                    break;

                case 'H':
                    NotesListController.toggleCompleted();
                    break;

                default:
                    System.out.println("Bye!");
                    return; //exit main loop
            }
        }
    }
}
