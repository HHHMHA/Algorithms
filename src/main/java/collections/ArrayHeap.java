package collections;

import java.util.ArrayList;

import static java.util.Collections.swap;

// TODO move implementation up after creating more data structures
public class ArrayHeap extends Heap {
    private final ArrayList<Integer> elements = new ArrayList<>();

    public ArrayHeap() {}

    public ArrayHeap( Property property ) {
        super( property );
    }

    @Override
    public void add( int element ) {
        elements.add( element );
        fixTail();
    }

    @Override
    protected void fixTail() {
        int i = size() - 1;
        while ( i != 0 && elements.get( i ).compareTo( elements.get( i - 1 ) ) > 0 ) {
            swap( elements, i , i - 1 );
            --i;
        }
    }

    @Override
    public int top() {
        return elements.get( 0 );
    }

    @Override
    public int size() {
        return elements.size();
    }
}
