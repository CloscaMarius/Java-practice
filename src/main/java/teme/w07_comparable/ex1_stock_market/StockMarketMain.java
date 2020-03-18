package teme.w07_comparable.ex1_stock_market;

import java.time.LocalDate;

/**
 * Some manual tests for StockMarket
 */
class StockMarketMain {
    public static void main(String[] args) {
        StockMarket m = new StockMarket();
        m.add(new StockUpdate("A", LocalDate.of(2018, 1, 1), 11));
        m.add(new StockUpdate("A", LocalDate.of(2018, 1, 5), 15));
        m.add(new StockUpdate("B", LocalDate.of(2018, 1, 1), 21));
        m.add(new StockUpdate("B", LocalDate.of(2018, 1, 2), 22));
        m.add(new StockUpdate("B", LocalDate.of(2018, 1, 3), 23));
        m.add(new StockUpdate("B", LocalDate.of(2018, 1, 4), 24));
        m.add(new StockUpdate("B", LocalDate.of(2018, 1, 6), 26));

        System.out.println("\nUpdates: " + m.getUpdates(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 4)));
        System.out.println("Updates2: " + m.getUpdates(LocalDate.of(2018, 1, 2), LocalDate.of(2018, 1, 3)));

        System.out.println("\nUpdates(A): " + m.getUpdates(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 4), "A"));

        System.out.println("\nPrice(A): " + m.getPrice(LocalDate.of(2017, 1, 1), "A"));
        System.out.println("Price(B): " + m.getPrice(LocalDate.of(2018, 1, 5), "B"));

        System.out.println("\nPrices: " + m.getPrices(LocalDate.of(2017, 1, 1)));
        System.out.println("Prices: " + m.getPrices(LocalDate.of(2018, 1, 5)));
    }
}
