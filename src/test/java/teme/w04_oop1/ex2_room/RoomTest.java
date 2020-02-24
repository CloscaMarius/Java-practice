package teme.w04_oop1.ex2_room;

//import teme.w04_oop1.ex1_person.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.TestUtil;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

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
        assertTrue(true);
        fail("TODO: Uncomment rest of tests when done!"); //and also comment out this line...
    }

    /*
    @Test
    @Grade(1)
    public void testPrintAll_givesNoExceptions() {
        new Room(0).printAll();

        Room r = new Room(1);
        r.printAll();

        r.enter(new Person("p1", 2019, "blue"));
        r.printAll();

        r = new Room(3);
        r.printAll();
        r.enter(new Person("p1", 2019, "blue"));
        r.printAll();
        r.enter(new Person("p2", 2019, "blue"));
        r.printAll();
        r.enter(new Person("p3", 2019, "blue"));
        r.printAll();
    }

    @Test
    @Grade(1)
    public void testPrintAll_rightContent() {
        Room r = new Room(7);
        r.enter(new Person("aaa", 222, "red"));
        r.enter(new Person("bbb", 444, "green"));
        r.enter(new Person("ccc", 666, "blue"));

        String out = TestUtil.runCapturingOutput(r::printAll);
        assertTrue(out.contains("7"));
        assertTrue(out.contains("3"));
        assertTrue(out.contains("aaa") && out.contains("222") && out.contains("red"));
        assertTrue(out.contains("bbb") && out.contains("444") && out.contains("green"));
        assertTrue(out.contains("ccc") && out.contains("666") && out.contains("blue"));
    }

    @Test
    @Grade(2)
    public void testConstructorAndGetCapacity() {
        assertEquals(0, new Room(0).getCapacity());
        assertEquals(1, new Room(1).getCapacity());
        assertEquals(3, new Room(3).getCapacity());
        assertEquals(100, new Room(100).getCapacity());
    }

    @Test
    @Grade(1)
    public void testGetCount_emptyRoom() {
        assertEquals(0, new Room(0).getCount());
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
        assertFalse(new Room(0).isPresent("DarthVader"));
        assertFalse(new Room(0).isPresent(""));
        assertFalse(new Room(2).isPresent("DarthVader"));
        assertFalse(new Room(2).isPresent(""));
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
        assertEquals("", new Room(0).getOldest());
        assertEquals("", new Room(3).getOldest());
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
        assertArrayEquals(new String[]{}, new Room(0).getNames("red"));
        assertArrayEquals(new String[]{}, new Room(0).getNames(""));
        assertArrayEquals(new String[]{}, new Room(1).getNames("red"));
        assertArrayEquals(new String[]{}, new Room(1).getNames(""));
        assertArrayEquals(new String[]{}, new Room(3).getNames("red"));
        assertArrayEquals(new String[]{}, new Room(3).getNames(""));
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

        r.exit(new String("Ion"));
        assertFalse(r.isPresent(new String("Ion")));
        assertEquals(0, r.getCount());
    }
    */
}
