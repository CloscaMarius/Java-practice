package teme.w04_oop1.ex1_person;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 14p
 */
@RunWith(GradeRunner.class)
public class PersonTest {

    @Test
    @Grade
    public void TODO_uncomment_rest_of_tests_when_done() {
        //useless, but just to keep a few imports (needed for commented code) from being optimized
        assertEquals("", "");
        assertTrue(true);
        fail("TODO: Uncomment rest of tests when done!"); //and also comment out this line...
    }

    /*
    @Test
    @Grade(2)
    public void test_constructorWith3Params_andGetters() {
        Person p = new Person("Ion", 1989, "black");
        assertEquals("Ion", p.getName());
        assertEquals(1989, p.getBirthYear());
        assertEquals("black", p.getHairColor());
    }

    @Test
    @Grade(2)
    public void test_constructorWith2Params_andGetters() {
        Person p = new Person("Geo", 1979);
        assertEquals("Geo", p.getName());
        assertEquals(1979, p.getBirthYear());
        assertEquals("brown", p.getHairColor());
    }

    @Test
    @Grade(2)
    public void testSetters() {
        Person p1 = new Person("Ion", 1989, "black");
        assertEquals("black", p1.getHairColor());
        p1.setHairColor("blond");
        assertEquals("blond", p1.getHairColor());
    }

    @Test
    @Grade(3)
    public void testIsOlderThan() {
        Person p1 = new Person("Ion", 1989, "black");
        Person p2 = new Person("Geo", 1979, "red");
        assertFalse(p1.isOlderThan(p2));
        assertTrue(p2.isOlderThan(p1));
    }

    @Test
    @Grade(3)
    public void testGetAgeInYear() {
        Person p = new Person("Ion", 1989, "black");
        assertEquals(1, p.getAgeInYear(1990));
        assertEquals(41, p.getAgeInYear(2030));
        assertEquals(0, p.getAgeInYear(1900));
    }

    @Test
    @Grade(2)
    public void testToString() {
        Person p1 = new Person("Ion", 1989, "black");
        assertTrue(p1.toString().contains("Ion"));
        assertTrue(p1.toString().contains("1989"));
        assertTrue(p1.toString().contains("black"));
    }
    */
}
