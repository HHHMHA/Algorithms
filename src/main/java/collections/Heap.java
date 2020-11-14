package collections;

import java.util.Comparator;

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

    public abstract int top();

    public abstract int size();

    public enum Property { MAX, MIN }

    protected int compare( Integer x, Integer y ) {
        return comparator.compare( x, y );
    }
}
