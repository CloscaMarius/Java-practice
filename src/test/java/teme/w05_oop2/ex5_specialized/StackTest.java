package teme.w05_oop2.ex5_specialized;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 7p
 */
@RunWith(GradeRunner.class)
public class StackTest {

    @Test
    @Grade(1)
    public void isEmpty() {
        Stack s = new Stack();
        assertTrue(s.isEmpty());
        s.push("aa");
        assertFalse(s.isEmpty());
    }

    @Test
    @Grade(1)
    public void pop_empty() {
        Stack s = new Stack();
        assertNull(s.pop());
    }

    @Test
    @Grade(1)
    public void push_pop_one() {
        Stack s = new Stack();
        s.push("aa");
        assertFalse(s.isEmpty());
        assertEquals("aa", s.pop());
        assertTrue(s.isEmpty());
    }

    @Test
    @Grade(1)
    public void push_pop_many() {
        Stack s = new Stack();
        s.push("aa");
        s.push("bb");
        s.push("cc");
        assertFalse(s.isEmpty());
        assertEquals("cc", s.pop());
        assertEquals("bb", s.pop());
        assertEquals("aa", s.pop());
        assertTrue(s.isEmpty());
    }

    @Test
    @Grade(1)
    public void peek_empty() {
        Stack s = new Stack();
        assertNull(s.peek());
    }

    @Test
    @Grade(1)
    public void push_peek_many() {
        Stack s = new Stack();

        s.push("aa");
        assertEquals("aa", s.peek());
        assertEquals("aa", s.peek());

        s.push("bb");
        assertEquals("bb", s.peek());
        assertEquals("bb", s.peek());

        s.push("cc");
        assertEquals("cc", s.peek());
    }

    @Test
    @Grade(1)
    public void all_combined() {
        Stack s = new Stack();
        assertTrue(s.isEmpty());

        s.push("aa");
        assertEquals("aa", s.peek());

        s.push("bb");
        assertEquals("bb", s.peek());

        s.push("cc");
        assertEquals("cc", s.peek());
        assertEquals("cc", s.peek());
        assertFalse(s.isEmpty());

        assertEquals("cc", s.peek());
        assertEquals("cc", s.peek());
        assertEquals("cc", s.pop());

        assertEquals("bb", s.peek());
        assertEquals("bb", s.peek());
        assertEquals("bb", s.pop());

        assertEquals("aa", s.peek());
        assertEquals("aa", s.pop());
        assertTrue(s.isEmpty());
    }
}