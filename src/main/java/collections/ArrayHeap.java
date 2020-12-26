package collections;

import java.util.ArrayList;
import java.util.Collections;

// TODO move implementation up after creating more data structures
// TODO move elements field to parent with a more general type
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
    protected void swap( int i ) {
        Collections.swap( elements, i , parent( i ) );
    }

    @Override
    protected boolean nodeParentBreaksProperty( int nodeIndex ) {
        Integer nodeValue = elements.get( nodeIndex );
        Integer parentNodeValue = elements.get( parent( nodeIndex ) );
        return hasParent( nodeIndex ) && compare( nodeValue, parentNodeValue ) > 0;
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
