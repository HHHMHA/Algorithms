package data_structs.lists;

import data_structs.stacks.Stack;

public class ListStack implements Stack {
    private final List list = new LinkedList();

    @Override
    public Integer peek() {
        if ( isEmpty() )
            return null;
        return list.get( 0 );
    }

    @Override
    public void push( Integer element ) {
        list.insert( element, 0 );
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public Integer pop() {
        if ( isEmpty() )
            return null;
        var element = peek();
        list.delete( 0 );
        return element;
    }
}
