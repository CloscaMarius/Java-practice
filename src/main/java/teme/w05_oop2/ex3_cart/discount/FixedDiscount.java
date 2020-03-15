package teme.w05_oop2.ex3_cart.discount;

import teme.w05_oop2.ex3_cart.product.Product;

public class FixedDiscount extends Discount {

    private Product product;

    private double amount;

    public double getAmount() {
        return amount;
    }


    public FixedDiscount(double amount) {
        this.amount = amount;
    }


    @Override
    double computePriceAfterDiscount() {
        super.priceAfterDiscount = product.getPrice() - amount;
        return priceAfterDiscount;

    }


    @Override
    public String toString() {
        return "FixedDiscount{" +
                "amount=" + amount +
                '}';
    }
}
