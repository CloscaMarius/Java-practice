package teme.w05_oop2.ex5_specialized;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;
import teme.w05_oop2.ex4_list.MyList;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 10p
 */
@RunWith(GradeRunner.class)
public class DoubleLinkedListTest {

    @Test
    @Grade
    public void TODO_uncomment_rest_of_tests_when_done() {
        //useless, but just to keep a few imports (needed for commented code) from being optimized
        assertEquals(MyList.class, MyList.class);
        assertTrue(true);
        fail("TODO: Uncomment rest of tests when done!"); //and also comment out this line...
    }

    /*
    @Test
    @Grade(1)
    public void size_whenEmpty() {
        MyList l = new DoubleLinkedList();
        assertEquals(0, l.size());
    }

    @Test
    @Grade(1)
    public void size_appendMultiple_get() {
        MyList l = new DoubleLinkedList();
        assertEquals(0, l.size());

        l.insert(0, "aa"); //append
        assertEquals(1, l.size());
        assertEquals("aa", l.get(0));

        l.insert(1, "bb"); //append
        assertEquals(2, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("bb", l.get(1));

        l.insert(2, "cc"); //append
        assertEquals(3, l.size());
        assertEquals("aa", l.get(0));
        assertEquals("bb", l.get(1));
        assertEquals("cc", l.get(2));
    }

    @Test
    @Grade(1)
    public void size_insertOtherPositions_get() {
        MyList l = new DoubleLinkedList();
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
        MyList l = new DoubleLinkedList();
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
    @Grade(1)
    public void set() {
        MyList l = new DoubleLinkedList();
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
    public void set_get_invalidIndex() {
        MyList l = new DoubleLinkedList();

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

        //---get---
        assertNull(l.get(-1));
        assertNotNull(l.get(0));
        assertNull(l.get(1));
        assertNull(l.get(2));
    }

    @Test
    @Grade(1)
    public void remove_removes() {
        MyList l = new DoubleLinkedList();
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
        MyList l = new DoubleLinkedList();
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
        MyList l = new DoubleLinkedList();
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
        MyList l = new DoubleLinkedList();
        l.insert(0, "aa");
        l.insert(1, "bb");
        l.insert(2, "cc");
        l.insert(3, "dd");

        assertEquals(-1, l.indexOf("ee"));
        assertEquals(-1, l.indexOf(""));
        assertEquals(-1, l.indexOf("AA"));
    }
    */
}