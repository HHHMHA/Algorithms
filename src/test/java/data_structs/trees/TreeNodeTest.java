package data_structs.trees;

import data_structs.trees.TreeNode;
import data_structs.trees.node.ColoredNode;
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

    @Test
    void hasPropertyValueTest() {
        TreeNode node = new TreeNode(10);
        node.setProperty(ColoredNode.Black());

        assertTrue(node.hasPropertyValue(ColoredNode.Black()));
        assertFalse(node.hasPropertyValue(ColoredNode.Red()));

        node.setProperty(ColoredNode.Red());
        assertFalse(node.hasPropertyValue(ColoredNode.Black()));
        assertTrue(node.hasPropertyValue(ColoredNode.Red()));
    }

    @Test
    void getUncleWhenNoParent() {
        TreeNode node = new TreeNode(10);
        node.setParent(TreeNode.nill);
        assertEquals(TreeNode.nill, node.getUncle(), "Node without parent should return nil uncle.");
    }

    @Test
    void getUncleWhenNoGrandparent() {
        TreeNode parent = new TreeNode(20);
        parent.setParent(TreeNode.nill);

        TreeNode node = new TreeNode(10);
        node.setParent(parent);

        assertEquals(TreeNode.nill, node.getUncle(), "Node without grandparent should return nil uncle.");
    }

    @Test
    void getUncleWhenParentIsLeftChild() {
        TreeNode grandparent = new TreeNode(30);
        TreeNode parent = new TreeNode(20);
        TreeNode uncle = new TreeNode(40);
        TreeNode node = new TreeNode(10);

        grandparent.setLeft(parent);
        grandparent.setRight(uncle);
        parent.setParent(grandparent);
        uncle.setParent(grandparent);

        node.setParent(parent);

        assertEquals(uncle, node.getUncle(), "Uncle should be the right child of grandparent.");
    }

    @Test
    void getUncleWhenParentIsRightChild() {
        TreeNode grandparent = new TreeNode(30);
        TreeNode parent = new TreeNode(40);
        TreeNode uncle = new TreeNode(20);
        TreeNode node = new TreeNode(50);

        grandparent.setRight(parent);
        grandparent.setLeft(uncle);
        parent.setParent(grandparent);
        uncle.setParent(grandparent);

        node.setParent(parent);

        assertEquals(uncle, node.getUncle(), "Uncle should be the left child of grandparent.");
    }

    @Test
    void getUncleWhenUncleIsNill() {
        TreeNode grandparent = new TreeNode(30);
        TreeNode parent = new TreeNode(20);
        TreeNode node = new TreeNode(10);

        grandparent.setLeft(parent); // parent is left child
        grandparent.setRight(TreeNode.nill); // no uncle

        parent.setParent(grandparent);
        node.setParent(parent);

        assertEquals(TreeNode.nill, node.getUncle(), "Should return nil when there is no uncle.");
    }

}
