package collections;

import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class MaxArrayHeapTest {
    @Test
    void testTopWhenEmpty() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );
        assertEquals( 0, heap.size() );
        assertTrue( heap.empty() );
        assertNull( heap.top() );
    }

    @Test
    void testAdd() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );
        heap.add( 1 );
        heap.add( 4 );
        heap.add( 2 );
        assertEquals( 3, heap.size() );
        assertEquals( 4, heap.top() );
        assertFalse( heap.empty() );

        heap.add( 10 );
        heap.add( 3 );
        assertEquals( 5, heap.size() );
        assertEquals( 10, heap.top() );
    }

    @Test
    void testExtractTopWhenEmpty() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );
        assertNull( heap.extractTop() );
    }

    @Test
    void testExtractTop() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );
        heap.add( 1 );
        heap.add( 4 );
        heap.add( 2 );
        heap.add( 10 );
        heap.add( 3 );
        assertEquals( 10, heap.extractTop() );
        assertEquals( 4, heap.top() );
        assertEquals( 4, heap.size() );
    }

    @Test
    void testExtractTopWhenOneElement() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );
        heap.add( 1 );
        assertEquals( 1, heap.extractTop() );
        assertEquals( 0, heap.size() );
        assertTrue( heap.empty() );
        assertNull( heap.extractTop() );
    }

    // TODO: test protected methods
}
