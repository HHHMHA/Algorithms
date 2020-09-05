package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SorterTest {

    @Test
    void testInsertionSortOnArray() {
        int[] randomArrayOfInts = { 2, 3, -2, 1, 4, 0 };
        int[] sortedRandomArrayOfInts = { -2, 0, 1, 2, 3, 4 };

        Sorter sorter = Sorter.fromAlgorithm( SortingAlgorithm.INSERTION_SORT );
        int[] actual = sorter.sort( randomArrayOfInts );

        assertArrayEquals( sortedRandomArrayOfInts, actual );
        assertTrue( sorter instanceof InsertionSorter );
        assertArrayEquals( new int[]{ 2, 3, -2, 1, 4, 0 }, randomArrayOfInts ); // The Algorithm didn't modify the original array
    }
}
