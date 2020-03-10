package teme.w06_collections.ex1_building_registry;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class BuildingRegistry {

    static int categoriesCount(List<Building> bs) {
        //TODO
        return -1;
    }

    static Collection<String> neighborhoodsList(List<Building> bs) {
        //TODO
        return null;
    }

    static double averagePriceForOneCategory(List<Building> bs, Category cat) {
        //TODO
        return -1;
    }

    static Map<Category, Double> averagePricePerCategory(List<Building> bs) {
        //TODO
        return null;
    }

    static Map<String, Double> averagePricePerNeighborhood(List<Building> bs) {
        //TODO
        return null;
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