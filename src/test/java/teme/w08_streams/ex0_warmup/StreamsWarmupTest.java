package teme.w08_streams.ex0_warmup;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.TestUtil;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

/**
 * MAX GRADE: 30p+5p
 */
@RunWith(GradeRunner.class)
public class StreamsWarmupTest {

    @Test
    @Grade(2)
    public void onlyBetween10And100() {
        assertEquals(
                Arrays.asList(12, 17, 22, 34, 15),
                StreamsWarmup.onlyBetween10And100(Arrays.asList(3, 12, 101, 17, 0, 22, 150, -4, 34, 15, 209)));
    }

    @Test
    @Grade(2)
    public void startWithLetterAndHaveLength() {
        assertEquals(
                Arrays.asList("aaa", "abc"),
                StreamsWarmup.startWithLetterAndHaveLength('a', 3, Arrays.asList("aaabbccccd", "aaa", "ab", "bcd", "", "ABC", "abc")));
    }

    @Test
    @Grade(2)
    public void withoutEmptyStringsAndChangedToUpperAndSorted() {
        assertEquals(
                Arrays.asList("42", "?!", "AA", "ABC", "BLA", "NO", "XY"),
                StreamsWarmup.withoutEmptyStringsAndChangedToUpperAndSorted(new String[]{"", "aBc", "xy", "bla", "", "aa", "no", "42", "", "?!"}));
    }


    @Test
    @Grade(2)
    public void addLetterForEvenOdd() {
        assertEquals(
                "o3,e12,e0,o-7,o5,e2,e100",
                StreamsWarmup.addLetterForEvenOdd(Arrays.asList(3, 12, 0, -7, 5, 2, 100)));
    }

    @Test
    @Grade(2)
    public void only3Smallest() {
        assertEquals(
                Arrays.asList(-4, 0, 0),
                StreamsWarmup.only3Smallest(new Integer[]{3, 12, 0, 101, 17, 0, 22, 150, -4, 34, 4, 15, 209}));
        assertEquals(
                Arrays.asList(3, 3),
                StreamsWarmup.only3Smallest(new Integer[]{3, 3}));
    }

    @Test
    @Grade(1)
    public void only3SmallestNoDuplicates() {
        assertEquals(
                Arrays.asList(-4, 0, 3),
                StreamsWarmup.only3SmallestNoDuplicates(new Integer[]{3, 12, 0, 101, 17, 0, 22, 150, -4, 34, 4, 15, 209}));
        assertEquals(
                singletonList(3),
                StreamsWarmup.only3SmallestNoDuplicates(new Integer[]{3, 3}));
    }

    @Test
    @Grade(2)
    public void only3BiggestNoDuplicates() {
        assertEquals(
                Arrays.asList(209, 150, 101),
                StreamsWarmup.only3BiggestNoDuplicates(new Integer[]{3, 12, 0, 101, 17, 0, 22, 150, -4, 34, 4, 15, 209}));
        assertEquals(
                singletonList(3),
                StreamsWarmup.only3BiggestNoDuplicates(new Integer[]{3, 3}));
    }

    @Test
    @Grade(1)
    public void countOfEvenNumbers() {
        assertEquals(
                8,
                StreamsWarmup.countOfEvenNumbers(Arrays.asList(3, 12, 0, 101, 17, 0, 22, 150, -4, 34, 4, 15, 209)));
    }

    @Test
    @Grade(2)
    public void printPositives() {
        String out = TestUtil.runCapturingOutput(() ->
                StreamsWarmup.printPositives(new double[]{3, -12, 0, 101, 17, -22, 1.25, -4.3, 3.4, 0.2, -15, 209}));

        assertTrue(out.contains("3.0"));
        assertTrue(out.contains("101.0"));
        assertTrue(out.contains("17.0"));
        assertTrue(out.contains("1.25"));
        assertTrue(out.contains("3.4"));
        assertTrue(out.contains("0.2"));
        assertTrue(out.contains("209.0"));
    }

    @Test
    @Grade(2)
    public void checkIfAllEven() {
        assertTrue(StreamsWarmup.checkIfAllEven(emptyList()));
        assertTrue(StreamsWarmup.checkIfAllEven(Arrays.asList(2L, 4L, 0L, -8L, 66L)));
        assertFalse(StreamsWarmup.checkIfAllEven(Arrays.asList(2L, 4L, 0L, -8L, 7L, 66L)));
        assertFalse(StreamsWarmup.checkIfAllEven(Arrays.asList(3L, 1L)));
    }

