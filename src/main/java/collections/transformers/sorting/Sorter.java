package collections.transformers.sorting;

public abstract class Sorter {
    public static Sorter fromAlgorithm( SortingAlgorithm sortingAlgorithm ) {
        switch ( sortingAlgorithm ) {
            case MERGE_SORT:
                return new MergeSorter();
            default: // TODO later once I have more than this
                return new InsertionSorter();
        }
    }

    public int[] sort( int[] sortable ) {
        int[] sortableCopy = copyArray( sortable, sortable.length, 0 );
        sortWithAlgorithm( sortableCopy );
        return sortableCopy;
    }

    abstract void sortWithAlgorithm( int[] sortable );

    int[] copyArray( int[] original, int lengthOfCopy, int startIndex ) {
        int[] copy = new int[ lengthOfCopy ];
        System.arraycopy( original, startIndex, copy, 0, lengthOfCopy );
        return copy;
    }
}
