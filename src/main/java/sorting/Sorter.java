package sorting;

public abstract class Sorter {
    public static Sorter fromAlgorithm( SortingAlgorithm sortingAlgorithm ) {
        switch ( sortingAlgorithm ) {
            case INSERTION_SORT:
                return new InsertionSorter();
            default: // TODO later once I have more than this
                return new InsertionSorter();
        }
    }

    public abstract int[] sort( int[] sortable );
}
