package teme.w06_collections.ex1_building_registry;

import java.util.Objects;

class Building {

    private int price;
    private String neighborhood;
    private Category category;

    Building(Category category, int price, String neighborhood) {
        this.category = category;
        this.price = price;
        this.neighborhood = neighborhood;
    }

    public int getPrice() {
        return price;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Building{" +
                "price=" + price +
                ", neighborhood='" + neighborhood + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return price == building.price &&
                neighborhood.equals(building.neighborhood) &&
                category == building.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, neighborhood, category);
    }

}
