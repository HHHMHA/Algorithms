package data_structs.lists;

public interface List {
    int NOT_FOUND = -1;

    void insert( int element, int index ) throws IndexOutOfBoundsException;
    void delete( int index );
    int find( int element );
    int get( int index );
    int getSize();
    default boolean isEmpty() {
        return getSize() == 0;
    }
}
