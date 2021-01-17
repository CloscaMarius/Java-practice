package teme.w14_web_pages.notes_app_web;

import teme.w14_web_pages.notes_app_web.db.service.DbInitService;

public class NotesAppWeb {

    public static void main(String[] args) {

        DbInitService.createTablesAndInitialData();

    }
}
