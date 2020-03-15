package teme.w05_oop2.ex3_cart;

import teme.w05_oop2.ex3_cart.customer.Customer;
import teme.w05_oop2.ex3_cart.discount.Discount;
import teme.w05_oop2.ex3_cart.product.Product;

import java.util.Arrays;

public class Cart {
    private Customer customer;
    private Product[] products = new Product[0];
    private Discount[] discounts = new Discount[0];


    public Customer getCustomer() {
        return customer;
    }

    public Cart(Customer customer) {
        this.customer = customer;
    }

    void addProduct(Product p) {
        Product[] newProducts = Arrays.copyOf(products, products.length + 1);
        newProducts[newProducts.length - 1] = p;
        this.products = newProducts;
    }

    boolean isPresent(Product p) {
        return indexOf(p) >= 0;
    }

    private int indexOf(Product p) {
        for (int i = 0; i < products.length; i++) { //go up to count only (not full array length)
            if (products[i].equals(p)) {
                return i;
            }
        }
        return -1;
    }

    void removeProduct(Product p) {
        if (!((products == null) || (products.length == 0) || (indexOf(p) == -1))) {

            Product[] productArray = new Product[products.length - 1];
            int k = 0;
            for (int i = 0; i < products.length; i++) {
                if (indexOf(p) == i) {
                    continue;
                }
                productArray[k] = products[i];
                k++;
            }
            this.products = productArray;
        }
    }

    private double totalPrice;


    double computeProductsPrice() {

        double productsPrice = 0;
        for (Product product : products) {
            productsPrice += product.getPrice();
        }
        this.totalPrice = productsPrice;
        return totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    void addDiscount(Discount d) {

        Discount[] ds = Arrays.copyOf(discounts, discounts.length + 1);

        ds[ds.length - 1] = d;
        this.discounts = ds;
    }

    void removeDiscount(Discount d) {
        if (!((discounts == null) || (discounts.length == 0) || (!isPresent(d)))) {
            this.discounts = new Discount[0];
        } else {
            Discount[] result = new Discount[discounts.length - 1];
            int k = 0;
            for (int i = 0; i < discounts.length; i++) {
                if (isPresent(d)) {
                    continue;
                }
                result[k] = discounts[i];
                k++;
            }
            this.discounts = result;
        }
    }

    boolean isPresent(Discount d) {
        for (Discount ds : discounts) {
            if (ds.equals(d)) {
                return true;
            }
        }
        return false;
    }


    double computeTotalPrice() {
        double sum = 0;
        if (discounts == null || discounts.length == 0) {
            return computeProductsPrice();
        } else if (discounts.length == 1) {
            return discounts[0].priceAfterDiscount;
        }
        for (Discount discount : discounts) {
            sum += discount.priceAfterDiscount;
        }
        return sum;
    }

    String generateInvoice() {
        return "Cart{" + customer.toString() + "\n" +
                "\t ListOfProducts" + "\n" + Arrays.toString(products) + "\n" +
                "Price without discounts=" + this.computeProductsPrice() + "\n" +
                "Discounts=" + Arrays.toString(discounts) + "\n" +
                "TotalPrice=" + this.computeTotalPrice() + "}";
    }

}