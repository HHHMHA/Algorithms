package data_structs.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NodeTest {
    @Test
    void nillEmptyValue() {
        Node node = Node.nill;
        assertNull( node.getValue() );
    }

    // Also making the nill shared means we can use it only for knowing we can't move anymore
    @Test
    void nillLinkedToNull() {
        Node node = Node.nill;
        assertNull( node.getNext() );
        assertNull( node.getPrevious() );
    }

    @Test
    void nodeCreation() {
        Node node = new Node( 1 );
        assertEquals( 1, node.getValue() );
        assertEquals( Node.nill, node.getNext() );
        assertEquals( Node.nill, node.getPrevious() );

        Node nextAndPreviousNode = new Node( 2, node, node );
        assertEquals( 2, nextAndPreviousNode.getValue() );
        assertEquals( node, nextAndPreviousNode.getNext() );
        assertEquals( node, nextAndPreviousNode.getPrevious() );
    }
}
