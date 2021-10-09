package collections.operators;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MinTest {
    private int[] normalArray = { 2, 1, 4 , 23, 3 };
    private int[] arrayWithDuplicates = { 2, 2, 1, 1, 1, 1, 4 , 23, 23, 3 };

    @Test
    void evaluateEmptyThrowsException() {
        assertThrows( IllegalArgumentException.class, () -> new Min( new int[0] ).evaluate() );
    }

    @Test
    void evaluateMinimum() {
        assertEquals( 1, new Min( normalArray ).evaluate() );
        assertEquals( 1, new Min( arrayWithDuplicates ).evaluate() );
    }

    @Test
    void evaluateWithWrongOrder() {
        assertThrows( IllegalArgumentException.class, () -> new Min( normalArray, 0 ).evaluate() );
        assertThrows( IllegalArgumentException.class, () -> new Min( normalArray, 6 ).evaluate() );
        assertThrows( IllegalArgumentException.class, () -> new Min( arrayWithDuplicates, 11 ).evaluate() );
    }

    // Getting the nth minimum AKA nth ordered statistic
    @Test
    void evaluateOrderedStatistic() {
        assertEquals( 1, new Min( normalArray, 1 ).evaluate() );
        assertEquals( 23, new Min( normalArray, 5 ).evaluate() );
        assertEquals( 3, new Min( normalArray, 3 ).evaluate() );

        assertEquals( 1, new Min( arrayWithDuplicates, 3 ).evaluate() );
        assertEquals( 23, new Min( arrayWithDuplicates, 9 ).evaluate() );
        assertEquals( 3, new Min( arrayWithDuplicates, 7 ).evaluate() );
    }
}
