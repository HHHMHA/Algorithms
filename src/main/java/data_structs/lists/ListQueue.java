package data_structs.lists;

import data_structs.queues.Queue;

public class ListQueue implements Queue {
    private final List list = new LinkedList();

    @Override
    public Integer peek() {
        if ( isEmpty() )
            return null;
        return list.get( 0 );
    }

    @Override
    public void enqueue( Integer element ) {
        list.insert( element, getSize() );
    }

    // TODO: this method will always have this implementation so why override it?
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public Integer dequeue() {
        if ( isEmpty() )
            return null;

        int element = peek();
        list.delete( 0 );
        return element;
    }
}
