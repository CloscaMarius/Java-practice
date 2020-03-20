package teme.w06_collections.ex1_building_registry;

import java.util.*;

class BuildingRegistry {

    static int categoriesCount(List<Building> bs) {
        Set<Category> categories = new HashSet<>();
        for (Building b : bs) {
            categories.add(b.getCategory());
        }
        return categories.size();
    }

    static Collection<String> neighborhoodsList(List<Building> bs) {
        Set<String> neighborhoods = new TreeSet<>();
        for (Building b : bs) {
            neighborhoods.add(b.getNeighborhood());
        }
        return neighborhoods;
    }

    static double averagePriceForOneCategory(List<Building> bs, Category cat) {
        double totalPrice = 0;
        int numberOfBuildings = 0;
        for (Building b : bs) {
            if (b.getCategory() == cat) {
                totalPrice += b.getPrice();
                numberOfBuildings++;
            }
        }
        return (numberOfBuildings != 0)
                ? totalPrice / numberOfBuildings
                : 0;
    }

    static Map<Category, Double> averagePricePerCategory(List<Building> bs) {

        Map<Category, Double> result = new EnumMap<>(Category.class);
        for (Category cat : Category.values()) {
            Double value = averagePriceForOneCategory(bs, cat);
            result.put(cat, value);
        }
        return result;
    }

    static double averagePriceForOneNeighborhood(List<Building> bs, String neighborhood) {
        double totalPrice = 0;
        int numberOfBuildings = 0;
        for (Building b : bs) {
            if (b.getNeighborhood() == neighborhood) {
                totalPrice += b.getPrice();
                numberOfBuildings++;
            }
        }
        return (numberOfBuildings != 0)
                ? totalPrice / numberOfBuildings
                : 0;
    }

    static Map<String, Double> averagePricePerNeighborhood(List<Building> bs) {
        Map<String, Double> result = new TreeMap<>();
        for (String neighborhood : neighborhoodsList(bs)) {
            Double value = averagePriceForOneNeighborhood(bs, neighborhood);
            result.put(neighborhood, value);
        }
        return result;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        List<Building> buildings = Arrays.asList(
                new Building(Category.valueOf("OFFICE"), 10, "tudor"),
                new Building(Category.valueOf("OFFICE"), 40, "centru"),
                new Building(Category.valueOf("OFFICE"), 20, "pacurari"),
                new Building(Category.valueOf("RESIDENTIAL"), 15, "pacurari"),
                new Building(Category.valueOf("HOSPITAL"), 35, "pacurari"),
                new Building(Category.valueOf("HOSPITAL"), 30, "copou"));

        System.out.println("Actual categories: " + categoriesCount(buildings));
        System.out.println("Actual neighborhoods: " + neighborhoodsList(buildings));

        System.out.println("Average price for OFFICE category: " + averagePriceForOneCategory(buildings, Category.valueOf("OFFICE")));
        System.out.println("Average price for RELIGIOUS category: " + averagePriceForOneCategory(buildings, Category.valueOf("RELIGIOUS")));

        System.out.println("Average price per category: " + averagePricePerCategory(buildings));
        System.out.println("Average price per neighborhood: " + averagePricePerNeighborhood(buildings));
    }
}