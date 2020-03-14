package teme.w05_oop2.ex5_specialized;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 8p
 */
@RunWith(GradeRunner.class)
public class QueueTest {

    @Test
    @Grade(1)
    public void isEmpty() {
        Queue q = new Queue();
        assertTrue(q.isEmpty());
        q.enqueue("aa");
        assertFalse(q.isEmpty());
    }

    @Test
    @Grade(1)
    public void dequeue_empty() {
        Queue q = new Queue();
        assertNull(q.dequeue());
        assertNull(q.dequeue());
    }

    @Test
    @Grade(1)
    public void getFront_empty() {
        Queue q = new Queue();
        assertNull(q.getFront());
        assertNull(q.getFront());
    }

    @Test
    @Grade(1)
    public void enqueue_dequeue_one() {
        Queue q = new Queue();
        q.enqueue("aa");
        assertEquals("aa", q.dequeue());
    }

    @Test
    @Grade(1)
    public void enqueue_dequeue_many() {
        Queue q = new Queue();
        q.enqueue("aa");
        q.enqueue("bb");
        q.enqueue("cc");

        assertEquals("aa", q.dequeue());
        assertEquals("bb", q.dequeue());

        q.enqueue("dd");
        q.enqueue("cc"); //duplicates allowed
        assertEquals("cc", q.dequeue());
        assertEquals("dd", q.dequeue());
        assertEquals("cc", q.dequeue());
    }

    @Test
    @Grade(1)
    public void enqueue_getFront_many() {
        Queue q = new Queue();

        q.enqueue("aa");
        assertEquals("aa", q.getFront());
        assertEquals("aa", q.getFront());

        q.enqueue("bb");
        assertEquals("aa", q.getFront());
        assertEquals("aa", q.getFront());

        q.enqueue("cc");
        assertEquals("aa", q.getFront());

        q.enqueue("bb"); //duplicates allowed
        assertEquals("aa", q.getFront());
    }

    @Test
    @Grade(2)
    public void all_combined() {
        Queue q = new Queue();
        assertTrue(q.isEmpty());

        q.enqueue("aa");
        assertFalse(q.isEmpty());
        assertEquals("aa", q.getFront());
        assertEquals("aa", q.getFront());

        q.enqueue("bb");
        assertEquals("aa", q.getFront());
        assertEquals("aa", q.dequeue());

        assertEquals("bb", q.getFront());

        q.enqueue("cc");
        assertEquals("bb", q.getFront());
        q.enqueue("dd");
        assertEquals("bb", q.getFront());

        assertEquals("bb", q.dequeue());
        assertEquals("cc", q.getFront());
        assertEquals("cc", q.dequeue());
        assertEquals("dd", q.getFront());
        assertEquals("dd", q.dequeue());

        assertNull(q.getFront());
        assertNull(q.dequeue());
        assertTrue(q.isEmpty());
    }
}