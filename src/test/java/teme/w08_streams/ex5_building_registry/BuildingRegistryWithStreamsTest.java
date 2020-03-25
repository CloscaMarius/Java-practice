package teme.w08_streams.ex5_building_registry;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * MAX GRADE: 25p
 */
@RunWith(GradeRunner.class)
public class BuildingRegistryWithStreamsTest {
    private static final double PRECISION = 0.01;

    private final List<Building> noBuildings = new ArrayList<>();

    private List<Building> buildings() {
        return Arrays.asList(
                new Building(office(), 10, "tudor"),
                new Building(office(), 40, "centru"),
                new Building(office(), 20, "pacurari"),
                new Building(residential(), 15, "pacurari"),
                new Building(hospital(), 35, "pacurari"),
                new Building(hospital(), 30, "copou"));
    }

    private Category office() {
        return Category.valueOf("OFFICE");
    }

    private Category residential() {
        return Category.valueOf("RESIDENTIAL");
    }

    private Category hospital() {
        return Category.valueOf("HOSPITAL");
    }

    private Category religious() {
        return Category.valueOf("RELIGIOUS");
    }

    @Test
    @Grade(2)
    public void testActualCategories_noBuildings() {
        assertEquals(0, BuildingRegistryWithStreams.categoriesCount(noBuildings));
    }

    @Test
    @Grade(2)
    public void testActualCategories() {
        assertEquals(3, BuildingRegistryWithStreams.categoriesCount(buildings()));
    }


    @Test
    @Grade(2)
    public void testActualNeighborhoods_noBuildings() {
        assertTrue(BuildingRegistryWithStreams.neighborhoodsList(noBuildings).isEmpty());
    }

    @Test
    @Grade(2)
    public void testActualNeighborhoods() {
        assertEquals(
                Arrays.asList("centru", "copou", "pacurari", "tudor"),
                new ArrayList<>(BuildingRegistryWithStreams.neighborhoodsList(buildings())));
    }

    @Test
    @Grade(2)
    public void testAveragePriceForOneCategory_noBuildings() {
        assertEquals(0, BuildingRegistryWithStreams.averagePriceForOneCategory(noBuildings, office()), PRECISION);
    }

    @Test
    @Grade(4)
    public void testAveragePriceForOneCategory() {
        assertEquals(23.33, BuildingRegistryWithStreams.averagePriceForOneCategory(buildings(), office()), PRECISION);
    }


    @Test
    @Grade(2)
    public void testAveragePricePerCategory_noBuildings() {
        Map<Category, Double> res = BuildingRegistryWithStreams.averagePricePerCategory(noBuildings);
        for (Category c : Category.values()) {
            assertEquals(0, res.getOrDefault(c, 0.0), PRECISION);
        }
    }

    @Test
    @Grade(3)
    public void testAveragePricePerCategory() {
        Map<Category, Double> res = BuildingRegistryWithStreams.averagePricePerCategory(buildings());
        assertEquals(23.33, res.get(office()), PRECISION);
        assertEquals(32.5, res.get(hospital()), PRECISION);
        assertEquals(15, res.get(residential()), PRECISION);
        assertEquals(0, res.getOrDefault(religious(), 0.0), PRECISION);
    }

    @Test
    @Grade(2)
    public void testAveragePricePerNeighborhood_noBuildings() {
        assertTrue(BuildingRegistryWithStreams.averagePricePerNeighborhood(noBuildings).isEmpty());
    }

    @Test
    @Grade(4)
    public void testAveragePricePerNeighborhood() {
        Map<String, Double> res = BuildingRegistryWithStreams.averagePricePerNeighborhood(buildings());
        assertEquals(4, res.size());
        assertEquals(40, res.get("centru"), PRECISION);
        assertEquals(30, res.get("copou"), PRECISION);
        assertEquals(10, res.get("tudor"), PRECISION);
        assertEquals(23.33, res.get("pacurari"), PRECISION);
    }
}