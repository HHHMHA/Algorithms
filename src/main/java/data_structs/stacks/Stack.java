package data_structs.stacks;

public interface Stack {
    Integer peek();

    void push( Integer element );

    boolean isEmpty();

    int getSize();

    Integer pop();
}
