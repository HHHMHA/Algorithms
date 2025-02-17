package data_structs.arrays;

import data_structs.queues.Queue;

public class ArrayQueue implements Queue {
    // TODO: We can extract the growing array to a separate class
    // TODO: Also we can extract common stuff between array implemented data structures
    private static final int INITIAL_CAPACITY = 10;
    private static final int HEAD_INDEX = 0;
    private boolean empty = true;
    private Integer[] elements = new Integer[INITIAL_CAPACITY];
    private int tailIndex = -1;
    private int capacity = INITIAL_CAPACITY;

    @Override
    public Integer peek() {
        if ( isEmpty() )
            return null;

        return elements[HEAD_INDEX];
    }

    @Override
    public void enqueue( Integer element ) {
        growIfFull();
        elements[++tailIndex] = element;
    }

    private void growIfFull() {
        if ( isFull() )
            grow();
    }

    private void grow() {
        capacity *= 2;
        Integer[] newElements = new Integer[capacity];
        System.arraycopy( elements, 0, newElements, 0, elements.length );
        elements = newElements;
    }

    private boolean isFull() {
        return getSize() == elements.length;
    }

    // TODO: this method will always have this implementation so why override it?
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int getSize() {
        return tailIndex + 1;
    }

    @Override
    public Integer dequeue() {
        if ( isEmpty() )
            return null;

        int element = peek();
        // yes we can create a circular queue instead, but I don't want to.
        shiftLeft();
        --tailIndex;
        return element;
    }

    private void shiftLeft() {
        if ( tailIndex >= 0 ) System.arraycopy( elements, 1, elements, 0, tailIndex );
    }
}
