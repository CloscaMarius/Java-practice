package teme.w05_oop2.ex3_cart;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/*
import teme.w05_oop2.ex3_cart.customer.Address;
import teme.w05_oop2.ex3_cart.customer.Customer;
import teme.w05_oop2.ex3_cart.discount.Discount;
import teme.w05_oop2.ex3_cart.discount.FixedDiscount;
import teme.w05_oop2.ex3_cart.discount.PercentageDiscount;
import teme.w05_oop2.ex3_cart.product.Product;
*/

/**
 * MAX GRADE: 30p
 */
@RunWith(GradeRunner.class)
public class OnlineStoreTest {

    private static final double PRECISION = 0.001; //precision used in assertEquals() for doubles

    @Test
    @Grade
    public void TODO_uncomment_rest_of_tests_when_done() {
        //useless, but just to keep a few imports (needed for commented code) from being optimized
        assertNotEquals(true, false);
        assertTrue(true);
        fail("TODO: Uncomment rest of tests when done!"); //and also comment out this line...
    }

    /*
    private Customer someCustomer() {
        return new Customer("Ionel", "Popescu", "1234", new Address("Popauti", 72, "Iasi"));
    }

    //--- a) 8p - Customer, Address, Product ---//
    @Test
    @Grade(1)
    public void address_constructor_toString() {
        Address a = new Address("Sesame", 72, "Iasi");
        System.out.println("Address toString() result: " + a);
        assertTrue(a.toString().contains("Sesame"));
        assertTrue(a.toString().contains("72"));
        assertTrue(a.toString().contains("Iasi"));
    }

    @Test
    @Grade(1)
    public void customer_constructor_toString() {
        Customer c = someCustomer();
        System.out.println("Customer toString() result: " + c);
        assertTrue(c.toString().contains("Ionel"));
        assertTrue(c.toString().contains("Popescu"));
        assertTrue(c.toString().contains("1234"));
    }

    @Test
    @Grade(1)
    public void product_constructor_toString() {
        Product p = new Product(765, "Samsung S10", "phone", 1999, "blue");
        System.out.println("Product toString() result: " + p);
        assertTrue(p.toString().contains("765"));
        assertTrue(p.toString().contains("Samsung S10"));
        assertTrue(p.toString().contains("phone"));
        assertTrue(p.toString().contains("1999"));
        assertTrue(p.toString().contains("blue"));
    }

    //--- b) 10p - Discount, PercentageDiscount, FixedDiscount ---//
    @Test
    @Grade(1)
    public void fixedDiscount_toString() {
        FixedDiscount d = new FixedDiscount(77);
        assertTrue(d.toString().toLowerCase().contains("fixed"));
        assertTrue(d.toString().contains("77"));
    }

    @Test
    @Grade(1)
    public void percentageDiscount_toString() {
        PercentageDiscount d = new PercentageDiscount(20);
        assertTrue(d.toString().toLowerCase().contains("percentage"));
        assertTrue(d.toString().contains("20"));
    }

    @Test
    @Grade(1)
    public void discount_isSupertypeForTheTwoDiscounts() {
        assertTrue(new FixedDiscount(1) instanceof Discount);
        assertTrue(new PercentageDiscount(1) instanceof Discount);
    }


    //--- c) 12p - Cart ---//
    @Test
    @Grade(2)
    public void cart_computeProductsPrice_multipleProducts() {
        Cart cart = new Cart(someCustomer());
        assertEquals(0, cart.computeProductsPrice(), PRECISION);

        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        assertEquals(1900, cart.computeProductsPrice(), PRECISION);

        cart.addProduct(new Product(2, "p2", "watch", 490, "black"));
        assertEquals(2390, cart.computeProductsPrice(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cart_computeProductsPrice_ignoresDiscounts() {
        Cart cart = new Cart(someCustomer());
        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        cart.addProduct(new Product(2, "p2", "watch", 490, "black"));
        assertEquals(2390, cart.computeProductsPrice(), PRECISION);

        cart.addDiscount(new FixedDiscount(99));
        cart.addDiscount(new PercentageDiscount(10));
        assertEquals(2390, cart.computeProductsPrice(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cart_computeTotal_oneProduct() {
        Cart cart = new Cart(someCustomer());
        assertEquals(0.0, cart.computeTotalPrice(), PRECISION);

        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        assertEquals(1900.0, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(2)
    public void cart_computeTotal_addRemoveProducts() {
        Cart cart = new Cart(someCustomer());

        Product p1 = new Product(1, "p1", "phone", 1900, "blue");
        cart.addProduct(p1);
        assertEquals(1900.0, cart.computeTotalPrice(), PRECISION);

        Product p2 = new Product(2, "p2", "watch", 490, "black");
        cart.addProduct(p2);
        assertEquals(2390.0, cart.computeTotalPrice(), PRECISION);

        cart.removeProduct(p2);
        assertEquals(1900.0, cart.computeTotalPrice(), PRECISION);

        cart.removeProduct(p1);
        assertEquals(0.0, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cart_computeTotal_emptyCart_someDiscounts() {
        Cart cart = new Cart(someCustomer());
        assertEquals(0.0, cart.computeTotalPrice(), PRECISION);

        cart.addDiscount(new FixedDiscount(99));
        cart.addDiscount(new PercentageDiscount(10));
        assertEquals(0.0, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cart_computeTotal_oneProduct_oneFixedDiscount() {
        Cart cart = new Cart(someCustomer());

        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        assertEquals(1900.0, cart.computeTotalPrice(), PRECISION);

        cart.addDiscount(new FixedDiscount(99));
        assertEquals(1801.0, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cart_computeTotal_oneProduct_oneFixedDiscountBiggerThanTotal() {
        Cart cart = new Cart(someCustomer());
        cart.addDiscount(new FixedDiscount(1999));
        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        assertEquals(0.0, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cart_computeTotal_oneProduct_onePercentageDiscount() {
        Cart cart = new Cart(someCustomer());

        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        assertEquals(1900.0, cart.computeTotalPrice(), PRECISION);

        cart.addDiscount(new PercentageDiscount(10));
        assertEquals(1710.0, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cart_computeTotal_applyingDiscountsDoesNotChangeProductsPrice() {
        Cart cart = new Cart(someCustomer());
        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        cart.addDiscount(new PercentageDiscount(10));

        assertEquals(1900, cart.computeProductsPrice(), PRECISION);
        assertEquals(1710, cart.computeTotalPrice(), PRECISION);

        //repeated computations return same values
        assertEquals(1900, cart.computeProductsPrice(), PRECISION);
        assertEquals(1710, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cart_computeTotal_oneProduct_multipleDiscounts() {
        Cart cart = new Cart(someCustomer());

        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        assertEquals(1900.0, cart.computeTotalPrice(), PRECISION);

        cart.addDiscount(new PercentageDiscount(10));
        assertEquals(1710.0, cart.computeTotalPrice(), PRECISION);

        cart.addDiscount(new FixedDiscount(99));
        assertEquals(1611.0, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cart_computeTotal_oneProduct_addRemoveDiscounts() {
        Cart cart = new Cart(someCustomer());

        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        assertEquals(1900.0, cart.computeTotalPrice(), PRECISION);

        Discount d1 = new FixedDiscount(99);
        cart.addDiscount(d1);
        assertEquals(1801.0, cart.computeTotalPrice(), PRECISION);

        Discount d2 = new PercentageDiscount(10);
        cart.addDiscount(d2);
        assertEquals(1620.9, cart.computeTotalPrice(), PRECISION);

        cart.removeDiscount(d1);
        assertEquals(1710.0, cart.computeTotalPrice(), PRECISION);

        cart.removeDiscount(d2);
        assertEquals(1900.0, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(2)
    public void cart_computeTotal_multipleProducts_multipleDiscounts() {
        Cart cart = new Cart(someCustomer());
        cart.addDiscount(new FixedDiscount(99));
        cart.addDiscount(new PercentageDiscount(10));

        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        //products: 1900; apply 1st discount: 1900-99=1801; apply 2nd: 1801 - 180.1 (10%) = 1620.9
        assertEquals(1620.9, cart.computeTotalPrice(), PRECISION);

        cart.addProduct(new Product(2, "p2", "watch", 490, "black"));
        //products: 1900+490=2390; apply 1st discount: 2390-99=2291; apply 2nd: 2291 - 229.1(10%) = 2061.9
        assertEquals(2061.9, cart.computeTotalPrice(), PRECISION);

        cart.addProduct(new Product(3, "p3", "hat", 99, "white"));
        //products: 1900+490+99=2489; apply 1st discount: 2489-99=2390; apply 2nd: 2390 - 239(10%) = 2151
        assertEquals(2151.0, cart.computeTotalPrice(), PRECISION);

        cart.addDiscount(new FixedDiscount(51));
        //products: 2489; apply 1st+2nd: 2151 (as above); apply 3rd disc: 2151 - 51 = 2100
        assertEquals(2100.0, cart.computeTotalPrice(), PRECISION);

        cart.addDiscount(new PercentageDiscount(5));
        //products: 2489; apply 1st+2nd+3rd: 2100; apply 4th disc: 2100 - 105(5%) = 1995
        assertEquals(1995.0, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(2)
    public void testCart_allOperationsCombined() {

        //build empty cart
        Cart cart = new Cart(someCustomer());
        assertEquals(0, cart.computeTotalPrice(), PRECISION);


        //1) Add products to cart (no discount yet):
        cart.addProduct(new Product(1, "p1", "phone", 1900, "blue"));
        assertEquals(1900, cart.computeTotalPrice(), PRECISION);

        cart.addProduct(new Product(2, "p2", "watch", 490, "black"));
        assertEquals(2390.0, cart.computeTotalPrice(), PRECISION);

        Product p3 = new Product(3, "p3", "hat", 99, "white");
        cart.addProduct(p3);
        assertEquals(2489.0, cart.computeTotalPrice(), PRECISION);

        System.out.println("\nALL OPERATIONS - BEFORE DISCOUNTS:\n" + cart.generateInvoice());

        //2) Also add some discounts:
        cart.addDiscount(new FixedDiscount(389));
        assertEquals(2100.0, cart.computeTotalPrice(), PRECISION);

        Discount d2 = new PercentageDiscount(10);
        cart.addDiscount(d2);
        assertEquals(1890.0, cart.computeTotalPrice(), PRECISION);

        System.out.println("\nALL OPERATIONS - AFTER DISCOUNTS:\n" + cart.generateInvoice());

        //3) Replace a product and a discount:
        cart.removeProduct(p3);
        cart.addProduct(new Product(4, "p4", "gloves", 290, "brown"));
        cart.removeDiscount(d2);
        cart.addDiscount(new PercentageDiscount(10));

        System.out.println("\nALL OPERATIONS - AFTER REPLACING PRODUCTS+DISCOUNTS:\n" + cart.generateInvoice());
        assertEquals(2061.9, cart.computeTotalPrice(), PRECISION);
    }

    @Test
    @Grade(1)
    public void testCart_cartsShouldBeIndependent() {

        Cart cart1 = new Cart(someCustomer());
        Cart cart2 = new Cart(someCustomer());

        assertEquals(0, cart1.computeTotalPrice(), PRECISION);
        assertEquals(0, cart1.computeProductsPrice(), PRECISION);
        assertEquals(0, cart2.computeTotalPrice(), PRECISION);
        assertEquals(0, cart2.computeProductsPrice(), PRECISION);

        cart1.addProduct(new Product(1, "p1 in cart1", "hat", 50, "black"));
        assertEquals(50, cart1.computeTotalPrice(), PRECISION);
        assertEquals(50, cart1.computeProductsPrice(), PRECISION);
        assertEquals(0, cart2.computeTotalPrice(), PRECISION);
        assertEquals(0, cart2.computeProductsPrice(), PRECISION);

        cart2.addDiscount(new FixedDiscount(1));
        assertEquals(50, cart1.computeProductsPrice(), PRECISION);
        assertEquals(50, cart1.computeTotalPrice(), PRECISION);
        assertEquals(0, cart2.computeProductsPrice(), PRECISION);
        assertEquals(0, cart2.computeTotalPrice(), PRECISION);

        cart1.addProduct(new Product(2, "p2 in cart1", "coat", 100, "black"));
        cart2.addProduct(new Product(1, "p1 in cart2", "napkin", 5, "white"));
        assertEquals(150, cart1.computeProductsPrice(), PRECISION);
        assertEquals(150, cart1.computeTotalPrice(), PRECISION);
        assertEquals(5, cart2.computeProductsPrice(), PRECISION);
        assertEquals(4, cart2.computeTotalPrice(), PRECISION);

        cart1.addDiscount(new PercentageDiscount(10));
        assertEquals(135, cart1.computeTotalPrice(), PRECISION);
        assertEquals(150, cart1.computeProductsPrice(), PRECISION);
        assertEquals(4, cart2.computeTotalPrice(), PRECISION);
        assertEquals(5, cart2.computeProductsPrice(), PRECISION);

        cart2.addProduct(new Product(2, "p2 in cart2", "water", 3, "none"));
        assertEquals(135, cart1.computeTotalPrice(), PRECISION);
        assertEquals(150, cart1.computeProductsPrice(), PRECISION);
        assertEquals(7, cart2.computeTotalPrice(), PRECISION);
        assertEquals(8, cart2.computeProductsPrice(), PRECISION);

        cart1.addDiscount(new FixedDiscount(5));
        assertEquals(150, cart1.computeProductsPrice(), PRECISION);
        assertEquals(130, cart1.computeTotalPrice(), PRECISION);
        assertEquals(8, cart2.computeProductsPrice(), PRECISION);
        assertEquals(7, cart2.computeTotalPrice(), PRECISION);

        cart2.addDiscount(new PercentageDiscount(50));
        assertEquals(130, cart1.computeTotalPrice(), PRECISION);
        assertEquals(150, cart1.computeProductsPrice(), PRECISION);
        assertEquals(3.5, cart2.computeTotalPrice(), PRECISION);
        assertEquals(8, cart2.computeProductsPrice(), PRECISION);

        Cart cart3 = new Cart(someCustomer());
        cart3.addProduct(new Product(1, "p1 in cart 3", "food", 10, "brown"));
        assertEquals(10, cart3.computeTotalPrice(), PRECISION);
        assertEquals(10, cart3.computeProductsPrice(), PRECISION);

        Cart cart4 = new Cart(someCustomer());
        assertEquals(150, cart1.computeProductsPrice(), PRECISION);
        assertEquals(8, cart2.computeProductsPrice(), PRECISION);
        assertEquals(0, cart4.computeProductsPrice(), PRECISION);
        assertEquals(10, cart3.computeTotalPrice(), PRECISION);

        cart3.addDiscount(new PercentageDiscount(50));

        assertEquals(150, cart1.computeProductsPrice(), PRECISION);
        assertEquals(8, cart2.computeProductsPrice(), PRECISION);
        assertEquals(0, cart4.computeProductsPrice(), PRECISION);
        assertEquals(130, cart1.computeTotalPrice(), PRECISION);
        assertEquals(3.5, cart2.computeTotalPrice(), PRECISION);
        assertEquals(0, cart4.computeTotalPrice(), PRECISION);

        assertEquals(5, cart3.computeTotalPrice(), PRECISION);
        assertEquals(10, cart3.computeProductsPrice(), PRECISION);
    }


    @Test
    @Grade(1)
    public void testCart_generateInvoice_emptyCart_containsCustomerInfo() {
        Cart cart = new Cart(someCustomer());

        String invoice = cart.generateInvoice();
        System.out.println("Invoice for empty cart:\n" + invoice);

        //should contain full customer info
        assertTrue(invoice.contains("Ionel"));
        assertTrue(invoice.contains("Popescu"));
        assertTrue(invoice.contains("1234"));
        assertTrue(invoice.contains("Popauti"));
        assertTrue(invoice.contains("72"));
        assertTrue(invoice.contains("Iasi"));

        //should contain a total of 0
        assertTrue(invoice.contains("0"));
    }

    @Test
    @Grade(1)
    public void testCart_generateInvoice_multipleProducts_containsProductDetails() {
        Cart cart = new Cart(someCustomer());
        cart.addProduct(new Product(765, "Samsung S10", "phone", 1999, "blue"));
        cart.addProduct(new Product(123, "iWatch3", "watch", 490, "white"));

        String invoice = cart.generateInvoice();
        System.out.println("Invoice for cart with 2 products:\n" + invoice);

        //should contain the list of products, with details (except maybe id,type, which we can consider optional)
        assertTrue(invoice.contains("Samsung S10"));
        assertTrue(invoice.contains("1999"));
        assertTrue(invoice.contains("blue"));

        assertTrue(invoice.contains("iWatch3"));
        assertTrue(invoice.contains("490"));
        assertTrue(invoice.contains("white"));
    }

    @Test
    @Grade(1)
    public void testCart_generateInvoice_multipleProducts_noDiscounts_includesCorrectTotal() {
        Cart cart = new Cart(someCustomer());
        cart.addProduct(new Product(765, "Samsung S10", "phone", 1999, "blue"));
        cart.addProduct(new Product(123, "iWatch3", "watch", 490, "white"));

        String invoice = cart.generateInvoice();
        System.out.println("Invoice for cart with 2 products:\n" + invoice);

        //should compute the total correctly
        assertTrue(invoice.contains("2489"));
    }

    @Test
    @Grade(2)
    public void testCart_generateInvoice_multipleProducts_someDiscounts_includesCorrectTotal() {
        Cart cart = new Cart(someCustomer());
        cart.addProduct(new Product(765, "Samsung S10", "phone", 1999, "blue"));
        cart.addProduct(new Product(123, "iWatch3", "watch", 490, "white"));

        //add a discount
        cart.addDiscount(new FixedDiscount(89));

        String invoice = cart.generateInvoice();
        System.out.println("Invoice for cart with 2 products after adding 1st discount:\n" + invoice);
        assertTrue(invoice.contains("2400")); //total price should be recomputed correctly

        //add another discount
        cart.addDiscount(new PercentageDiscount(25));

        invoice = cart.generateInvoice();
        System.out.println("Invoice for cart with 2 products after adding 2nd discount:\n" + invoice);
        assertTrue(invoice.contains("1800")); //total price should be recomputed correctly
    }

    @Test
    @Grade(1)
    public void testCart_generateInvoice_multipleProducts_someDiscounts_includesPriceBefore_andDiscountDetails() {
        Cart cart = new Cart(someCustomer());
        cart.addProduct(new Product(765, "Samsung S10", "phone", 1999, "blue"));
        cart.addProduct(new Product(123, "iWatch3", "watch", 490, "white"));

        //add a discount
        cart.addDiscount(new FixedDiscount(89));

        String invoice = cart.generateInvoice();
        System.out.println("Invoice for cart with 2 products after adding 1st discount:\n" + invoice);
        assertTrue(invoice.contains("2489")); //price before discounts should still appear
        assertTrue(invoice.contains("89"));   //discount 1 value should appear

        //add another discount
        cart.addDiscount(new PercentageDiscount(25));

        invoice = cart.generateInvoice();
        System.out.println("Invoice for cart with 2 products after adding 2nd discount:\n" + invoice);
        assertTrue(invoice.contains("2489")); //price before discounts should still appear
        assertTrue(invoice.contains("89"));   //discount 1 value should appear
        assertTrue(invoice.contains("25"));   //discount 2 value should appear
    }
    */
}
