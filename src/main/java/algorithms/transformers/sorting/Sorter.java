package algorithms.transformers.sorting;

public abstract class Sorter {
    protected int[] sortable;

    public static Sorter fromAlgorithm( SortingAlgorithm sortingAlgorithm ) {
        switch ( sortingAlgorithm ) {
            case MERGE_SORT:
                return new MergeSorter();
            case HEAP_SORT:
                return new HeapSorter();
            case QUICK_SORT:
                return new QuickSorter();
            default:
                return new InsertionSorter();
        }
    }

    public int[] sort( int[] sortable ) {
        this.sortable = copyArray( sortable, sortable.length, 0 );
        sortWithAlgorithm();
        return this.sortable;
    }

    abstract void sortWithAlgorithm();

    int[] copyArray( int[] original, int lengthOfCopy, int startIndex ) {
        int[] copy = new int[ lengthOfCopy ];
        System.arraycopy( original, startIndex, copy, 0, lengthOfCopy );
        return copy;
    }

    void swap( int i, int j ) {
        int tmp = this.sortable[ i ];
        this.sortable[ i ] = this.sortable[ j ];
        this.sortable[ j ] = tmp;
    }
}
