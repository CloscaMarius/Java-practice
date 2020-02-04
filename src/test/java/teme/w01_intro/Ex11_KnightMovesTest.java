package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.*;
import static teme.w01_intro.Ex11_KnightMoves.*;

/**
 * MAX GRADE: 20p
 */
@RunWith(GradeRunner.class)
public class Ex11_KnightMovesTest {

    @Test
    @Grade(3)
    public void testIsValidPosition() {
        assertTrue(isValidPos(8, 1));
        assertTrue(isValidPos(1, 8));
        assertFalse(isValidPos(1, 9));
        assertFalse(isValidPos(0, 4));
    }

    @Test
    @Grade(3)
    public void testComputeDestinationIfValid() {
        assertEquals("", getDestinationIfValid(0, 1, +1, +1)); //invalid source
        assertEquals("", getDestinationIfValid(2, 4, -2, +1)); //invalid dest
        assertEquals("(4,5)", getDestinationIfValid(2, 4, +2, +1));
    }

    @Test
    @Grade(3)
    public void testComputeAllKnightMoveDestinations_invalidStartPosition() {
        assertEquals("", getAllValidDestinations(0, 1));
        assertEquals("", getAllValidDestinations(1, 9));
    }

    @Test
    @Grade(3)
    public void testComputeAllKnightMoveDestinations_allDestinationsValid() {
        assertEquals(
                "(1,2)(1,4)(2,1)(2,5)(4,1)(4,5)(5,2)(5,4)",
                sorted(getAllValidDestinations(3, 3)));
        assertEquals(
                "(2,3)(2,5)(3,2)(3,6)(5,2)(5,6)(6,3)(6,5)",
                sorted(getAllValidDestinations(4, 4)));
    }

    @Test
    @Grade(2)
    public void testComputeAllKnightMoveDestinations_someDestinationsValid_2() {
        assertEquals(
                "(2,3)(3,2)",
                sorted(getAllValidDestinations(1, 1)));
    }

    @Test
    @Grade(2)
    public void testComputeAllKnightMoveDestinations_someDestinationsValid_3() {
        assertEquals(
                "(5,2)(6,3)(8,3)",
                sorted(getAllValidDestinations(7, 1)));
    }

    @Test
    @Grade(2)
    public void testComputeAllKnightMoveDestinations_someDestinationsValid_4() {
        assertEquals(
                "(2,1)(2,5)(3,2)(3,4)",
                sorted(getAllValidDestinations(1, 3)));
    }

    @Test
    @Grade(2)
    public void testComputeAllKnightMoveDestinations_someDestinationsValid_6() {
        assertEquals(
                "(1,2)(1,6)(3,2)(3,6)(4,3)(4,5)",
                sorted(getAllValidDestinations(2, 4)));
    }

    private static String sorted(String destinations) {
        return Arrays.stream(destinations.replaceAll("\\s+", "").split("[)(]"))
                .filter(s -> !s.isEmpty())
                .sorted()
                .collect(joining(")(", "(", ")"));
    }
}
