package collections;

public class Node {
    public static final Node nill = new Node();

    private Integer value;

    public void setNext( Node next ) {
        this.next = next;
    }

    public void setPrevious( Node previous ) {
        this.previous = previous;
    }

    private Node next;
    private Node previous;

    private Node() {
        next = null;
        previous = null;
        value = null;
    }

    public Node( int value, Node next, Node previous ) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node( int value ) {
        this( value, nill, nill );
    }

    public Integer getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }
}
