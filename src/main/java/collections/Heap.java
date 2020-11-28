package collections;

import java.util.Comparator;

// TODO make heap generic
public abstract class Heap {
    private final Comparator<Integer> comparator;
    private static final Comparator<Integer> MAX_COMPARATOR = Integer::compareTo;
    private static final Comparator<Integer> MIN_COMPARATOR = MAX_COMPARATOR.reversed();

    Heap() {
        comparator = MAX_COMPARATOR;
    }

    Heap( Property property ) {
        comparator = ( property == Property.MIN ) ? MIN_COMPARATOR : MAX_COMPARATOR;
    }

    public abstract void add( int element );

    protected abstract void fixTail();

    protected abstract boolean nodeBreaksPropertyFromAbove( int nodeIndex );

    public abstract int top();

    public abstract int size();

    public enum Property { MAX, MIN }

    protected int compare( Integer x, Integer y ) {
        return comparator.compare( x, y );
    }

    protected int parent( int childIndex ) {
        return ( childIndex - 1 ) / 2;
    }

    protected int leftChild( int parentIndex ) {
        return parentIndex * 2 + 1;
    }

    protected int rightChild( int parentIndex ) {
        return parentIndex * 2 + 2;
    }
}
