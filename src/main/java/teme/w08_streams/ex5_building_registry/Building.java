package teme.w08_streams.ex5_building_registry;

enum Category {
    RESIDENTIAL,
    OFFICE,
    HOSPITAL,
    RELIGIOUS
}

class Building {
    private final Category category;
    private final double price;
    private final String neighborhood;

    Building(Category category, int price, String neighborhood) {
        this.category = category;
        this.price = price;
        this.neighborhood = neighborhood;
    }

    Category getCategory() {
        return category;
    }

    double getPrice() {
        return price;
    }

    String getNeighborhood() {
        return neighborhood;
    }

    @Override
    public String toString() {
        return "Building{" +
                "category=" + category +
                ", price=" + price +
                ", neighborhood='" + neighborhood + '\'' +
                '}';
    }
}
