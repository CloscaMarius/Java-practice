package teme.w12_jdbc.notes_text_app;

import teme.w12_jdbc.notes_text_app.db.service.DbInitService;
import teme.w12_jdbc.notes_text_app.db.service.NoteDao;
import teme.w12_jdbc.notes_text_app.ui.text.MainMenuController;

/**
 * Simple TO-DO Notes application
 * Uses DB to persist data (SQLite, in a local file, auto-created if missing)
 * <p>
 * This is the main class for text-based UI version.
 */
public class NotesAppText {

    public static void main(String[] args) {

        DbInitService.createMissingTables();

        NoteDao dao = new NoteDao();

        MainMenuController.showMainMenu(dao);
    }
}
