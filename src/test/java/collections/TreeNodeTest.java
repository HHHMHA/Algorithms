package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {
    @Test
    void nillEmptyValue() {
        TreeNode node = TreeNode.nill;
        assertNull( node.getValue() );
    }

    // Also making the nill shared means we can use it only for knowing we can't move anymore
    @Test
    void nillLinkedTonNull() {
        TreeNode node = TreeNode.nill;
        assertNull( node.getLeft() );
        assertNull( node.getRight() );
    }

    @Test
    void nodeCreation() {
        TreeNode node = new TreeNode( 1 );
        assertEquals( 1, node.getValue() );
        assertEquals( TreeNode.nill, node.getLeft() );
        assertEquals( TreeNode.nill, node.getRight() );

        TreeNode leftAndRightNode = new TreeNode( 2, node, node );
        assertEquals( 2, leftAndRightNode.getValue() );
        assertEquals( node, leftAndRightNode.getLeft() );
        assertEquals( node, leftAndRightNode.getRight() );
    }
}
