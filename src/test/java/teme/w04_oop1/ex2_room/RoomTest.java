package teme.w04_oop1.ex2_room;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.TestUtil;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;
import teme.w04_oop1.ex1_person.Person;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 22p+2p
 */
@RunWith(GradeRunner.class)
public class RoomTest {

    @Test
    @Grade
    public void TODO_uncomment_rest_of_tests_when_done() {
        //useless, but just to keep a few imports (needed for commented code) from being optimized
        assertEquals("", TestUtil.runCapturingOutput(() -> {
        }));
        assertTrue(Arrays.toString(new int[]{}).length() > 0);
        //fail("TODO: Uncomment rest of tests when done!"); //and also comment out this line...
    }

    @Test
    @Grade(1)
    public void testPrintAll_givesNoExceptions() {
        for (int capacity = 0; capacity <= 10; capacity++) {
            Room r = new Room(capacity);
            for (int i = 0; i < capacity; i++) {
                Person p = new Person("name" + i, 2000 + i);
                r.enter(p);
                r.printAll(); //no exceptions here
            }
        }
    }

    @Test
    @Grade(1)
    public void testPrintAll_rightContent() {
        for (int capacity = 0; capacity <= 10; capacity++) {
            Room r = new Room(capacity);
            for (int i = 0; i < capacity; i++) {
                Person p = new Person("name" + i, 2000 + i, "color" + i);
                r.enter(p);
                if (i > 0) { //skip testing for empty room (undefined requirements)
                    String out = TestUtil.runCapturingOutput(r::printAll);
                    assertTrue(out.contains(String.valueOf(capacity)));
                    assertTrue(out.contains(String.valueOf(i)));
                    for (int j = 0; j <= i; j++) {
                        for (String term : Arrays.asList("name" + j, String.valueOf(2000 + j), "color" + j)) {
                            assertTrue("output of room .printAll() expected to contain '" + term + "', but didn't, output was: '" + out + "'",
                                    out.contains(term));
                        }
                    }
                }
            }
        }
    }

    @Test
    @Grade(1)
    public void testConstructorAndGetCapacity() {
        for (int c = 0; c < 100; c = c * 2 + 1) {
            assertEquals(c, new Room(c).getCapacity());
        }
    }

    @Test
    @Grade(1)
    public void testGetCount_emptyRoom() {
        for (int c = 0; c < 100; c = c * 2 + 1) {
            assertEquals(0, new Room(c).getCount());
        }
    }

    @Test
    @Grade(2)
    public void testEnterAndGetCount_lessThanCapacity() {
        Room r = new Room(3);
        assertEquals(0, r.getCount());

        //add 1 person
        r.enter(new Person("Ion", 1997, "blond"));
        assertEquals(1, r.getCount());

        //add 2 more (should be accepted)
        r.enter(new Person("Maria", 2001, "blond"));
        r.enter(new Person("Ana", 1995, "black"));
        assertEquals(3, r.getCount());
    }

    @Test
    @Grade(1)
    public void testEnterAndGetCount_rejectIfCapacityReached() {

        Room r = new Room(0);
        assertEquals(0, r.getCount());
        r.enter(new Person("Ion", 1997, "blond"));
        assertEquals(0, r.getCount());

        r = new Room(2);
        //add 2 persons
        r.enter(new Person("Ion", 1997, "blond"));
        r.enter(new Person("Ana", 1995, "black"));
        assertEquals(2, r.getCount());
        //try to add one more - rejected, no room for him
        r.enter(new Person("Marius", 1995, "black"));
        assertEquals(2, r.getCount());
    }

