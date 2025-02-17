package data_structs.arrays;

import data_structs.base.Heap;

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
    protected void heapify( int index ) {
        int currentIndex = index;
        int leftIndex = leftChildIndex( currentIndex );
        int rightIndex = rightChildIndex( currentIndex );

        if ( leftIndex < size() && compare( elements.get( leftIndex ), elements.get( currentIndex ) ) > 0 )
            currentIndex = leftIndex;
        if ( rightIndex < size() && compare( elements.get( rightIndex ), elements.get( currentIndex ) ) > 0 )
            currentIndex = rightIndex;

        if ( currentIndex == index )
            return;

        swap( currentIndex, index );
        heapify( currentIndex );
    }

    @Override
    protected void swap( int firstIndex, int secondIndex ) {
        Collections.swap( elements, firstIndex, secondIndex );
    }

    @Override
    protected boolean nodeParentBreaksProperty( int nodeIndex ) {
        Integer nodeValue = elements.get( nodeIndex );
        Integer parentNodeValue = elements.get( parentIndex( nodeIndex ) );
        return hasParent( nodeIndex ) && compare( nodeValue, parentNodeValue ) > 0;
    }

    @Override
    public Integer top() {
        return empty() ? null : elements.get( 0 );
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public Integer extractTop() {
        Integer top = top();
        if ( empty() )
            return top;

        elements.set( 0, elements.get( size() - 1 ) );
        elements.remove( size() - 1 );
        heapify( 0 );

        return top;
    }

    @Override
    public void increaseKey( int oldValue, int newValue ) {
        int targetKey = elements.indexOf( oldValue );

        if ( targetKey == -1 )
            return;

        if ( compare(newValue, oldValue ) != 1 )
            return;

        elements.set( targetKey, newValue );
        fixParents( targetKey );
    }
}
