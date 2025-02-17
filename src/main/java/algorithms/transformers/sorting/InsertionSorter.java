package algorithms.transformers.sorting;

class InsertionSorter extends Sorter {
    @Override
    void sortWithAlgorithm() {
        for ( int unsortedIndex = 1; unsortedIndex < sortable.length; ++unsortedIndex ) {
            int elementToInsert = sortable[ unsortedIndex ];
            int insertionIndex = getInsertionIndexAndShiftElements( unsortedIndex );
            sortable[ insertionIndex ] = elementToInsert;
        }
    }

    private int getInsertionIndexAndShiftElements( int unsortedIndex ) {
        int elementToInsert = sortable[ unsortedIndex ];
        int insertionIndex = unsortedIndex - 1;
        for ( ; insertionIndex >= 0 && sortable[ insertionIndex ] > elementToInsert; --insertionIndex ) {
            shiftRight( sortable, insertionIndex );
        }
        return insertionIndex + 1;
    }

    private void shiftRight( int[] array, int elementIndex ) {
        array[ elementIndex + 1] = array[ elementIndex ];
    }
}
