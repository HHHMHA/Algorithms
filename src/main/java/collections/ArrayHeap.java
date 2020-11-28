package collections;

import java.util.ArrayList;

import static java.util.Collections.swap;

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
    protected void fixTail() {
        int i = size() - 1;
        while ( nodeBreaksPropertyFromAbove( i ) ) {
            swap( elements, i , parent( i ) );
            i = parent( i );
        }
    }

    /**
     * Checks if a node breaks the heap property from above which means that
     * all of the current node descendants satisfy the property
     * but the node's parent does not
     * @param nodeIndex The index of the node.
     * @return True if the node's parent breaks the property with the current node
     */
    @Override
    protected boolean nodeBreaksPropertyFromAbove( int nodeIndex ) {
        return nodeIndex != 0 && compare( elements.get( nodeIndex ), elements.get( parent( nodeIndex ) ) ) > 0;
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
