package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxArrayHeapTest {
    @Test
    void testAdd() {
        Heap heap = new ArrayHeap( Heap.Property.MAX );
        heap.add( 1 );
        heap.add( 4 );
        heap.add( 2 );
        heap.add( 10 );
        heap.add( 3 );
        assertEquals( 5, heap.size() );
        assertEquals( 10, heap.top() );
    }
}