    @Test
    @Grade(2)
    public void findNameOfFirstPersonWithHairColor() {
        List<Person> persons = Arrays.asList(
                new Person("Ion", HairColor.BROWN, 23),
                new Person("Maria", HairColor.RED, 25),
                new Person("Vasile", HairColor.BLACK, 20));
        assertEquals("Ion", StreamsWarmup.findNameOfFirstPersonWithHairColor(persons, HairColor.BROWN));
        assertEquals("Vasile", StreamsWarmup.findNameOfFirstPersonWithHairColor(persons, HairColor.BLACK));
        assertEquals("NONE", StreamsWarmup.findNameOfFirstPersonWithHairColor(persons, HairColor.BLONDE));
    }

    @Test
    @Grade(2)
    public void averageAge() {
        List<Person> persons = Arrays.asList(
                new Person("Ion", HairColor.BROWN, 23),
                new Person("Maria", HairColor.RED, 25),
                new Person("Vasile", HairColor.BLACK, 18));
        assertEquals(
                22.0,
                StreamsWarmup.averageAge(persons), 0.1);
        assertEquals(
                0,
                StreamsWarmup.averageAge(emptyList()), 0.1);
    }

    @Test
    @Grade(2)
    public void nameOfOldest() {
        List<Person> persons = Arrays.asList(
                new Person("Ion", HairColor.BROWN, 23),
                new Person("Maria", HairColor.RED, 25),
                new Person("Vasile", HairColor.BLACK, 18));
        assertEquals(
                "Maria",
                StreamsWarmup.nameOfOldest(persons));
        assertEquals(
                "NONE",
                StreamsWarmup.nameOfOldest(emptyList()));
    }


    @Test
    @Grade(2)
    public void pow3greater() {
        assertEquals(
                Arrays.asList(2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721),
                StreamsWarmup.powGreaterThan(3, 1000, 10));
    }

    @Test
    @Grade(2)
    public void allSquareNumbersBetween() {
        assertEquals(
                Arrays.asList(1024, 1089, 1156, 1225, 1296, 1369, 1444, 1521, 1600, 1681, 1764, 1849, 1936, 2025, 2116, 2209, 2304, 2401, 2500),
                StreamsWarmup.allSquareNumbersBetween(1024, 2500));
    }

    @Test
    @Grade(2)
    public void groupedByHairColor() {
        Person ion = new Person("Ion", HairColor.BROWN, 23);
        Person maria = new Person("Maria", HairColor.RED, 25);
        Person oana = new Person("Oana", HairColor.RED, 29);
        Person ana = new Person("Ana", HairColor.BLACK, 31);
        Person vasile = new Person("Vasile", HairColor.BLACK, 38);
        List<Person> persons = Arrays.asList(ion, maria, oana, ana, vasile);

        Map<HairColor, List<Person>> expected = new HashMap<HairColor, List<Person>>() {{
            put(HairColor.BLACK, Arrays.asList(ana, vasile));
            put(HairColor.BROWN, singletonList(ion));
            put(HairColor.RED, Arrays.asList(maria, oana));
        }};
        assertEquals(
                expected,
                StreamsWarmup.groupedByHairColor(persons));

        assertEquals(
                new HashMap<HairColor, List<Person>>(),
                StreamsWarmup.groupedByHairColor(emptyList()));
    }

    @Test
    @Grade(2) //OPTIONAL
    public void countChars() {
        Map<String, Long> expected = new HashMap<String, Long>() {{
            put(" ", 4L);
            put("a", 6L);
            put("c", 2L);
            put("d", 2L);
            put("f", 1L);
            put("i", 2L);
            put("n", 1L);
            put("o", 3L);
            put("s", 1L);
            put("t", 3L);
        }};
        assertEquals(
                expected,
                StreamsWarmup.countChars("a fost odata ca niciodata"));
    }

    @Test
    @Grade(3) //OPTIONAL
    public void toFlatList() {
        assertEquals(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                StreamsWarmup.toFlatList(new int[][]{{1, 2}, {3}, {4, 5, 6}, {7, 8, 9}}));
    }
}