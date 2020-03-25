package teme.w08_streams.ex3_trader;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;

/**
 * MAX GRADE: 25p
 */
@RunWith(GradeRunner.class)
public class TraderOperationsTest {

    //build some traders
    private final Trader tony = new Trader("Tony", "Milan");
    private final Trader john = new Trader("John", "Cambridge");
    private final Trader oliver = new Trader("Oliver", "Cambridge");
    private final Trader ion = new Trader("Ion", "Iasi");

    //and some transactions
    private final List<Transaction> trans = Arrays.asList(
            new Transaction(2011, 100, tony),
            new Transaction(2012, 80, tony),
            new Transaction(2013, 120, tony),
            new Transaction(2011, 50, oliver),
            new Transaction(2010, 130, john),
            new Transaction(2011, 70, john),
            new Transaction(2012, 90, john),
            new Transaction(2011, 60, ion),
            new Transaction(2012, 140, ion));

    @Test
    @Grade(1)
    public void transactionFromYearSortedByValue_emptyList() {
        assertEquals(
                emptyList(),
                TraderOperations.transactionFromYearSortedByValue(trans, 2009));
    }

    @Test
    @Grade(2)
    public void transactionFromYearSortedByValue() {
        assertEquals(
                Arrays.asList(
                        new Transaction(2011, 50, oliver),
                        new Transaction(2011, 60, ion),
                        new Transaction(2011, 70, john),
                        new Transaction(2011, 100, tony)),
                TraderOperations.transactionFromYearSortedByValue(trans, 2011));
    }

    @Test
    @Grade(2)
    public void distinctTraderCities() {
        assertEquals(
                new HashSet<>(Arrays.asList("Milan", "Cambridge", "Iasi")),
                TraderOperations.distinctTraderCities(trans));
    }

    @Test
    @Grade(1)
    public void tradersFromCitySortedByNameDescending_wrongCity() {
        assertEquals(
                emptyList(),
                TraderOperations.tradersFromCitySortedByNameDescending(trans, "Vaslui"));
    }

    @Test
    @Grade(3)
    public void tradersFromCitySortedByNameDescending() {
        assertEquals(
                Arrays.asList(oliver, john),
                TraderOperations.tradersFromCitySortedByNameDescending(trans, "Cambridge"));
    }

    @Test
    @Grade(3)
    public void tradersNamesSorted() {
        assertEquals(
                "Ion,John,Oliver,Tony",
                TraderOperations.tradersNamesSorted(trans));
    }

    @Test
    @Grade(3)
    public void isAnyTraderFromCity() {
        assertTrue(TraderOperations.isAnyTraderFromCity(trans, "Milan"));
        assertFalse(TraderOperations.isAnyTraderFromCity(trans, "Vaslui"));
    }

    @Test
    @Grade(4)
    public void relocateTraders() {
        assertEquals("Milan", tony.getCity());
        try {
            TraderOperations.relocateTraders(trans, "Milan", "Cambridge");
            assertEquals("Cambridge", tony.getCity());
        } finally {
            tony.setCity("Milan"); //move him back, for rest of tests
        }
    }

    @Test
    @Grade(3)
    public void transactionWithHighestValue() {
        assertEquals(
                Optional.of(new Transaction(2012, 140, ion)),
                TraderOperations.transactionWithHighestValue(trans));
    }

    @Test
    @Grade(3)
    public void transactionWithLowestValue() {
        assertEquals(
                Optional.of(new Transaction(2011, 50, oliver)),
                TraderOperations.transactionWithLowestValue(trans));
    }
}