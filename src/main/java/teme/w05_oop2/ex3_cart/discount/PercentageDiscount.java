package teme.w05_oop2.ex3_cart.discount;

import teme.w05_oop2.ex3_cart.product.Product;

public class PercentageDiscount extends Discount {

    private Product product;

    private double percentValue;
    private double finalPrice;

    public double getFinalPrice() {
        return finalPrice;
    }

    public double getPercentValue() {
        return percentValue;
    }


    public PercentageDiscount(double percentValue) {
        this.percentValue = percentValue;
    }

    @Override
    double computePriceAfterDiscount() {
        super.priceAfterDiscount = product.getPrice() - (product.getPrice() * percentValue / 100);

        return priceAfterDiscount;
    }


    @Override
    public String toString() {
        return "PercentageDiscount{" +
                "percentValue=" + percentValue +
                '}';
    }

}
