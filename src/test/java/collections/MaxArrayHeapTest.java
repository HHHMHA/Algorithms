package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// TODO: don't allow repeated values
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

    @Test
    void testHeapIncreaseKey() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );
        heap.add( 1 );
        heap.add( 4 );
        heap.add( 2 );
        heap.add( 10 );
        heap.add( 3 );

        heap.increaseKey( 10, 20 );
        assertEquals( 20, heap.top() );
        assertEquals( 5, heap.size() );

        // heap not modified
        assertEquals( 20, heap.extractTop() );
        assertEquals( 4, heap.extractTop() );
        assertEquals( 3, heap.extractTop() );
        assertEquals( 2, heap.extractTop() );
        assertEquals( 1, heap.extractTop() );
    }

    @Test
    void testHeapIncreaseKeyEmpty() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );

        heap.increaseKey( 10, 20 );
        assertNull( heap.top() );
        assertEquals( 0, heap.size() );
    }

    @Test
    void testHeapIncreaseKeyLessValue() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );
        heap.add( 1 );
        heap.add( 4 );
        heap.add( 2 );
        heap.add( 10 );
        heap.add( 3 );

        heap.increaseKey( 10, 2 );
        assertEquals( 10, heap.top() );
        assertEquals( 5, heap.size() );
    }

    @Test
    void testHeapIncreaseKeyBreakProperty() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );
        heap.add( 1 );
        heap.add( 4 );
        heap.add( 2 );
        heap.add( 10 );
        heap.add( 3 );

        heap.increaseKey( 3, 20 );
        assertEquals( 20, heap.top() );
        assertEquals( 5, heap.size() );

        assertEquals( 20, heap.extractTop() );
        assertEquals( 10, heap.extractTop() );
        assertEquals( 4, heap.extractTop() );
        assertEquals( 2, heap.extractTop() );
        assertEquals( 1, heap.extractTop() );
    }

    @Test
    void testHeapIncreaseKeyOneElement() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );
        heap.add( 10 );

        heap.increaseKey( 10, 20 );
        assertEquals( 20, heap.top() );
        assertEquals( 1, heap.size() );
    }

    // TODO: test protected methods
}
