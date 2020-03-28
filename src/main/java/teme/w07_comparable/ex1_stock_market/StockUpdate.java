package teme.w07_comparable.ex1_stock_market;

import java.time.LocalDate;
import java.util.Objects;

class StockUpdate implements Comparable<StockUpdate> {

    private String code;
    private LocalDate lastUpdate;
    private double price;

    public String getCode() {
        return code;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public double getPrice() {
        return price;
    }

    StockUpdate(String code, LocalDate lastUpdate, double price) {
        this.code = code;
        this.lastUpdate = lastUpdate;
        this.price = price;
    }

//    StockUpdate(LocalDate lastUpdate){
//        this("",lastUpdate,3.0);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockUpdate that = (StockUpdate) o;
        return Double.compare(that.price, price) == 0 &&
                code.equals(that.code) &&
                lastUpdate.equals(that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, lastUpdate, price);
    }

    @Override
    public int compareTo(StockUpdate stockUpdate) {
        return this.lastUpdate.compareTo(stockUpdate.lastUpdate);
    }
}
