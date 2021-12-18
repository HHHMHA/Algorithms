package collections;

public interface Queue {
    Integer peek();

    void enqueue( Integer element );

    boolean isEmpty();

    int getSize();

    Integer dequeue();
}
