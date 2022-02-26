package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListStackTest {

    @Test
    void isEmptyTrue() {
        Stack s = new ListStack();
        assertTrue( s.isEmpty() );
    }

    @Test
    void isEmptyFalse() {
        Stack s = new ListStack();
        s.push( 3 );
        assertFalse( s.isEmpty() );
    }

    @Test
    void peekEmptyStack() {
        Stack s = new ListStack();
        assertNull( s.peek() );
    }

    @Test
    void getSize() {
        Stack s = new ListStack();
        assertEquals( 0, s.getSize() );
        s.push( 3 );
        assertEquals( 1, s.getSize() );
    }

    @Test
    void push() {
        Stack s = new ListStack();
        s.push( 3 );
        assertEquals( 3, s.peek() );
    }

    @Test
    void popEmptyStack() {
        Stack s = new ListStack();
        assertNull( s.pop() );
        assertEquals( 0, s.getSize() );
    }

    @Test
    void pop() {
        Stack s = new ListStack();
        s.push( 3 );
        assertEquals( 3, s.pop() );
    }

    @Test
    void popMultipleElements() {
        Stack s = new ListStack();
        s.push( 3 );
        s.push( 4 );
        assertEquals( 4, s.pop() );
        assertEquals( 3, s.pop() );
        assertNull( s.pop() );
        assertEquals( 0, s.getSize() );
        assertTrue( s.isEmpty() );
        s.push( 3 );
        assertEquals( 3, s.peek() );
        assertEquals( 1, s.getSize() );
    }
}