    @Test
    @Grade(2)
    public void optional_testEnterAndGetCount_rejectIfHasSameName() {
        Room r = new Room(5);
        assertEquals(0, r.getCount());

        //add persons one by one (and also with duplicate name)
        r.enter(new Person("Maria", 2001, "black"));
        assertEquals(1, r.getCount());
        r.enter(new Person("Maria", 2001, "red"));
        assertEquals(1, r.getCount());

        r.enter(new Person("Ion", 1997, "black"));
        assertEquals(2, r.getCount());
        r.enter(new Person("Maria", 2001, "red"));
        assertEquals(2, r.getCount());
        r.enter(new Person("Ion", 1997, "red"));
        assertEquals(2, r.getCount());

        r.enter(new Person("Ana", 1995, "black"));
        assertEquals(3, r.getCount());
        r.enter(new Person("Maria", 1995, "red"));
        assertEquals(3, r.getCount());
        r.enter(new Person("Ion", 1995, "red"));
        assertEquals(3, r.getCount());
        r.enter(new Person("Ana", 1995, "red"));
        assertEquals(3, r.getCount());
    }

    @Test
    @Grade(1)
    public void testIsPresent_emptyRoom() {
        for (int c = 0; c <= 100; c = c * 4 + 1) {
            assertFalse(new Room(c).isPresent("DarthVader"));
            assertFalse(new Room(c).isPresent(""));
        }
    }

    @Test
    @Grade(2)
    public void testIsPresent_somePersonsInRoom() {
        Room r = new Room(3);
        assertFalse(r.isPresent("Ion"));

        r.enter(new Person("Ion", 2000));
        assertTrue(r.isPresent("Ion"));
        assertFalse(r.isPresent("ION"));
        assertFalse(r.isPresent("Vasile"));

        r.enter(new Person("Vasile", 2005));
        assertTrue(r.isPresent("Ion"));
        assertTrue(r.isPresent("Vasile"));
        assertFalse(r.isPresent("Maria"));

        r.enter(new Person("Maria", 2005));
        assertTrue(r.isPresent("Ion"));
        assertTrue(r.isPresent("Vasile"));
        assertTrue(r.isPresent("Maria"));
        assertFalse(r.isPresent("DarthVader"));
    }

    @Test
    @Grade(1)
    public void testGetOldest_emptyRoom() {
        for (int c = 0; c <= 100; c = c * 3 + 1) {
            assertEquals("for empty room of capacity " + c + " getOldest() should work and return empty string", "", new Room(c).getOldest());
        }
    }

    @Test
    @Grade(2)
    public void testGetOldest() {
        Room r = new Room(5);
        r.enter(new Person("Maria", 2001));
        assertEquals("Maria(2001)", r.getOldest());

        r.enter(new Person("Vasile", 1995));
        assertEquals("Vasile(1995)", r.getOldest());

        r.enter(new Person("Mihaita", 1996));
        assertEquals("Vasile(1995)", r.getOldest());

        r.enter(new Person("Iulia", 1995));
        assertTrue("Vasile(1995)".equals(r.getOldest()) || "Iulia(1995)".equals(r.getOldest()));

        r.enter(new Person("Mircea", 1993));
        assertEquals("Mircea(1993)", r.getOldest());
    }

    @Test
    @Grade(1)
    public void testGetNames_emptyRoom() {
        for (int c = 0; c <= 100; c = c * 2 + 1) {
            assertArrayEquals(new String[]{}, new Room(c).getNames("red"));
            assertArrayEquals(new String[]{}, new Room(c).getNames(""));
        }
    }

    @Test
    @Grade(2)
    public void testGetNames() {
        Room r = new Room(5);
        r.enter(new Person("Maria", 2000, "red"));
        assertArrayEquals(new String[]{"Maria"}, r.getNames("red"));
        assertArrayEquals(new String[]{}, r.getNames("black"));

        r.enter(new Person("Ion", 2000, "blond"));
        r.enter(new Person("Ana", 2000, "red"));
        assertArrayEquals(new String[]{"Ion"}, r.getNames("blond"));
        assertArrayEquals(new String[]{"Maria", "Ana"}, r.getNames("red"));

        r.enter(new Person("Dan", 2000, "black"));
        assertArrayEquals(new String[]{"Dan"}, r.getNames("black"));

        r.enter(new Person("Ioana", 2000, "blond"));
        assertArrayEquals(new String[]{"Dan"}, r.getNames("black"));
    }

