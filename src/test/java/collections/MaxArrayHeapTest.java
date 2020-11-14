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
        assertEquals( 3, heap.size() );
        assertEquals( 4, heap.top() );
    }
}
