package collections.transformers.sorting;

// TODO create a heap class after done with PriorityQueue
public class HeapSorter extends Sorter {
    private int heapSize;

    @Override
    void sortWithAlgorithm( int[] sortable ) {
        heapSize = sortable.length;
        buildMaxHeap( sortable );
        for ( int i = heapSize - 1; i > 0; --i ) {
            swap( sortable, 0, i );
            heapSize = heapSize - 1;
            maxHeapify( sortable, 0 );
        }
    }

    private void buildMaxHeap( int[] heap ) {
        for ( int i = parent( heap.length - 1 ); i >= 0; --i )
            maxHeapify( heap, i );
    }

    private int parent( int i ) {
        return ( i - 1 )  / 2;
    }

    private int left( int i ) {
        return i * 2 + 1;
    }

    private int right( int i ) {
        return i * 2 + 2;
    }

    private void swap( int[] sortable, int x, int y ) {
        int temp = sortable[ x ];
        sortable[ x ] = sortable[ y ];
        sortable[ y ] = temp;
    }

    private void maxHeapify( int[] heap, int root ) {
        int max = root;
        int left = left( root );
        int right = right( root );

        if ( left < heapSize && heap[ left ] > heap[ max ] )
            max = left;
        if ( right < heapSize && heap[ right ] > heap[ max ] )
            max = right;

        if ( max == root )
            return;

        swap( heap, root, max );
        maxHeapify( heap, max );
    }
}
