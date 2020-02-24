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
        assertTrue(l.isEmpty());

        l.addLast("aa");
        l.addLast("bb");
        l.addLast("aa");
        assertEquals(3, l.size());
        assertFalse(l.isEmpty());
    }

    @Test
    @Grade(2)
    public void add_get() {
        MyArrayList l = new MyArrayList();
        l.addLast("aa");
        l.addLast("bb");
        l.addLast("cc");
        l.addLast("dd");

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
        l.addLast("aa");
        l.addLast("bb");
        l.addLast("cc");
        l.addLast("dd");
        assertEquals("bb", l.get(1));
        l.set(1, "BB!");
        assertEquals("BB!", l.get(1));
    }

    @Test
    @Grade(1)
    public void insert() {
        MyArrayList l = new MyArrayList();
        l.addLast("aa");
        l.addLast("bb");
        l.addLast("cc");
        l.addLast("dd");
        l.insert(1, "ab");
        assertEquals(5, l.size());
        assertEquals("ab", l.get(1));
        assertEquals("bb", l.get(2));
    }

    @Test
    @Grade(1)
    public void remove_removes() {
        MyArrayList l = new MyArrayList();
        l.removeLast();
        l.remove(-1);
        l.remove(2);

        l.addLast("aa");
        l.addLast("bb");
        l.addLast("cc");
        l.addLast("dd");

        l.removeLast();
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
        assertNull(l.removeLast());
        assertNull(l.remove(0));

        l.addLast("aa");
        l.addLast("bb");
        l.addLast("cc");
        l.addLast("dd");

        assertEquals("dd", l.removeLast());
        assertEquals("aa", l.remove(0));
        assertNull(l.remove(-1));
        assertNull(l.remove(2));
    }

    @Test
    @Grade(2)
    public void indexOf() {
        MyArrayList l = new MyArrayList();
        l.addLast("aa");
        l.addLast("bb");
        l.addLast("cc");
        l.addLast("dd");
        assertEquals(1, l.indexOf("bb"));
        assertEquals(-1, l.indexOf("ee"));
    }

    @Test
    @Grade(1)
    public void contains() {
        MyArrayList l = new MyArrayList();
        l.addLast("aa");
        l.addLast("bb");
        l.addLast("cc");
        l.addLast("dd");
        assertTrue(l.contains("bb"));
        assertFalse(l.contains("ee"));
    }

    @Test
    @Grade(1)
    public void testToString() {
        MyArrayList l = new MyArrayList();
        l.addLast("aa");
        l.addLast("bb");
        l.addLast("cc");
        assertTrue(l.toString().contains("aa"));
        assertTrue(l.toString().contains("bb"));
        assertTrue(l.toString().contains("cc"));
    }
}
