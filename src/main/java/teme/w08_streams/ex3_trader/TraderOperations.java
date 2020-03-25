package teme.w08_streams.ex3_trader;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

class TraderOperations {

    static List<Transaction> transactionFromYearSortedByValue(List<Transaction> transactions, int year) {
        //TODO
        return null;
    }

    static Set<String> distinctTraderCities(List<Transaction> trans) {
        //TODO
        return null;
    }

    static List<Trader> tradersFromCitySortedByNameDescending(List<Transaction> trans, String city) {
        //TODO
        return null;
    }

    static String tradersNamesSorted(List<Transaction> trans) {
        //TODO
        return null;
    }

    static boolean isAnyTraderFromCity(List<Transaction> trans, String city) {
        //TODO
        return false;
    }

    static void relocateTraders(List<Transaction> trans, String fromCity, String toCity) {
        //TODO
    }

    static Optional<Transaction> transactionWithHighestValue(List<Transaction> trans) {
        //TODO
        return null;
    }

    static Optional<Transaction> transactionWithLowestValue(List<Transaction> trans) {
        //TODO
        return null;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        //build some traders
        Trader tony = new Trader("Tony", "Milan");
        Trader john = new Trader("John", "Cambridge");
        Trader oliver = new Trader("Oliver", "Cambridge");
        Trader ion = new Trader("Ion", "Iasi");

        //and some transactions
        List<Transaction> trans = Arrays.asList(
                new Transaction(2011, 100, tony),
                new Transaction(2012, 80, tony),
                new Transaction(2013, 120, tony),
                new Transaction(2011, 50, oliver),
                new Transaction(2010, 130, john),
                new Transaction(2011, 70, john),
                new Transaction(2012, 90, john),
                new Transaction(2011, 60, ion),
                new Transaction(2012, 140, ion));

        System.out.println("\ninitial transactions list:");
        trans.forEach(System.out::println);


        // - Find all transactions from 2011 and sort them by value (small to high)
        System.out.println("\ntransactions from 2011, sorted by value:");
        transactionFromYearSortedByValue(trans, 2011).forEach(System.out::println);

        // - What are all the unique cities where traders work?
        System.out.println("\ntraders cities: " + distinctTraderCities(trans));

        // - Find all traders from Cambridge and sort them by name (descending)
        System.out.println("\ntraders from Cambridge (sorted descending by name):");
        tradersFromCitySortedByNameDescending(trans, "Cambridge").forEach(System.out::println);

        // - Return a string of all traders’ names sorted alphabetically and separated by comma
        System.out.println("\nnames of all traders: " + tradersNamesSorted(trans));


        // - Determine if there are any traders from Milan
        System.out.println("\nany trader from Milan?: " + isAnyTraderFromCity(trans, "Milan"));


        //   Update all transactions so that the traders from Milan are moved to Cambridge
        relocateTraders(trans, "Milan", "Cambridge");
        System.out.println("\ntransactions after trader relocation:");
        trans.forEach(System.out::println);


        // - What’s the highest value in all transactions? What’s the transaction with the lowest value?
        Optional<Transaction> highestValueTrans = transactionWithHighestValue(trans);
        System.out.println("\nhighestValueTrans: " + highestValueTrans);

        Optional<Transaction> lowestValueTrans = transactionWithLowestValue(trans);
        System.out.println("lowestValueTrans: " + lowestValueTrans);
    }
}
