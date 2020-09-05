package sorting;

class InsertionSorter extends Sorter {
    public int[] sort( int[] sortable ) {
        int[] sortableCopy = new int[ sortable.length ];
        System.arraycopy( sortable, 0, sortableCopy, 0, sortable.length );

        return insertionSort( sortableCopy );
    }

    private int[] insertionSort( int[] sortable ) {
        for ( int unsortedIndex = 1; unsortedIndex < sortable.length; ++unsortedIndex ) {
            int elementToInsert = sortable[ unsortedIndex ];
            int insertionIndex = getInsertionIndexAndPushElements( sortable, unsortedIndex, elementToInsert );
            sortable[ insertionIndex ] = elementToInsert;
        }

        return sortable;
    }

    private int getInsertionIndexAndPushElements( int[] sortable, int unsortedIndex, int elementToInsert ) {
        int insertionIndex = unsortedIndex - 1;
        for ( ; insertionIndex >= 0 && sortable[ insertionIndex ] > elementToInsert; --insertionIndex ) {
            sortable[ insertionIndex + 1] = sortable[ insertionIndex ];
        }
        return insertionIndex + 1;
    }
}
