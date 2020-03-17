package teme.w05_oop2.ex4_list;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/**
 * MAX GRADE: +15p (optional)
 */
@RunWith(GradeRunner.class)
public class MyListTest {

    @Test
    @Grade
    public void TODO_uncomment_rest_of_tests_when_done() {
        //useless, but just to keep a few imports (needed for commented code) from being optimized
        assertEquals(MyArrayList.class, MyArrayList.class);
        assertTrue(true);
        //fail("TODO: Uncomment rest of tests when done!"); //and also comment out this line...
    }

    private MyList newList() {
        return (MyList) new MyArrayList();
        //return (MyList) new MyLinkedList(); //may try also with this one, if implemented
    }

    @Test
    @Grade(4)
    public void oldMethodsWork() {
        MyList list = newList();

        assertEquals(0, list.size());

        list.insert(0, "aa");
        list.insert(1, "bb");
        list.insert(2, "cc");
        assertEquals(3, list.size());

        assertEquals("aa", list.get(0));
        assertEquals("cc", list.get(2));

        list.set(1, "BB!");
        assertEquals("BB!", list.get(1));

        assertEquals(0, list.indexOf("aa"));
        assertEquals(2, list.indexOf("cc"));

        assertEquals("cc", list.remove(2));
        assertEquals(2, list.size());
    }

    @Test
    @Grade(1)
    public void newMethod_isEmpty() {
        MyList list = newList();
        assertTrue(list.isEmpty());

        list.add("aa");
        assertFalse(list.isEmpty());
    }

    @Test
    @Grade(2)
    public void newMethod_contains_add() {
        MyList list = newList();
        assertFalse(list.contains(""));
        assertFalse(list.contains("aa"));

        list.add("aa");
        assertTrue(list.contains("aa"));
        assertFalse(list.contains("AA"));
    }

    @Test
    @Grade(2)
    public void newMethod_add() {
        MyList list = newList();
        assertEquals(0, list.size());

        list.add("aa");
        list.add("bb");
        list.add("aa");

        assertEquals(3, list.size());
        assertEquals("aa", list.get(0));
        assertEquals("bb", list.get(1));
        assertEquals("aa", list.get(2));
    }

    @Test
    @Grade(2)
    public void newMethod_addFirst() {
        MyList list = newList();
        list.addFirst("cc");
        list.addFirst("bb");
        list.addFirst("aa");

        assertEquals(3, list.size());
        assertEquals("aa", list.get(0));
        assertEquals("bb", list.get(1));
        assertEquals("cc", list.get(2));
    }

    @Test
    @Grade(2)
    public void newMethod_remove() {
        MyList list = newList();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        assertEquals(3, list.size());

        assertEquals("cc", list.remove());
        assertEquals(2, list.size());
        assertEquals("aa", list.get(0));
        assertEquals("bb", list.get(1));

        assertEquals("bb", list.remove());
        assertEquals("aa", list.remove());
        assertEquals(0, list.size());

        assertNull(list.remove());
        assertEquals(0, list.size());
    }

    @Test
    @Grade(2)
    public void newMethod_removeFirst() {
        MyList list = newList();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        assertEquals(3, list.size());

        assertEquals("aa", list.removeFirst());
        assertEquals(2, list.size());
        assertEquals("bb", list.get(0));
        assertEquals("cc", list.get(1));

        assertEquals("bb", list.removeFirst());
        assertEquals("cc", list.removeFirst());
        assertEquals(0, list.size());

        assertNull(list.removeFirst());
        assertEquals(0, list.size());
    }
}