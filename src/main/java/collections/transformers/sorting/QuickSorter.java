package collections.transformers.sorting;

public class QuickSorter extends Sorter {
    @Override
    void sortWithAlgorithm() {
        quickSort( 0, this.sortable.length - 1 );
    }

    private void quickSort( int start, int end ) {
        if ( end < start )
            return;

        int pivotIndex = partition( start, end );
        quickSort( start, pivotIndex - 1 );
        quickSort( pivotIndex + 1, end );
    }

    private int partition( int start, int end ) {
        int pivot = choosePivot( start, end );

        int pivotSuccessorIndex = start - 1; // Can come up with a longer name like lastElementIndexLessThanPivot
        for ( int i = start; i < end; ++i ) {
            if ( this.sortable[ i ] > pivot ) {
                continue;
            }
            swap( ++pivotSuccessorIndex, i );
        }
        swap( ++pivotSuccessorIndex, end );
        return pivotSuccessorIndex;
    }

    private int choosePivot( int start, int end ) {
        return this.sortable[ end ];
    }
}