    @Test
    @Grade(1)
    public void testGetNames_afterChangingHairColor() {
        Room r = new Room(1);

        Person p = new Person("Ioana", 2000, "blond");
        r.enter(p);
        assertArrayEquals(new String[]{"Ioana"}, r.getNames("blond"));
        assertArrayEquals(new String[]{}, r.getNames("blue"));

        //change hair color for a person currently in room! (using old reference we kept for it p variable)
        p.setHairColor("blue");
        assertArrayEquals(new String[]{}, r.getNames("blond"));
        assertArrayEquals(new String[]{"Ioana"}, r.getNames("blue"));
    }

    @Test
    @Grade(1)
    public void testGetNames_getOldest_shouldNotChangePersonsPresentInRoom() {
        Room r = new Room(5);
        assertEquals(0, r.getCount());

        //add persons
        r.enter(new Person("Maria", 2001));
        r.enter(new Person("Vasile", 1995));
        r.enter(new Person("Mihaita", 1996));
        r.enter(new Person("Iulia", 1995));
        r.enter(new Person("Mircea", 1993));

        //check
        assertEquals(5, r.getCount());
        assertTrue(r.isPresent("Maria"));
        assertTrue(r.isPresent("Vasile"));
        assertTrue(r.isPresent("Mihaita"));
        assertTrue(r.isPresent("Iulia"));
        assertTrue(r.isPresent("Mircea"));
        assertFalse(r.isPresent("Ion"));

        //call the 2 methods
        r.getNames("brown");
        r.getNames("??");
        r.getOldest();

        //check again, presence should be unchanged (but order is allowed to change..)
        assertEquals(5, r.getCount());
        assertTrue(r.isPresent("Maria"));
        assertTrue(r.isPresent("Vasile"));
        assertTrue(r.isPresent("Mihaita"));
        assertTrue(r.isPresent("Iulia"));
        assertTrue(r.isPresent("Mircea"));
        assertFalse(r.isPresent("Ion"));
    }

    @Test
    @Grade(1)
    public void testExit_emptyRoom() {
        Room r = new Room(3);
        r.exit("");
        r.exit("Ion");
        assertEquals(0, r.getCount());

        r = new Room(0);
        r.exit("");
        r.exit("Ion");
        assertEquals(0, r.getCount());
    }

    @Test
    @Grade(2)
    public void testExit() {
        Room r = new Room(5);
        r.enter(new Person("Ion", 1997, "blond"));
        r.enter(new Person("Maria", 2001, "blond"));
        r.enter(new Person("Ana", 1995, "black"));
        assertEquals(3, r.getCount());
        assertTrue(r.isPresent("Ion"));
        assertTrue(r.isPresent("Maria"));
        assertTrue(r.isPresent("Ana"));

        //test exit - for unknown name, should have no effect
        r.exit("???");
        r.exit("");
        assertEquals(3, r.getCount());

        //exit an existing person
        r.exit("Ion");
        assertEquals(2, r.getCount());
        assertFalse(r.isPresent("Ion"));
        assertTrue(r.isPresent("Maria"));
        assertTrue(r.isPresent("Ana"));

        //try exit same person again (should be ignored)
        r.exit("Ion");
        assertEquals(2, r.getCount());
        assertFalse(r.isPresent("Ion"));
        assertTrue(r.isPresent("Maria"));
        assertTrue(r.isPresent("Ana"));

        //exit the rest of persons
        r.exit("Maria");
        r.exit("Ana");
        assertEquals(0, r.getCount());
        assertFalse(r.isPresent("Ion"));
        assertFalse(r.isPresent("Maria"));
        assertFalse(r.isPresent("Ana"));
    }

    @SuppressWarnings("StringOperationCanBeSimplified")
    @Test
    @Grade(1)
    public void testShouldUseEqualsForStrings() {
        Room r = new Room(5);

        r.enter(new Person("Ion", 1997, "blond"));
        assertEquals(1, r.getCount());

        //noinspection StringOperationCanBeSimplified
        assertTrue(r.isPresent(new String("Ion")));
        assertArrayEquals(new String[]{"Ion"}, r.getNames(new String("blond")));
    }
}
