package teme.w05_oop2.ex3_cart.customer;

public class Customer {
    private String firstName;
    private String lastName;
    private String cnp;
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public Address getAddress() {
        return address;
    }

    public Customer(String firstName, String lastName, String cnp, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", address=" + address +
                '}';
    }
}
