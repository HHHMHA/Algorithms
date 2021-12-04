package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void isEmptyTrue() {
        Stack s = new ArrayStack();
        assertTrue( s.isEmpty() );
    }

    @Test
    void isEmptyFalse() {
        Stack s = new ArrayStack();
        s.push( 3 );
        assertFalse( s.isEmpty() );
    }

    @Test
    void peekEmptyStack() {
        Stack s = new ArrayStack();
        assertNull( s.peek() );
    }

    @Test
    void getSize() {
        Stack s = new ArrayStack();
        assertEquals( 0, s.getSize() );
        s.push( 3 );
        assertEquals( 1, s.getSize() );
    }

    @Test
    void push() {
        Stack s = new ArrayStack();
        s.push( 3 );
        assertEquals( 3, s.peek() );
    }

    @Test
    void pushForArrayStack() {
        // Make sure that the stack will grow

        Stack s = new ArrayStack();
        for ( int i = 0 ; i <= 1000; ++i )
            s.push( i );
        assertEquals( 1001, s.getSize() );
        assertEquals( 1000, s.peek() );
    }

    @Test
    void popEmptyStack() {
        Stack s = new ArrayStack();
        assertNull( s.pop() );
        assertEquals( 0, s.getSize() );
    }

    @Test
    void pop() {
        Stack s = new ArrayStack();
        s.push( 3 );
        assertEquals( 3, s.pop() );
    }

    @Test
    void popMultipleElements() {
        Stack s = new ArrayStack();
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
