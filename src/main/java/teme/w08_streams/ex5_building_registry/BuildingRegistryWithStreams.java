package teme.w08_streams.ex5_building_registry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class BuildingRegistryWithStreams {

    static int categoriesCount(List<Building> bs) {
        //TODO
        return -1;
    }

    static List<String> neighborhoodsList(List<Building> bs) {
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
                new Building(Category.OFFICE, 10, "tudor"),
                new Building(Category.OFFICE, 40, "centru"),
                new Building(Category.OFFICE, 20, "pacurari"),
                new Building(Category.RESIDENTIAL, 15, "pacurari"),
                new Building(Category.HOSPITAL, 35, "pacurari"),
                new Building(Category.HOSPITAL, 30, "copou"));

        System.out.println("Actual categories: " + categoriesCount(buildings));
        System.out.println("Actual neighborhoods: " + neighborhoodsList(buildings));

        System.out.println("Average price for OFFICE category: " + averagePriceForOneCategory(buildings, Category.OFFICE));
        System.out.println("Average price for RELIGIOUS category: " + averagePriceForOneCategory(buildings, Category.RELIGIOUS));

        System.out.println("Average price per category: " + averagePricePerCategory(buildings));
        System.out.println("Average price per neighborhood: " + averagePricePerNeighborhood(buildings));
    }
}
