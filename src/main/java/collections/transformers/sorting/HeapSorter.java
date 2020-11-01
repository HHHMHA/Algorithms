package collections.transformers.sorting;

// TODO create a heap class after done with PriorityQueue
public class HeapSorter extends Sorter {
    private int heapSize;

    @Override
    void sortWithAlgorithm() {
        heapSize = sortable.length;
        buildMaxHeap();
        for ( int i = heapSize - 1; i > 0; --i ) {
            swap( sortable, 0, i );
            heapSize = heapSize - 1;
            maxHeapify( 0 );
        }
    }

    private void buildMaxHeap() {
        for ( int i = parent( sortable.length - 1 ); i >= 0; --i )
            maxHeapify( i );
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

    private void maxHeapify( int rootIndex ) {
        int maxIndex = rootIndex;
        int leftIndex = left( rootIndex );
        int rightIndex = right( rootIndex );

        if ( leftIndex < heapSize && sortable[ leftIndex ] > sortable[ maxIndex ] )
            maxIndex = leftIndex;
        if ( rightIndex < heapSize && sortable[ rightIndex ] > sortable[ maxIndex ] )
            maxIndex = rightIndex;

        if ( maxIndex == rootIndex )
            return;

        swap( sortable, rootIndex, maxIndex );
        maxHeapify( maxIndex );
    }
}
