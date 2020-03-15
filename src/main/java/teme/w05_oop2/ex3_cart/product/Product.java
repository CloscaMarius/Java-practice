package teme.w05_oop2.ex3_cart.product;

public class Product {
    private int id;
    private String name;
    private String type;
    private double price;
    private String color;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public Product(int id, String name, String type, double price, String color) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
