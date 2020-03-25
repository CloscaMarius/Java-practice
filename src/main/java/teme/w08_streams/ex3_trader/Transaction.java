package teme.w08_streams.ex3_trader;

import java.util.Objects;

class Transaction {
    private final int year;
    private final int value;
    private final Trader trader;

    Transaction(int year, int value, Trader trader) {
        this.year = year;
        this.value = value;
        this.trader = trader;
    }

    int getYear() {
        return year;
    }

    int getValue() {
        return value;
    }

    Trader getTrader() {
        return trader;
    }

    @Override
    public String toString() {
        return "Transaction{" + "year=" + year + ", value=" + value + ", trader=" + trader + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return year == that.year &&
                value == that.value &&
                Objects.equals(trader, that.trader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, value, trader);
    }
}
