package collections.transformers.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SorterTest {
    private int[] randomArrayOfInts = { 2, 3, -2, 1, 4, 0 };
    private int[] sortedRandomArrayOfInts = { -2, 0, 1, 2, 3, 4 };

    @Test
    void testInsertionSortOnArray() {
        Sorter sorter = Sorter.fromAlgorithm( SortingAlgorithm.INSERTION_SORT );
        int[] actual = sorter.sort( randomArrayOfInts );
        assertTrue( sorter instanceof InsertionSorter );

        assertArraySorted( actual );
    }

    @Test
    void testMergeSortOnArray() {
        Sorter sorter = Sorter.fromAlgorithm( SortingAlgorithm.MERGE_SORT );
        int[] actual = sorter.sort( randomArrayOfInts );
        assertTrue( sorter instanceof MergeSorter );

        assertArraySorted( actual );
    }

    @Test
    void testHeapSortOnArray() {
        Sorter sorter = Sorter.fromAlgorithm( SortingAlgorithm.HEAP_SORT );
        int[] actual = sorter.sort( randomArrayOfInts );
        assertTrue( sorter instanceof HeapSorter );

        assertArraySorted( actual );
    }

    private void assertArraySorted( int[] actual ) {
        assertArrayEquals( sortedRandomArrayOfInts, actual );
        assertArrayEquals( new int[]{ 2, 3, -2, 1, 4, 0 }, randomArrayOfInts ); // The Algorithm didn't modify the original array
    }
}
