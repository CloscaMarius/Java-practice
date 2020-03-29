package teme.w07_comparable.ex1_stock_market;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.time.LocalDate;
import java.util.Arrays;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

/**
 * MAX GRADE: 30p
 */
@RunWith(GradeRunner.class)
public class StockMarketTest {

    private static final double PRECISION = 0.01;

    @Test
    @Grade(3)
    public void testEquals() {

        //these should be seen as equal (all fields the same)
        assertEquals(
                new StockUpdate("GOOG", LocalDate.of(2019, 1, 1), 1.1),
                new StockUpdate("GOOG", LocalDate.of(2019, 1, 1), 1.1));

        //these should be seen as not equal (at least 1 field is different)
        assertNotEquals(
                new StockUpdate("GOOG", LocalDate.of(2019, 1, 1), 1.1),
                new StockUpdate("AMZ", LocalDate.of(2019, 1, 1), 1.1));
        assertNotEquals(
                new StockUpdate("GOOG", LocalDate.of(2019, 2, 1), 1.1),
                new StockUpdate("GOOG", LocalDate.of(2019, 1, 1), 1.1));
        assertNotEquals(
                new StockUpdate("GOOG", LocalDate.of(2019, 1, 1), 1.1),
                new StockUpdate("GOOG", LocalDate.of(2019, 1, 1), 2.2));
    }

    @Test
    @Grade(1)
    public void testHashCode() {
        //these should be considered equal, so should have exactly the same hashCode
        assertEquals(
                new StockUpdate("GOOG", LocalDate.of(2019, 1, 1), 1).hashCode(),
                new StockUpdate("GOOG", LocalDate.of(2019, 1, 1), 1).hashCode());
    }

    @Test
    @Grade(1)
    public void testAddAndGetUpdates_emptyMarket() {
        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 12, 30);

