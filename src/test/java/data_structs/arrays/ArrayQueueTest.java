package data_structs.arrays;

import data_structs.arrays.ArrayQueue;
import data_structs.queues.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    @Test
    void isEmptyTrue() {
        Queue q = new ArrayQueue();
        assertTrue( q.isEmpty() );
    }

    @Test
    void isEmptyFalse() {
        Queue q = new ArrayQueue();
        q.enqueue( 1 );
        assertFalse( q.isEmpty() );
    }

    @Test
    void isEmptyTrueAfterDequeueLastElement() {
        Queue q = new ArrayQueue();
        q.enqueue( 1 );
        q.dequeue();
        assertTrue( q.isEmpty() );
    }

    @Test
    void peekWhenEmpty() {
        Queue q = new ArrayQueue();
        assertNull( q.peek() );
    }

    @Test
    void peek() {
        Queue q = new ArrayQueue();
        q.enqueue( 1 );
        assertEquals( 1, q.peek() );
    }

    @Test
    void peekReturnsFirstElement() {
        Queue q = new ArrayQueue();
        q.enqueue( 1 );
        q.enqueue( 2 );
        q.enqueue( 3 );
        assertEquals( 1, q.peek() );
    }

    @Test
    void peekAfterDequeue() {
        Queue q = new ArrayQueue();
        q.enqueue( 1 );
        q.enqueue( 2 );
        q.dequeue();
        assertEquals( 2, q.peek() );
    }

    @Test
    void getSize() {
        Queue q = new ArrayQueue();
        assertEquals( 0, q.getSize() );
        q.enqueue( 1 );
        assertEquals( 1, q.getSize() );
    }

    @Test
    void enqueueGrowsArray() {
        // Make sure that the queue will grow

        Queue q = new ArrayQueue();
        for ( int i = 0 ; i <= 1000; ++i )
            q.enqueue( i );
        assertEquals( 1001, q.getSize() );
        assertEquals( 0, q.peek() );
    }

    @Test
    void dequeueEmpty() {
        Queue q = new ArrayQueue();
        assertNull( q.dequeue() );
    }

    @Test
    void dequeueReturnsFirstElement() {
        Queue q = new ArrayQueue();
        q.enqueue( 1 );
        q.enqueue( 2 );
        assertEquals( 1, q.dequeue() );
    }
}
