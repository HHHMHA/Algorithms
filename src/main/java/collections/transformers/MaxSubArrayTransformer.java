package collections.transformers;

import java.util.Arrays;

// TODO refactor
public class MaxSubArrayTransformer {
    private int[] array;

    public MaxSubArrayTransformer( int[] array ) {
        this.array = array;
    }

    public int[] transform() {
        return getMaxSubArray();
    }

    private int[] getMaxSubArray() {
        int begin = 0, currentSum = array[ 0 ];
        int maxBegin = 0, maxEnd = 0, maxSum = array[ 0 ];

        for ( int i = 1; i < array.length; ++i ) {
            currentSum = currentSum + array[ i ];
            if ( currentSum < array[ i ] )  {
                begin = i;
                currentSum = array[ i ];
            }

            if ( maxSum < currentSum ) {
                maxSum = currentSum;
                maxBegin = begin;
                maxEnd = i;
            }
        }

        return Arrays.copyOfRange( array, maxBegin, maxEnd + 1 );
    }

    public void setArray( int[] array ) {
        this.array = array;
    }
}
