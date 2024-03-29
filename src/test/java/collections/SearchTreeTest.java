package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTreeTest {

    @Test
    void emptyTree() {
        Tree t = new SearchTree();
        assertTrue(t.isEmpty());
        assertEquals(0, t.getSize());
    }

    @Test
    void findWhenTreeEmpty() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.find(0));
    }

    @Test
    void find() {
        Tree t = new SearchTree();
        t.insert(1);
        t.insert(2);
        t.insert(0);
        assertEquals(1, t.find(1).getValue());
        assertEquals(2, t.find(2).getValue());
        assertEquals(0, t.find(0).getValue());
    }

    @Test
    void max() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.max());

        t.insert(1);
        assertEquals(1, t.max().getValue());

        t.insert(10);
        assertEquals(10, t.max().getValue());

        t.insert(2);
        assertEquals(10, t.max().getValue());
    }

    @Test
    void maxWithParam() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.max(TreeNode.nill));

        t.insert(5);
        t.insert(10);
        t.insert(3);
        t.insert(4);
        t.insert(1);

        var node = t.find(3);
        assertEquals(4, t.max(node).getValue());
    }

    @Test
    void min() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.min());

        t.insert(2);
        assertEquals(2, t.min().getValue());

        t.insert(10);
        assertEquals(2, t.min().getValue());

        t.insert(1);
        assertEquals(1, t.min().getValue());
    }

    @Test
    void minWithParam() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.min(TreeNode.nill));

        t.insert(5);
        t.insert(10);
        t.insert(3);
        t.insert(4);
        t.insert(1);

        var node = t.find(3);
        assertEquals(1, t.min(node).getValue());
    }

    @Test
    void successorRightNodeFull() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.successor(TreeNode.nill));

        t.insert(5);
        t.insert(10);
        t.insert(7);
        t.insert(20);
        t.insert(3);
        t.insert(4);
        t.insert(1);
        t.insert(6);

        var node = t.find(5);
        var successor = t.successor(node);
        var actualSuccessor = t.find(6);
        assertEquals(actualSuccessor, successor);
    }

    @Test
    void successorNoRightNode() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.successor(TreeNode.nill));

        t.insert(5);
        t.insert(10);
        t.insert(7);
        t.insert(20);
        t.insert(3);
        t.insert(4);
        t.insert(1);
        t.insert(6);
        t.insert(8);

        var node = t.find(8);
        var successor = t.successor(node);
        var actualSuccessor = t.find(10);
        assertEquals(actualSuccessor, successor);
    }

    @Test
    void successorNoSuccessor() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.successor(TreeNode.nill));

        t.insert(5);
        t.insert(10);
        t.insert(7);
        t.insert(3);
        t.insert(4);
        t.insert(1);
        t.insert(6);
        t.insert(8);

        var node = t.find(10);
        var successor = t.successor(node);
        var actualSuccessor = TreeNode.nill;
        assertEquals(actualSuccessor, successor);
    }

    @Test
    void predecessorLeftNodeFull() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.predecessor(TreeNode.nill));

        t.insert(5);
        t.insert(10);
        t.insert(7);
        t.insert(20);
        t.insert(3);
        t.insert(4);
        t.insert(1);
        t.insert(6);

        var node = t.find(5);
        var predecessor = t.predecessor(node);
        var actualPredecessor = t.find(1);
        assertEquals(actualPredecessor, predecessor);
    }

    @Test
    void predecessorNoLeftNode() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.predecessor(TreeNode.nill));

        t.insert(5);
        t.insert(1);
        t.insert(10);
        t.insert(20);
        t.insert(15);

        var node = t.find(10);
        var predecessor = t.predecessor(node);
        var actualPredecessor = t.find(5);
        assertEquals(actualPredecessor, predecessor);
    }

    @Test
    void predecessorNoPredecessor() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.predecessor(TreeNode.nill));

        t.insert(5);
        t.insert(10);
        t.insert(7);
        t.insert(20);
        t.insert(6);

        var node = t.find(5);
        var predecessor = t.predecessor(node);
        var actualPredecessor = TreeNode.nill;
        assertEquals(actualPredecessor, predecessor);
    }

    @Test
    void insertWhenTreeEmpty() {
        Tree t = new SearchTree();
        t.insert(1);
        var node = t.find(1);
        assertEquals(1, node.getValue());
        assertEquals(TreeNode.nill, node.getRight());
        assertEquals(TreeNode.nill, node.getLeft());
        assertEquals(TreeNode.nill, node.getParent());
        assertEquals(1, t.getSize());
        assertFalse(t.isEmpty());
    }

    @Test
    void insertMultipleElementsThenCorrectRelation() {
        Tree t = new SearchTree();
        t.insert(1);
        t.insert(2);
        t.insert(0);
        var node = t.find(1);
        var left = node.getLeft();
        var right = node.getRight();

        assertEquals(TreeNode.nill, node.getParent());
        assertEquals(3, t.getSize());

        // Left node properties
        assertEquals(0, left.getValue());
        assertEquals(TreeNode.nill, left.getRight());
        assertEquals(TreeNode.nill, left.getLeft());
        assertEquals(node.getValue(), left.getParent().getValue());

        // Right node properties
        assertEquals(2, right.getValue());
        assertEquals(TreeNode.nill, right.getRight());
        assertEquals(TreeNode.nill, right.getLeft());
        assertEquals(node.getValue(), right.getParent().getValue());
    }

    @Test
    void deleteWhenTreeEmpty() {
        Tree t = new SearchTree();
        assertEquals(TreeNode.nill, t.delete(0));
        assertEquals(TreeNode.nill, t.max());
        assertEquals(TreeNode.nill, t.min());
        assertEquals(0, t.getSize());
        assertTrue(t.isEmpty());
    }

    @Test
    void deleteNonExistentElement() {
        Tree t = new SearchTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);

        assertEquals(TreeNode.nill, t.delete(0));
        assertEquals(3, t.getSize());
    }

    @Test
    void deleteLeafNode() {
        Tree t = new SearchTree();
        t.insert(2);
        t.insert(1);
        t.insert(3);

        assertEquals(1, t.delete(1).getValue());
        assertEquals(TreeNode.nill, t.find(1));
        assertEquals(2, t.getSize());
    }

    @Test
    void deleteNodeWithOneChild() {
        Tree t = new SearchTree();
        t.insert(2);
        t.insert(1);
        t.insert(3);
        t.insert(4);

        assertEquals(3, t.delete(3).getValue());
        assertEquals(TreeNode.nill, t.find(3));
        assertEquals(4, t.find(4).getValue());
        assertEquals(1, t.find(1).getValue());
        assertEquals(2, t.find(2).getValue());
        assertEquals(3, t.getSize());
    }

    @Test
    void deleteRootWithTwoChildren() {
        Tree t = new SearchTree();
        t.insert(5);
        t.insert(3);
        t.insert(7);
        t.insert(2);
        t.insert(4);
        t.insert(6);
        t.insert(8);

        assertEquals(5, t.delete(5).getValue());
        assertEquals(TreeNode.nill, t.find(5));
        assertEquals(6, t.getSize());
        assertEquals(8, t.max().getValue());
        assertEquals(2, t.min().getValue());
    }

    @Test
    void deleteNodeWithTwoChildren() {
        Tree t = new SearchTree();
        t.insert(5);
        t.insert(3);
        t.insert(7);
        t.insert(2);
        t.insert(4);
        t.insert(6);
        t.insert(8);

        assertEquals(3, t.delete(3).getValue());
        assertEquals(TreeNode.nill, t.find(3));
        assertEquals(6, t.getSize());

        assertEquals(5, t.find(5).getValue());
        assertEquals(8, t.find(8).getValue());
        assertEquals(7, t.find(7).getValue());
        assertEquals(2, t.find(2).getValue());
        assertEquals(4, t.find(4).getValue());
        assertEquals(6, t.find(6).getValue());
    }
}
