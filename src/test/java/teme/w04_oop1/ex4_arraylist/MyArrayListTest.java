package teme.w04_oop1.ex4_arraylist;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 12p
 */
@RunWith(GradeRunner.class)
public class MyArrayListTest {

    @Test
    @Grade(2)
    public void size_add() {
        MyArrayList l = new MyArrayList();
        assertEquals(0, l.size());

        l.add("aa");
        l.add("bb");
        l.add("aa");
        assertEquals(3, l.size());
    }

    @Test
    @Grade(2)
    public void add_get() {
        MyArrayList l = new MyArrayList();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        l.add("dd");
        assertEquals("aa", l.get(0));
        assertEquals("bb", l.get(1));
        assertEquals("cc", l.get(2));
        assertEquals("dd", l.get(3));
    }

    @Test
    @Grade(1)
    public void set() {
        MyArrayList l = new MyArrayList();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        l.add("dd");
        assertEquals("bb", l.get(1));
        l.set(1, "BB!");
        assertEquals("BB!", l.get(1));
    }

    @Test
    @Grade(1)
    public void addAtIndex() {
        MyArrayList l = new MyArrayList();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        l.add("dd");
        l.add(1, "ab");
        assertEquals(5, l.size());
        assertEquals("ab", l.get(1));
        assertEquals("bb", l.get(2));
    }

    @Test
    @Grade(2)
    public void remove() {
        MyArrayList l = new MyArrayList();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        l.add("dd");

        l.remove();
        assertEquals(3, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("bb", l.get(1));
        assertEquals("cc", l.get(2));

        l.remove(0);
        assertEquals(2, l.size());
        assertEquals("bb", l.get(0));
        assertEquals("cc", l.get(1));
    }

    @Test
    @Grade(2)
    public void indexOf() {
        MyArrayList l = new MyArrayList();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        l.add("dd");
        assertEquals(1, l.indexOf("bb"));
        assertEquals(-1, l.indexOf("ee"));
    }

    @Test
    @Grade(1)
    public void contains() {
        MyArrayList l = new MyArrayList();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        l.add("dd");
        assertTrue(l.contains("bb"));
        assertFalse(l.contains("ee"));
    }

    @Test
    @Grade(1)
    public void testToString() {
        MyArrayList l = new MyArrayList();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        assertTrue(l.toString().contains("aa"));
        assertTrue(l.toString().contains("bb"));
        assertTrue(l.toString().contains("cc"));
    }
}
