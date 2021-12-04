package collections;

public class ArrayStack implements Stack {
    private static final int INITIAL_CAPACITY = 10;
    private Integer[] elements = new Integer[INITIAL_CAPACITY];
    private int topIndex = -1;
    private int capacity = INITIAL_CAPACITY;

    @Override
    public Integer peek() {
        if ( isEmpty() )
            return null;
        return elements[ topIndex ];
    }

    @Override
    public void push( Integer element ) {
        growIfFull();
        elements[ ++topIndex ] = element;
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

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int getSize() {
        return topIndex + 1;
    }

    @Override
    public Integer pop() {
        if ( isEmpty() )
            return null;

        return elements[topIndex--];
    }
}
