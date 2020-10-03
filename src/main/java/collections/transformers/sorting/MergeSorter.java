package collections.transformers.sorting;

public class MergeSorter extends Sorter {
    @Override
    void sortWithAlgorithm( int[] sortable ) {
        mergeSort( sortable, 0, sortable.length - 1 );
    }

    private void mergeSort( int[] sortable, int start, int end ) {
        if ( start >= end )
            return;

        int middle = ( start + end ) / 2;
        mergeSort( sortable, start, middle );
        mergeSort( sortable, middle + 1, end );
        mergeSortedHalves( sortable, start, middle, end );
    }

    private void mergeSortedHalves( int[] sortable, int start, int middle, int end ) {
        int lengthOfLeft = middle - start + 1;
        int[] left = copyArray( sortable, lengthOfLeft, start );

        int lengthOfRight = end - middle;
        int[] right = copyArray( sortable, lengthOfRight, middle + 1 );

        int leftIndex = 0, rightIndex = 0, sortableIndex = start;

        while ( leftIndex < lengthOfLeft && rightIndex < lengthOfRight ) {
            if ( left[ leftIndex ] < right[ rightIndex ] )
                sortable[ sortableIndex++ ] = left[ leftIndex++ ];
            else
                sortable[ sortableIndex++ ] = right[ rightIndex++ ];
        }

        while ( leftIndex < lengthOfLeft )
            sortable[ sortableIndex++ ] = left[ leftIndex++ ];

        while ( rightIndex < lengthOfRight )
            sortable[ sortableIndex++ ] = right[ rightIndex++ ];
    }

}
