package teme.w07_comparable.ex1_stock_market;

import java.time.LocalDate;
import java.util.*;

class StockMarket {

    private Set<StockUpdate> stocks = new HashSet<>();
    private StockUpdate stockUpdate;

    void add(StockUpdate update) {
        stocks.add(update);

    }

    List<StockUpdate> getUpdates(LocalDate from, LocalDate to) {
        List<StockUpdate> newStock = new ArrayList<>();
        for (StockUpdate st : stocks) {
            if (st.getLastUpdate().isAfter(from)
                    && st.getLastUpdate().isBefore(to)
                    || st.getLastUpdate() == from
                    || st.getLastUpdate() == to) {
                newStock.add(st);
            }

        }
        Collections.sort(newStock);
        return newStock;
    }

    List<StockUpdate> getUpdates(LocalDate from, LocalDate to, String code) {
        List<StockUpdate> newStock = new ArrayList<>();
        for (StockUpdate st : stocks) {
            if (st.getCode().equals(code)) {
                if (st.getLastUpdate().isAfter(from)
                        && st.getLastUpdate().isBefore(to)
                        || st.getLastUpdate() == from
                        || st.getLastUpdate() == to) {
                    newStock.add(st);
                }
            }
        }
        Collections.sort(newStock);
        return newStock;
    }

    Map<String, Double> getPrices(LocalDate date) {
        Map<String, Double> newMap = new TreeMap<>();
        for (StockUpdate st : stocks) {
            if (st.getLastUpdate() == beforeDate(date)) {
                newMap.put(st.getCode(), st.getPrice());
            }
        }
        return newMap;
    }

    double getPrice(LocalDate date, String code) {
        double onePrice = 0;

        for (StockUpdate st : stocks) {
            if (st.getCode().equals(code)) {
                if (st.getLastUpdate() == beforeDate(date)) {
                    onePrice = st.getPrice();
                }
            }
        }
        return onePrice;
    }

    LocalDate beforeDate(LocalDate date) {
        TreeSet<LocalDate> newSet = new TreeSet<>();
        for (StockUpdate st : stocks) {
            newSet.add(st.getLastUpdate());
        }
        return newSet.floor(date);
    }
}
