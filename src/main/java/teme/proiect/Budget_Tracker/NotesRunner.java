package teme.proiect.Budget_Tracker;

import teme.proiect.Budget_Tracker.db.CategoriesDao;
import teme.proiect.Budget_Tracker.db.TransactionsDao;

public class NotesRunner {


    public static void main(String[] args) {

        DbInitService.createMissingTables();
        TransactionsDao tDao = new TransactionsDao();
        //System.out.println(tDao.getAllByDateAsc());

        CategoriesDao cDao = new CategoriesDao();
        //System.out.println(cDao.getAll());

        //tDao.insert(new TransactionsDto(4,"2018-06-08",null,24.3));


        //tDao.insert(new TransactionsDto(4,"2019-09-09","detail",777.7));
        System.out.println(tDao.balance());




        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        DbInitService.createMissingTables();

        TransactionsDao Tdao = new TransactionsDao();
        System.out.println(Tdao.getAllByDateAsc());
        TransactionsDto item1;

        item1 = new TransactionsDto(4, Date.valueOf("2018-05-04"), "sales", 48.3);

        Tdao.insert(item1);
        Optional<TransactionsDto> maybeItem = Tdao.getAllByDateAsc().stream().filter(i -> i.getDetails().equals("rent payed")).findFirst();
        System.out.println(Tdao.getById(maybeItem.get().getId()));*/
    }
}
