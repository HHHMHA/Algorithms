package data_structs.base;

import java.util.Comparator;

// TODO make heap generic
public abstract class Heap {
    private final Comparator<Integer> comparator;
    private static final Comparator<Integer> MAX_COMPARATOR = Integer::compareTo;
    private static final Comparator<Integer> MIN_COMPARATOR = MAX_COMPARATOR.reversed();

    public Heap() {
        comparator = MAX_COMPARATOR;
    }

    public Heap( Property property ) {
        comparator = ( property == Property.MIN ) ? MIN_COMPARATOR : MAX_COMPARATOR;
    }

    public abstract void add( int element );

    protected void fixParents( int childIndex ) {
        int index = childIndex;
        while ( nodeParentBreaksProperty( index ) ) {
            swap( index, parentIndex( index ) );
            index = parentIndex( index );
        }
    }

    protected void fixTail() {
        fixParents( size() - 1 );
    }

    protected abstract void heapify( int index );

    protected abstract void swap( int firstIndex, int secondIndex );

    /**
     * Checks if a node breaks the heap property from above which means that
     * all of the current node descendants satisfy the property
     * but the node's parent does not
     * @param nodeIndex The index of the node.
     * @return True if the node's parent breaks the property with the current node
     */
    protected abstract boolean nodeParentBreaksProperty( int nodeIndex );

    protected boolean hasParent(int nodeIndex) {
        return nodeIndex != 0;
    }

    public abstract Integer top();

    public abstract int size();

    public boolean empty() {
        return size() == 0;
    }

    public abstract Integer extractTop();

    public abstract void increaseKey( int oldValue, int newValue );

    public enum Property { MAX, MIN }

    protected int compare( Integer x, Integer y ) {
        return comparator.compare( x, y );
    }

    protected int parentIndex( int childIndex ) {
        return ( childIndex - 1 ) / 2;
    }

    protected int leftChildIndex( int parentIndex ) {
        return parentIndex * 2 + 1;
    }

    protected int rightChildIndex( int parentIndex ) {
        return parentIndex * 2 + 2;
    }
}
