package data_structs.lists;

import data_structs.lists.LinkedList;
import data_structs.lists.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void insert() {
        List list = new LinkedList();
        list.insert( 1, 0 );

        assertEquals( 1, list.getSize() );
        assertEquals( 1, list.get( 0 ) );
        assertEquals( 0, list.find( 1 ) );
        assertFalse( list.isEmpty() );
    }

    @Test
    void insertInMiddle() {
        List list = new LinkedList();
        list.insert( 1, 0 );
        list.insert( 3, 1 );
        list.insert( 2, 1 );

        assertEquals( 3, list.getSize() );

        assertEquals( 1, list.get( 0 ) );
        assertEquals( 2, list.get( 1 ) );
        assertEquals( 3, list.get( 2 ) );

        assertEquals( 0, list.find( 1 ) );
        assertEquals( 1, list.find( 2 ) );
        assertEquals( 2, list.find( 3 ) );


        assertFalse( list.isEmpty() );
    }

    @Test
    void insertWhenIndexWrongThenOutOfBounds() {
        List list = new LinkedList();
        assertThrows( IndexOutOfBoundsException.class, () -> list.insert( 1, 1 ) );
        list.insert( 0, 0 );
        assertThrows( IndexOutOfBoundsException.class, () -> list.insert( 1, -1 ) );
        assertThrows( IndexOutOfBoundsException.class, () -> list.insert( 1, 2 ) );
        list.insert( 0, 1 );
    }

    @Test
    void insertLotsOfValues() {
        List list = new LinkedList();
        for ( int i = 0; i < 10; ++i )
            list.insert( i, i );

        for ( int i = 0; i < 10; ++i )
            assertEquals( i, list.get( i ) );
    }

    @Test
    void getWhenWrongIndexThenException() {
        List list = new LinkedList();
        assertThrows( IndexOutOfBoundsException.class, () -> list.get( 0 ) );
    }

    @Test
    void deleteWhenEmptyThenThrowsException() {
        List list = new LinkedList();
        assertThrows( IndexOutOfBoundsException.class, () -> list.delete( 0 ) );
    }

    @Test
    void deleteWhenWrongIndexThenThrowsException() {
        List list = new LinkedList();
        list.insert( 1, 0 );
        assertThrows( IndexOutOfBoundsException.class, () -> list.delete( 1 ) );
    }

    @Test
    void deleteWhenSingleElementThenListIsEmpty() {
        List list = new LinkedList();
        list.insert( 1, 0 );
        list.delete( 0 );

        assertTrue( list.isEmpty() );
        assertEquals( 0, list.getSize() );
        assertEquals( List.NOT_FOUND, list.find( 1 ) );
        assertThrows( IndexOutOfBoundsException.class, () -> list.get( 0 ) );
    }

    @Test
    void delete() {
        List list = new LinkedList();
        list.insert( 1, 0 );
        list.insert( 2, 1 );
        list.insert( 3, 2 );
        list.delete( 1 );

        assertFalse( list.isEmpty() );
        assertEquals( 2, list.getSize() );
        assertEquals( List.NOT_FOUND, list.find( 2 ) );
        assertEquals( 0, list.find( 1 ) );
        assertEquals( 1, list.find( 3 ) );

        assertEquals( 1, list.get( 0 ) );
        assertEquals( 3, list.get( 1 ) );
    }

    @Test
    void findWhenEmptyReturnNotFound() {
        List list = new LinkedList();
        assertEquals( List.NOT_FOUND, list.find( 1 ) );
    }

    @Test
    void getSizeWhenEmpty() {
        List list = new LinkedList();
        assertEquals( 0, list.getSize() );
    }

    @Test
    void isEmptyTrue() {
        List list = new LinkedList();
        assertTrue( list.isEmpty() );
    }
}
