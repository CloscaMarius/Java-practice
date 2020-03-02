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
    public void size_empty_add() {
        MyArrayList l = new MyArrayList();
        assertEquals(0, l.size());

        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "aa");
        assertEquals(3, l.size());
    }

    @Test
    @Grade(2)
    public void add_get() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");

        assertEquals("aa", l.get(0));
        assertEquals("bb", l.get(1));
        assertEquals("cc", l.get(2));
        assertEquals("dd", l.get(3));

        assertNull(l.get(-1));
        assertNull(l.get(4));
    }

    @Test
    @Grade(1)
    public void set() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");
        assertEquals("bb", l.get(1));
        l.set(1, "BB!");
        assertEquals("BB!", l.get(1));
    }

    @Test
    @Grade(1)
    public void insert() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");
        l.insert(1, "ab");
        assertEquals(5, l.size());
        assertEquals("ab", l.get(1));
        assertEquals("bb", l.get(2));
    }

    @Test
    @Grade(1)
    public void remove_removes() {
        MyArrayList l = new MyArrayList();
        l.remove(0);
        l.remove(-1);
        l.remove(2);

        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");

        l.remove(3);
        assertEquals(3, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("bb", l.get(1));
        assertEquals("cc", l.get(2));

        l.remove(0);
        assertEquals(2, l.size());
        assertEquals("bb", l.get(0));
        assertEquals("cc", l.get(1));

        l.remove(-1);
        l.remove(2);
        assertEquals(2, l.size());
    }

    @Test
    @Grade(1)
    public void remove_returnsRemovedValue() {
        MyArrayList l = new MyArrayList();
        assertNull(l.remove(0));

        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");

        assertEquals("dd", l.remove(3));
        assertEquals("aa", l.remove(0));
        assertNull(l.remove(3));
        assertNull(l.remove(2));
        assertNull(l.remove(-1));
    }

    @Test
    @Grade(2)
    public void indexOf() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");
        assertEquals(1, l.indexOf("bb"));
        assertEquals(-1, l.indexOf("ee"));
    }

    @Test
    @Grade(1)
    public void testToString() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        assertTrue(l.toString().contains("aa"));
        assertTrue(l.toString().contains("bb"));
        assertTrue(l.toString().contains("cc"));
    }
}
