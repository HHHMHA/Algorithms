package algorithms.transformers;

import algorithms.transformers.MaxSubArrayTransformer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxSubarrayTest {
    int[] array = { 1, 2, 3, 4, -100, 10, 2, -1, 2, -100 };
    int[] negativeArray = { -100, -2, -1, -4 };

    @Test
    void testGetMaxSubArray() {
        MaxSubArrayTransformer maxSubArrayTransformer = new MaxSubArrayTransformer( array );

        assertArrayEquals( new int[] { 10, 2, -1, 2 }, maxSubArrayTransformer.transform() );

        maxSubArrayTransformer.setArray( negativeArray );
        assertArrayEquals( new int[] { -1 }, maxSubArrayTransformer.transform() );
    }
}
