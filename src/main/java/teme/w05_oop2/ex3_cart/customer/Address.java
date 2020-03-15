package teme.w05_oop2.ex3_cart.customer;

public class Address {
    private String street;
    private int streetNumber;
    private String town;

    public String getStreet() {
        return street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getTown() {
        return town;
    }

    public Address(String street, int streetNumber, String town) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", town='" + town + '\'' +
                '}';
    }
}
