package algorithms.operators;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Min {
    private int[] array;
    private int order;

    public Min( int[] array ) {
        this( array, 1 );
    }

    public Min( int[] array, int order ) {
        if ( order > array.length || order < 1 )
            throw new IllegalArgumentException( "Order must be between 1 and collection length" );

        this.array = copyArray( array, array.length, 0 );
        this.order = order;
    }

    // TODO: move with partition and swap to a utils package
    int[] copyArray( int[] original, int lengthOfCopy, int startIndex ) {
        int[] copy = new int[ lengthOfCopy ];
        System.arraycopy( original, startIndex, copy, 0, lengthOfCopy );
        return copy;
    }

    void swap( int i, int j ) {
        int tmp = this.array[ i ];
        this.array[ i ] = this.array[ j ];
        this.array[ j ] = tmp;
    }

    public int evaluate() throws NoSuchElementException {
        if ( array.length == 0 )
            throw new NoSuchElementException();

        // Edge case can be calculated faster in the normal way
        if ( order == 1 )
            return Arrays.stream( array ).min().getAsInt();

        return getOrderedStatistic( 0, order - 1 );
    }

    private int getOrderedStatistic( int left, int right ) {
        if ( left == right )
            return array[ left ];

        int pivotIndex = partition( left, right );
        int orderIndex = pivotIndex - left + 1; // The Ordered Statistic Number For Array[Left, Right]

        if ( orderIndex == order )
            return array[ pivotIndex ];

        if ( order < orderIndex )
            return getOrderedStatistic( left, pivotIndex - 1 );

        order -= orderIndex;
        return getOrderedStatistic( pivotIndex + 1, right );
    }

    private int partition( int start, int end ) {
        int pivot = choosePivot( start, end );

        int pivotSuccessorIndex = start - 1; // Can come up with a longer name like lastElementIndexLessThanPivot
        for ( int i = start; i < end; ++i ) {
            if ( array[ i ] > pivot ) {
                continue;
            }
            swap( ++pivotSuccessorIndex, i );
        }
        swap( ++pivotSuccessorIndex, end );
        return pivotSuccessorIndex;
    }

    private int choosePivot( int start, int end ) {
        return array[ end ];
    }

}
