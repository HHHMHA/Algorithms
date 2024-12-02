package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {
    @Test
    void nillEmptyValue() {
        TreeNode node = TreeNode.nill;
        assertNull(node.getValue());
    }

    // Also making the nill shared means we can use it only for knowing we can't move anymore
    @Test
    void nillLinkedTonNull() {
        TreeNode node = TreeNode.nill;
        assertNull(node.getLeft());
        assertNull(node.getRight());
    }

    @Test
    void nodeCreation() {
        TreeNode node = new TreeNode(1);
        assertEquals(1, node.getValue());
        assertEquals(TreeNode.nill, node.getLeft());
        assertEquals(TreeNode.nill, node.getRight());

        TreeNode leftAndRightNode = new TreeNode(2, node, node, node);
        assertEquals(2, leftAndRightNode.getValue());
        assertEquals(node, leftAndRightNode.getLeft());
        assertEquals(node, leftAndRightNode.getRight());
        assertEquals(node, leftAndRightNode.getParent());
    }


    @Test
    void isRightChildWhenRightChild() {
        TreeNode parent = new TreeNode(10);
        TreeNode rightChild = new TreeNode(20);
        parent.setRight(rightChild);
        rightChild.setParent(parent);

        assertTrue(rightChild.isRightChild(), "The node should be identified as a right child.");
    }

    @Test
    void isRightChildWhenNotRightChild() {
        TreeNode parent = new TreeNode(10);
        TreeNode leftChild = new TreeNode(5);
        parent.setLeft(leftChild);
        leftChild.setParent(parent);

        assertFalse(leftChild.isRightChild(), "The node should not be identified as a right child.");
    }

    @Test
    void isRightChildWhenRoot() {
        TreeNode root = new TreeNode(10);

        assertFalse(root.isRightChild(), "The root node should not be identified as a right child.");
    }

    @Test
    void isRightChildWhenNillParent() {
        TreeNode node = new TreeNode(10);

        assertFalse(node.isRightChild(), "A node with nil parent should not be identified as a right child.");
    }

    @Test
    void isLeftChildWhenLeftChild() {
        TreeNode parent = new TreeNode(10);
        TreeNode leftChild = new TreeNode(5);
        parent.setLeft(leftChild);
        leftChild.setParent(parent);

        assertTrue(leftChild.isLeftChild(), "The node should be identified as a left child.");
    }

    @Test
    void isLeftChildWhenNotLeftChild() {
        TreeNode parent = new TreeNode(10);
        TreeNode rightChild = new TreeNode(20);
        parent.setRight(rightChild);
        rightChild.setParent(parent);

        assertFalse(rightChild.isLeftChild(), "The node should not be identified as a left child.");
    }

    @Test
    void isLeftChildWhenRoot() {
        TreeNode root = new TreeNode(10);

        assertFalse(root.isLeftChild(), "The root node should not be identified as a left child.");
    }

    @Test
    void isLeftChildWhenNillParent() {
        TreeNode node = new TreeNode(10);

        assertFalse(node.isLeftChild(), "A node with nil parent should not be identified as a left child.");
    }

        @Test
    void isChildWhenChild() {
        TreeNode parent = new TreeNode(10);
        TreeNode leftChild = new TreeNode(5);
        parent.setLeft(leftChild);
        leftChild.setParent(parent);

        assertTrue(parent.isChild(leftChild), "The node should be identified as a child.");
    }

    @Test
    void isChildWhenNotChild() {
        TreeNode parent = new TreeNode(10);
        TreeNode rightChild = new TreeNode(20);
        rightChild.setParent(parent);

        assertFalse(parent.isChild(rightChild), "The node should not be identified as a left child.");
    }

    @Test
    void isChildWhenNill() {
        TreeNode root = new TreeNode(10);

        assertFalse(root.isChild(TreeNode.nill), "nil child is not a child");
    }

    @Test
    void isChildWhenNillParent() {
        TreeNode node = new TreeNode(10);

        assertFalse(TreeNode.nill.isChild(node), "A node with nil parent should not be identified as a child.");
    }
}
