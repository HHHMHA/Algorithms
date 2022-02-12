package collections;

public class LinkedList implements List {
    private Node head = Node.nill;
    private Node tail = Node.nill;
    private int size = 0;

    @Override
    public void insert( int element, int index ) throws IndexOutOfBoundsException {
        checkIndexInInsertBounds( index );

        if ( index == 0 ) {
            insertFirst( element );
            ++size;
            return;
        }

        if ( index == getSize() ) {
            insertLast( element );
            ++size;
            return;
        }

        insertInMiddle( element, index );
        ++size;
    }

    private void checkIndexInInsertBounds( int index ) throws IndexOutOfBoundsException {
        if ( index < 0 || index > size ) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndexInBounds( int index ) throws IndexOutOfBoundsException {
        if ( isEmpty() || index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void insertFirst( int element ) {
        Node next = head;
        head = new Node( element, next, Node.nill );
        next.setPrevious( head );

        if ( size == 0 )
            tail = head;
    }

    private void insertLast( int element ) {
        Node previous = tail;
        tail = new Node( element, Node.nill, previous );
        previous.setNext( tail );
    }

    private void insertInMiddle( int element, int index ) {
        Node nextNode = getNode( index );
        Node previousNode = nextNode.getPrevious();

        Node node = new Node( element, nextNode, previousNode );
        nextNode.setPrevious( node );
        previousNode.setNext( node );
    }

    private Node getNode( int index ) {
        Node node = head;
        for ( int i = 0; i < index; ++i )
            node = node.getNext();
        return node;
    }

    @Override
    public void delete( int index ) {
        checkIndexInBounds( index );

        var node = getNode( index );
        var previous = node.getPrevious();
        var next = node.getNext();

        if ( previous != Node.nill ) {
            previous.setNext( next );
        }

        if ( next != Node.nill ) {
            next.setPrevious( previous );
        }

        if ( node == head ) {
            head = next;
        }

        if ( node == tail ) {
            tail = previous;
        }

        --size;
    }

    @Override
    public int find( int element ) {
        Node node = head;
        for ( int i = 0; i < size; ++i ) {
            if ( node.getValue() == element )
                return i;
            node = node.getNext();
        }
        return List.NOT_FOUND;
    }

    @Override
    public int get( int index ) {
        checkIndexInBounds( index );
        return getNode( index ).getValue();
    }

    @Override
    public int getSize() {
        return size;
    }
}