        StockMarket market = new StockMarket();
        assertTrue(market.getUpdates(d1, d1).isEmpty());
        assertTrue(market.getUpdates(d1, d2).isEmpty());
        assertTrue(market.getUpdates(d2, d2).isEmpty());
    }

    @Test
    @Grade(1)
    public void testAddAndGetUpdatesByCode_emptyMarket() {
        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 12, 30);

        StockMarket market = new StockMarket();
        assertTrue(market.getUpdates(d1, d1, "AMZ").isEmpty());
        assertTrue(market.getUpdates(d1, d2, "AMZ").isEmpty());
        assertTrue(market.getUpdates(d2, d2, "AMZ").isEmpty());

        assertTrue(market.getUpdates(d1, d1, "").isEmpty());
        assertTrue(market.getUpdates(d1, d2, "").isEmpty());
        assertTrue(market.getUpdates(d2, d2, "").isEmpty());
    }

    @Test
    @Grade(1)
    public void testAddAndGetUpdates_oneStock_oneUpdate() {

        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);

        StockMarket market = new StockMarket();
        assertTrue(market.getUpdates(d1, d3).isEmpty());

        StockUpdate g2 = new StockUpdate("GOOG", d2, 1.2);
        market.add(g2);

        assertEquals(singletonList(g2), market.getUpdates(d1, d3));

        assertTrue(market.getUpdates(d1, d1).isEmpty());
        assertTrue(market.getUpdates(d3, d3).isEmpty());
    }

    @Test
    @Grade(1)
    public void testAddAndGetUpdatesByCode_oneStock_oneUpdate() {

        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);

        StockMarket market = new StockMarket();
        assertTrue(market.getUpdates(d1, d3, "GOOG").isEmpty());

        StockUpdate g2 = new StockUpdate("GOOG", d2, 1.2);
        market.add(g2);

        assertEquals(singletonList(g2), market.getUpdates(d1, d3, "GOOG"));
        assertTrue(market.getUpdates(d1, d1, "GOOG").isEmpty());
        assertTrue(market.getUpdates(d3, d3, "GOOG").isEmpty());
    }

    @Test
    @Grade(1)
    public void testAddAndGetUpdates_oneStock_oneUpdate_includesTimeIntervalEnds() {

        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);

        StockMarket market = new StockMarket();
        assertTrue(market.getUpdates(d1, d3).isEmpty());

        StockUpdate g2 = new StockUpdate("GOOG", d2, 1.2);
        market.add(g2);

        assertEquals(singletonList(g2), market.getUpdates(d1, d3));
        assertEquals(singletonList(g2), market.getUpdates(d1, d2));
        assertEquals(singletonList(g2), market.getUpdates(d2, d3));
        assertEquals(singletonList(g2), market.getUpdates(d2, d2));

        assertTrue(market.getUpdates(d1, d1).isEmpty());
        assertTrue(market.getUpdates(d3, d3).isEmpty());
    }

    @Test
    @Grade(1)
    public void testAddAndGetUpdatesByCode_oneStock_oneUpdate_includesTimeIntervalEnds() {

        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);

        StockMarket market = new StockMarket();
        assertTrue(market.getUpdates(d1, d3, "GOOG").isEmpty());

        StockUpdate g2 = new StockUpdate("GOOG", d2, 1.2);
        market.add(g2);

        assertEquals(singletonList(g2), market.getUpdates(d1, d3, "GOOG"));
        assertEquals(singletonList(g2), market.getUpdates(d1, d2, "GOOG"));
        assertEquals(singletonList(g2), market.getUpdates(d2, d3, "GOOG"));
        assertEquals(singletonList(g2), market.getUpdates(d2, d2, "GOOG"));

        assertTrue(market.getUpdates(d1, d1, "GOOG").isEmpty());
        assertTrue(market.getUpdates(d3, d3, "GOOG").isEmpty());

        assertEquals(singletonList(g2), market.getUpdates(d1, d3, "GOOG"));

        //should include interval ends too
        assertEquals(singletonList(g2), market.getUpdates(d1, d2, "GOOG"));
        assertEquals(singletonList(g2), market.getUpdates(d2, d3, "GOOG"));
        assertEquals(singletonList(g2), market.getUpdates(d2, d2, "GOOG"));
    }

    @Test
    @Grade(2)
    public void testAddAndGetUpdates_oneStockMultipleUpdates_returnsAllUpdates() {

        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);
        LocalDate d4 = LocalDate.of(2019, 1, 4);
        LocalDate d5 = LocalDate.of(2019, 1, 5);
        LocalDate d6 = LocalDate.of(2019, 1, 6);
        LocalDate d7 = LocalDate.of(2019, 1, 7);

        StockMarket market = new StockMarket();
        assertTrue(market.getUpdates(d1, d6, "GOOG").isEmpty());

        StockUpdate g2 = new StockUpdate("GOOG", d2, 2.2);
        StockUpdate g4 = new StockUpdate("GOOG", d4, 2.4);
        StockUpdate g6 = new StockUpdate("GOOG", d6, 2.6);
        market.add(g2);
        market.add(g4);
        market.add(g6);

        assertTrue(market.getUpdates(d1, d1).isEmpty());
        assertTrue(market.getUpdates(d3, d3).isEmpty());
        assertTrue(market.getUpdates(d5, d5).isEmpty());

        assertEquals(singletonList(g2), market.getUpdates(d1, d3));
        assertEquals(singletonList(g4), market.getUpdates(d3, d5));
        assertEquals(singletonList(g6), market.getUpdates(d5, d7));

        assertEquals(Arrays.asList(g2, g4), market.getUpdates(d1, d5));
        assertEquals(Arrays.asList(g4, g6), market.getUpdates(d3, d7));
        assertEquals(Arrays.asList(g2, g4, g6), market.getUpdates(d1, d7));
    }

    @Test
    @Grade(2)
    public void testAddAndGetUpdatesByCode_oneStockMultipleUpdates_returnsAllUpdates() {

        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);
        LocalDate d4 = LocalDate.of(2019, 1, 4);
        LocalDate d5 = LocalDate.of(2019, 1, 5);
        LocalDate d6 = LocalDate.of(2019, 1, 6);
        LocalDate d7 = LocalDate.of(2019, 1, 7);

        StockMarket market = new StockMarket();
        assertTrue(market.getUpdates(d1, d6, "GOOG").isEmpty());

        StockUpdate g2 = new StockUpdate("GOOG", d2, 2.2);
        StockUpdate g4 = new StockUpdate("GOOG", d4, 2.4);
        StockUpdate g6 = new StockUpdate("GOOG", d6, 2.6);
        market.add(g2);
        market.add(g4);
        market.add(g6);

        assertTrue(market.getUpdates(d1, d1, "GOOG").isEmpty());
        assertTrue(market.getUpdates(d3, d3, "GOOG").isEmpty());
        assertTrue(market.getUpdates(d5, d5, "GOOG").isEmpty());

        assertEquals(singletonList(g2), market.getUpdates(d1, d3, "GOOG"));
        assertEquals(singletonList(g4), market.getUpdates(d3, d5, "GOOG"));
        assertEquals(singletonList(g6), market.getUpdates(d5, d7, "GOOG"));

        assertEquals(Arrays.asList(g2, g4), market.getUpdates(d1, d5, "GOOG"));
        assertEquals(Arrays.asList(g4, g6), market.getUpdates(d3, d7, "GOOG"));
        assertEquals(Arrays.asList(g2, g4, g6), market.getUpdates(d1, d7, "GOOG"));
    }


    @Test
    @Grade(2)
    public void testGetUpdates_twoStocks() {

        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);
        LocalDate d4 = LocalDate.of(2019, 1, 4);
        LocalDate d5 = LocalDate.of(2019, 1, 5);

        StockUpdate g2 = new StockUpdate("GOOG", d2, 2.2);
        StockUpdate a4 = new StockUpdate("AMZ", d4, 1.4);

        StockMarket market = new StockMarket();
        market.add(g2);
        market.add(a4);

        assertEquals(emptyList(), market.getUpdates(d1, d1));
        assertEquals(singletonList(g2), market.getUpdates(d1, d3));
        assertEquals(singletonList(a4), market.getUpdates(d3, d5));
        assertEquals(Arrays.asList(g2, a4), market.getUpdates(d1, d5));
        assertEquals(emptyList(), market.getUpdates(d5, d5));
    }

    @Test
    @Grade(2)
    public void testGetUpdatesByCode_twoStocks() {

        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);
        LocalDate d4 = LocalDate.of(2019, 1, 4);
        LocalDate d5 = LocalDate.of(2019, 1, 5);

        StockUpdate g2 = new StockUpdate("GOOG", d2, 2.2);
        StockUpdate a4 = new StockUpdate("AMZ", d4, 1.4);

        StockMarket market = new StockMarket();
        market.add(g2);
        market.add(a4);

        assertEquals(singletonList(g2), market.getUpdates(d1, d5, "GOOG"));
        assertEquals(singletonList(g2), market.getUpdates(d1, d3, "GOOG"));

        assertEquals(singletonList(a4), market.getUpdates(d1, d5, "AMZ"));
        assertEquals(singletonList(a4), market.getUpdates(d3, d5, "AMZ"));

        assertEquals(emptyList(), market.getUpdates(d4, d5, "GOOG"));
        assertEquals(emptyList(), market.getUpdates(d1, d2, "AMZ"));

        assertEquals(emptyList(), market.getUpdates(d1, d5, "GOO"));
        assertEquals(emptyList(), market.getUpdates(d1, d5, "AM"));
        assertEquals(emptyList(), market.getUpdates(d1, d5, "MSFT"));
        assertEquals(emptyList(), market.getUpdates(d1, d5, ""));
    }


    @Test
    @Grade(2)
    public void testGetUpdates_multipleStocksAndUpdates() {
        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);
        LocalDate d4 = LocalDate.of(2019, 1, 4);
        LocalDate d5 = LocalDate.of(2019, 1, 5);
        LocalDate d6 = LocalDate.of(2019, 1, 6);
        LocalDate d7 = LocalDate.of(2019, 1, 7);

        StockUpdate g2 = new StockUpdate("GOOG", d2, 2.2);
        StockUpdate g6 = new StockUpdate("GOOG", d6, 2.6);
        StockUpdate a4 = new StockUpdate("AMZ", d4, 1.4);
        StockUpdate a6 = new StockUpdate("AMZ", d6, 1.6);

        StockMarket market = new StockMarket();
        market.add(g2);
        market.add(a4);
        market.add(a6);
        market.add(g6);

        assertEquals(emptyList(), market.getUpdates(d1, d1));
        assertEquals(singletonList(g2), market.getUpdates(d1, d3));
        assertEquals(Arrays.asList(g2, a4), market.getUpdates(d1, d5));
        assertEquals(Arrays.asList(a4, a6, g6), market.getUpdates(d3, d7));
        assertEquals(Arrays.asList(a6, g6), market.getUpdates(d5, d7));
        assertEquals(Arrays.asList(g2, a4, a6, g6), market.getUpdates(d1, d7));

        assertEquals(emptyList(), market.getUpdates(d3, d5, "GOOG"));
        assertEquals(singletonList(g2), market.getUpdates(d1, d3, "GOOG"));
        assertEquals(singletonList(g2), market.getUpdates(d1, d5, "GOOG"));
        assertEquals(singletonList(g6), market.getUpdates(d3, d7, "GOOG"));
        assertEquals(Arrays.asList(g2, g6), market.getUpdates(d1, d7, "GOOG"));

        assertEquals(emptyList(), market.getUpdates(d1, d3, "AMZ"));
        assertEquals(singletonList(a4), market.getUpdates(d1, d5, "AMZ"));
        assertEquals(singletonList(a6), market.getUpdates(d5, d7, "AMZ"));
        assertEquals(Arrays.asList(a4, a6), market.getUpdates(d3, d7, "AMZ"));
        assertEquals(Arrays.asList(a4, a6), market.getUpdates(d1, d7, "AMZ"));

        assertEquals(emptyList(), market.getUpdates(d1, d7, "GO"));
        assertEquals(emptyList(), market.getUpdates(d1, d7, "AM"));
        assertEquals(emptyList(), market.getUpdates(d1, d7, ""));
    }


    @Test
    @Grade(2)
    public void testPrices_multipleUpdates_resultsAreSortedByDateThenCode() {
        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);
        LocalDate d4 = LocalDate.of(2019, 1, 4);
        LocalDate d5 = LocalDate.of(2019, 1, 5);

        StockUpdate g2 = new StockUpdate("GOOG", d2, 2.2);
        StockUpdate a3 = new StockUpdate("AMZ", d3, 1.3);
        StockUpdate a4 = new StockUpdate("AMZ", d4, 1.4);
        StockUpdate g4 = new StockUpdate("GOOG", d4, 2.4);

        StockMarket market = new StockMarket();
        //may add them in any order
        market.add(a4);
        market.add(a3);
        market.add(g4);
        market.add(g2);

        //but results of getUpdates should be sorted at least by date (then maybe code)
        assertEquals(Arrays.asList(a3, a4), market.getUpdates(d1, d5, "AMZ"));
        assertEquals(Arrays.asList(g2, g4), market.getUpdates(d1, d5, "GOOG"));

        //order should be: g2, a3, then (a4 or g4) ..
        assertTrue(
                Arrays.equals(new StockUpdate[]{g2, a3, a4, g4}, market.getUpdates(d1, d5).toArray()) ||
                        Arrays.equals(new StockUpdate[]{g2, a3, g4, a4}, market.getUpdates(d1, d5).toArray()));
    }

    @Test
    @Grade(2)
    public void testPrices_emptyMarket() {
        LocalDate d1 = LocalDate.of(2019, 1, 1);

        StockMarket market = new StockMarket();
        assertEquals(0.0, market.getPrice(d1, ""), PRECISION);
        assertEquals(0.0, market.getPrice(d1, "AMZ"), PRECISION);
        assertEquals(0.0, market.getPrice(d1, "GOOG"), PRECISION);
        assertTrue(market.getPrices(d1).isEmpty());
    }

    @Test
    @Grade(2)
    public void testPrices_oneUpdate() {
        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);

        StockUpdate a2 = new StockUpdate("AMZ", d2, 1.2);
        StockUpdate g2 = new StockUpdate("GOOG", d2, 2.2);

        StockMarket market = new StockMarket();
        market.add(a2);
        market.add(g2);

        //at d1:
        assertEquals(0.0, market.getPrice(d1, "AMZ"), PRECISION);
        assertEquals(0.0, market.getPrice(d1, "GOOG"), PRECISION);

        assertTrue(market.getPrices(d1).isEmpty());

        //at d2:
        assertEquals(1.2, market.getPrice(d2, "AMZ"), PRECISION);
        assertEquals(2.2, market.getPrice(d2, "GOOG"), PRECISION);

        assertEquals(2, market.getPrices(d2).size());
        assertEquals(1.2, market.getPrices(d2).get("AMZ"), PRECISION);
        assertEquals(2.2, market.getPrices(d2).get("GOOG"), PRECISION);
    }

    @Test
    @Grade(2)
    public void testPrices_oneUpdate_getAtLaterDate() {
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);

        StockMarket market = new StockMarket();
        market.add(new StockUpdate("AMZ", d2, 1.2));
        market.add(new StockUpdate("GOOG", d2, 2.2));

        //at d3:
        assertEquals(1.2, market.getPrice(d3, "AMZ"), PRECISION);
        assertEquals(2.2, market.getPrice(d3, "GOOG"), PRECISION);

        assertEquals(2, market.getPrices(d3).size());
        assertEquals(1.2, market.getPrices(d3).get("AMZ"), PRECISION);
        assertEquals(2.2, market.getPrices(d3).get("GOOG"), PRECISION);
    }

    @Test
    @Grade(2)
    public void testPrices_multipleUpdates() {
        LocalDate d1 = LocalDate.of(2019, 1, 1);
        LocalDate d2 = LocalDate.of(2019, 1, 2);
        LocalDate d3 = LocalDate.of(2019, 1, 3);
        LocalDate d4 = LocalDate.of(2019, 1, 4);
        LocalDate d5 = LocalDate.of(2019, 1, 5);

        StockUpdate g2 = new StockUpdate("GOOG", d2, 2.2);
        StockUpdate a3 = new StockUpdate("AMZ", d3, 1.3);
        StockUpdate a4 = new StockUpdate("AMZ", d4, 1.4);
        StockUpdate g4 = new StockUpdate("GOOG", d4, 2.4);

        StockMarket market = new StockMarket();
        assertEquals(0.0, market.getPrice(d1, ""), PRECISION);
        assertEquals(0.0, market.getPrice(d1, "AMZ"), PRECISION);
        assertEquals(0.0, market.getPrice(d1, "GOOG"), PRECISION);

        market.add(g2);
        market.add(a3);
        market.add(a4);
        market.add(g4);

        //at d1:
        assertEquals(0.0, market.getPrice(d1, "AMZ"), PRECISION);
        assertEquals(0.0, market.getPrice(d1, "GOOG"), PRECISION);

        assertTrue(market.getPrices(d1).isEmpty());

        //at d2:
        assertEquals(0.0, market.getPrice(d2, "AMZ"), PRECISION);
        assertEquals(2.2, market.getPrice(d2, "GOOG"), PRECISION);

        assertEquals(1, market.getPrices(d2).size());
        assertEquals(2.2, market.getPrices(d2).get("GOOG"), PRECISION);

        //at d3:
        assertEquals(1.3, market.getPrice(d3, "AMZ"), PRECISION);
        assertEquals(2.2, market.getPrice(d3, "GOOG"), PRECISION);

        assertEquals(2, market.getPrices(d3).size());
        assertEquals(1.3, market.getPrices(d3).get("AMZ"), PRECISION);
        assertEquals(2.2, market.getPrices(d3).get("GOOG"), PRECISION);

        //at d4:
        assertEquals(1.4, market.getPrice(d4, "AMZ"), PRECISION);
        assertEquals(2.4, market.getPrice(d4, "GOOG"), PRECISION);

        assertEquals(2, market.getPrices(d4).size());
        assertEquals(1.4, market.getPrices(d4).get("AMZ"), PRECISION);
        assertEquals(2.4, market.getPrices(d4).get("GOOG"), PRECISION);

        //at d5:
        assertEquals(1.4, market.getPrice(d5, "AMZ"), PRECISION);
        assertEquals(2.4, market.getPrice(d5, "GOOG"), PRECISION);

        assertEquals(2, market.getPrices(d5).size());
        assertEquals(1.4, market.getPrices(d5).get("AMZ"), PRECISION);
        assertEquals(2.4, market.getPrices(d5).get("GOOG"), PRECISION);
    }
}
