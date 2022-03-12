package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListQueueTest {

    @Test
    void isEmptyTrue() {
        Queue q = new ListQueue();
        assertTrue( q.isEmpty() );
    }

    @Test
    void isEmptyFalse() {
        Queue q = new ListQueue();
        q.enqueue( 1 );
        assertFalse( q.isEmpty() );
    }

    @Test
    void isEmptyTrueAfterDequeueLastElement() {
        Queue q = new ListQueue();
        q.enqueue( 1 );
        q.dequeue();
        assertTrue( q.isEmpty() );
    }

    @Test
    void peekWhenEmpty() {
        Queue q = new ListQueue();
        assertNull( q.peek() );
    }

    @Test
    void peek() {
        Queue q = new ListQueue();
        q.enqueue( 1 );
        assertEquals( 1, q.peek() );
    }

    @Test
    void peekReturnsFirstElement() {
        Queue q = new ListQueue();
        q.enqueue( 1 );
        q.enqueue( 2 );
        q.enqueue( 3 );
        assertEquals( 1, q.peek() );
    }

    @Test
    void peekAfterDequeue() {
        Queue q = new ListQueue();
        q.enqueue( 1 );
        q.enqueue( 2 );
        q.dequeue();
        assertEquals( 2, q.peek() );
    }

    @Test
    void getSize() {
        Queue q = new ListQueue();
        assertEquals( 0, q.getSize() );
        q.enqueue( 1 );
        assertEquals( 1, q.getSize() );
    }

    @Test
    void dequeueEmpty() {
        Queue q = new ListQueue();
        assertNull( q.dequeue() );
    }

    @Test
    void dequeueReturnsFirstElement() {
        Queue q = new ListQueue();
        q.enqueue( 1 );
        q.enqueue( 2 );
        assertEquals( 1, q.dequeue() );
    }
}
