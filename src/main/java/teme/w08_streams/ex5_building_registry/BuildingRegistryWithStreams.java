package teme.w08_streams.ex5_building_registry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class BuildingRegistryWithStreams {

    static int categoriesCount(List<Building> bs) {
        // Set<Category> categories = new HashSet<>();
        //        for (Building b : bs) {
        //            categories.add(b.getCategory());
        //        }
        //        return categories.size();

        return (int) bs.stream()
                .map(b -> b.getCategory())
                .distinct()
                .count();
    }

    static List<String> neighborhoodsList(List<Building> bs) {
        //Set<String> neighborhoods = new TreeSet<>();
        //        for (Building b : bs) {
        //            neighborhoods.add(b.getNeighborhood());
        //        }
        //        return neighborhoods;

        return bs.stream()
                .map(b -> b.getNeighborhood())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    static double averagePriceForOneCategory(List<Building> bs, Category cat) {
        //        double totalPrice = 0;
        //        int numberOfBuildings = 0;
        //        for (Building b : bs) {
        //            if (b.getCategory() == cat) {
        //                totalPrice += b.getPrice();
        //                numberOfBuildings++;
        //            }
        //        }
        //        return (numberOfBuildings != 0)
        //                ? totalPrice / numberOfBuildings
        //                : 0;

        /*double totalPrice = bs.stream()
                .filter(b -> b.getCategory() == cat)
                .map(b->b.getPrice())
                .reduce((double) 0, (a, b) -> a + b);

        int numberOfBuildings = (int) bs.stream()
                .filter(b -> b.getCategory() == cat)
                .count();

        return (numberOfBuildings != 0)
                        ? totalPrice / numberOfBuildings
                        : 0;*/

        return bs.stream()
                .filter(building -> building.getCategory().equals(cat))
                .mapToDouble(Building::getPrice)
                .average()
                .orElse(0);
    }

    static Map<Category, Double> averagePricePerCategory(List<Building> bs) {
        //Map<Category, Double> result = new EnumMap<>(Category.class);
        //        for (Category cat : Category.values()) {
        //            Double value = averagePriceForOneCategory(bs, cat);
        //            result.put(cat, value);
        //        }
        //        return result;

        return Arrays.stream(Category.values())
                .collect(Collectors.toMap(i -> i, i -> averagePriceForOneCategory(bs, i)));

    }

    static Map<String, Double> averagePricePerNeighborhood(List<Building> bs) {
        //        double totalPrice = 0;
        //        int numberOfBuildings = 0;
        //        for (Building b : bs) {
        //            if (b.getNeighborhood() == neighborhood) {
        //                totalPrice += b.getPrice();
        //                numberOfBuildings++;
        //            }
        //        }
        //        return (numberOfBuildings != 0)
        //                ? totalPrice / numberOfBuildings
        //                : 0;

        return neighborhoodsList(bs).stream()
                .distinct()
                .collect(Collectors.toMap(i -> i, i -> averagePriceForOneNeighborhood(bs, i)));
    }

    static double averagePriceForOneNeighborhood(List<Building> bs, String neighborhood) {

        return bs.stream()
                .filter(building -> building.getNeighborhood().equals(neighborhood))
                .mapToDouble(Building::getPrice)
                .average()
                .orElse(0);

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
