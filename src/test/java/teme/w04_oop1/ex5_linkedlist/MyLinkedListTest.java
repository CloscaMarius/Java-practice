package teme.w04_oop1.ex5_linkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 12p
 */
@RunWith(GradeRunner.class)
public class MyLinkedListTest {

    @Test
    @Grade(2)
    public void size_empty_add() {
        MyLinkedList l = new MyLinkedList();
        assertEquals(0, l.size());
        assertTrue(l.isEmpty());

        l.addBefore("aa");
        l.addBefore("bb");
        l.addBefore("aa");
        assertEquals(3, l.size());
        assertFalse(l.isEmpty());
    }

    @Test
    @Grade(2)
    public void add_get() {
        MyLinkedList l = new MyLinkedList();
        l.addBefore("dd");
        l.addBefore("cc");
        l.addBefore("bb");
        l.addBefore("aa");

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
        MyLinkedList l = new MyLinkedList();
        l.addBefore("dd");
        l.addBefore("cc");
        l.addBefore("bb");
        l.addBefore("aa");

        assertEquals("bb", l.get(1));
        l.set(1, "BB!");
        assertEquals("BB!", l.get(1));
    }

    @Test
    @Grade(1)
    public void insert() {
        MyLinkedList l = new MyLinkedList();
        l.insert(0, "bb");
        l.insert(0, "aa");

        assertEquals(2, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("bb", l.get(1));

        l.insert(1, "ab");
        assertEquals(3, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("ab", l.get(1));
        assertEquals("bb", l.get(2));

        l.insert(3, "cc");
        assertEquals(4, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("ab", l.get(1));
        assertEquals("bb", l.get(2));
        assertEquals("cc", l.get(3));

        l.insert(10, "dd");
        assertEquals(4, l.size());
    }

    @Test
    @Grade(1)
    public void remove_removes() {
        MyLinkedList l = new MyLinkedList();
        l.removeFirst();
        l.remove(-1);
        l.remove(2);

        l.addBefore("dd");
        l.addBefore("cc");
        l.addBefore("bb");
        l.addBefore("aa");

        l.removeFirst();
        assertEquals(3, l.size());
        assertEquals("bb", l.get(0));
        assertEquals("cc", l.get(1));
        assertEquals("dd", l.get(2));

        l.remove(0);
        assertEquals(2, l.size());
        assertEquals("cc", l.get(0));
        assertEquals("dd", l.get(1));

        l.remove(-1);
        l.remove(2);
        assertEquals(2, l.size());
    }

    @Test
    @Grade(1)
    public void remove_returnsRemovedValue() {
        MyLinkedList l = new MyLinkedList();
        assertNull(l.removeFirst());
        assertNull(l.remove(0));

        l.addBefore("dd");
        l.addBefore("cc");
        l.addBefore("bb");
        l.addBefore("aa");

        assertNull(l.remove(-1));
        assertNull(l.remove(4));
        assertEquals("aa", l.removeFirst());
        assertEquals("bb", l.remove(0));
        assertEquals("dd", l.remove(1));
        assertEquals("cc", l.remove(0));
    }

    @Test
    @Grade(2)
    public void indexOf() {
        MyLinkedList l = new MyLinkedList();
        l.addBefore("dd");
        l.addBefore("cc");
        l.addBefore("bb");
        l.addBefore("aa");

        assertEquals(1, l.indexOf("bb"));
        assertEquals(-1, l.indexOf("ee"));
    }

    @Test
    @Grade(1)
    public void contains() {
        MyLinkedList l = new MyLinkedList();
        l.addBefore("dd");
        l.addBefore("cc");
        l.addBefore("bb");
        l.addBefore("aa");

        assertTrue(l.contains("bb"));
        assertFalse(l.contains("ee"));
    }

    @Test
    @Grade(1)
    public void testToString() {
        MyLinkedList l = new MyLinkedList();
        l.addBefore("cc");
        l.addBefore("bb");
        l.addBefore("aa");

        assertTrue(l.toString().contains("aa"));
        assertTrue(l.toString().contains("bb"));
        assertTrue(l.toString().contains("cc"));
    }
}