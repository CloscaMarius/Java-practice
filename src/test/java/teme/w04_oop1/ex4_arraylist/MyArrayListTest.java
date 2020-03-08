package teme.w04_oop1.ex4_arraylist;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 14p
 */
@RunWith(GradeRunner.class)
public class MyArrayListTest {

    @Test
    @Grade(1)
    public void size_whenEmpty() {
        MyArrayList l = new MyArrayList();
        assertEquals(0, l.size());
    }

    @Test
    @Grade(1)
    public void size_appendOne() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "aa"); //append
        assertEquals(1, l.size());
        assertEquals("aa", l.get(0));
    }

    @Test
    @Grade(1)
    public void size_appendMultiple_get() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "aa"); //append
        l.insert(1, "bb"); //append
        l.insert(2, "cc"); //append

        assertEquals(3, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("bb", l.get(1));
        assertEquals("cc", l.get(2));
    }

    @Test
    @Grade(1)
    public void size_insertOtherPositions_get() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "cc"); //append
        l.insert(0, "aa"); //insert in front
        l.insert(1, "bb"); //insert in the middle

        assertEquals(3, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("bb", l.get(1));
        assertEquals("cc", l.get(2));
    }

    @Test
    @Grade(1)
    public void insert_invalidIndex() {
        MyArrayList l = new MyArrayList();
        l.insert(-1, "X"); //ignored
        l.insert(1, "X"); //ignored
        assertEquals(0, l.size());

        l.insert(0, "aa"); //append
        l.insert(1, "bb"); //append
        assertEquals(2, l.size());

        l.insert(-1, "X"); //ignored
        l.insert(3, "X"); //ignored
        assertEquals(2, l.size());
    }

    @Test
    @Grade(2)
    public void set() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "aa"); //append
        l.insert(1, "bb"); //append
        l.insert(2, "cc"); //append

        assertEquals(3, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("bb", l.get(1));
        assertEquals("cc", l.get(2));

        //update middle one
        l.set(1, "BB!");

        assertEquals(3, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("BB!", l.get(1)); //only this one is updated
        assertEquals("cc", l.get(2));

        //update all
        l.set(0, "AA!!");
        l.set(1, "BB!!");
        l.set(2, "CC!!");

        assertEquals(3, l.size());
        assertEquals("AA!!", l.get(0));
        assertEquals("BB!!", l.get(1));
        assertEquals("CC!!", l.get(2));
    }

    @Test
    @Grade(1)
    public void set_invalidIndex() {
        MyArrayList l = new MyArrayList();

        l.set(-1, "X"); //ignored
        l.set(1, "X"); //ignored
        l.set(0, "X"); //ignored
        assertEquals(0, l.size());

        l.insert(0, "aa"); //append

        l.set(-1, "X"); //ignored
        l.set(1, "X"); //ignored
        l.set(2, "X"); //ignored
        assertEquals(1, l.size());
        assertEquals("aa", l.get(0));
    }

    @Test
    @Grade(2)
    public void remove_removes() {
        MyArrayList l = new MyArrayList();
        l.remove(0);
        l.remove(-1);
        l.remove(2);

        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");

        l.remove(0);
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
        MyArrayList l = new MyArrayList();
        assertNull(l.remove(0));

        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");

        assertNull(l.remove(-1));
        assertNull(l.remove(4));
        assertEquals("aa", l.remove(0));
        assertEquals("bb", l.remove(0));
        assertEquals("dd", l.remove(1));
        assertEquals("cc", l.remove(0));
    }

    @Test
    @Grade(1)
    public void indexOf() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");

        assertEquals(0, l.indexOf("aa"));
        assertEquals(1, l.indexOf("bb"));
        assertEquals(2, l.indexOf("cc"));
        assertEquals(3, l.indexOf("dd"));
    }

    @Test
    @Grade(1)
    public void indexOf_missingValue() {
        MyArrayList l = new MyArrayList();
        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");

        assertEquals(-1, l.indexOf("ee"));
        assertEquals(-1, l.indexOf(""));
        assertEquals(-1, l.indexOf("AA"));
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