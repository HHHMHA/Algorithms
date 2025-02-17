package data_structs.trees;

import data_structs.trees.SearchTree;
import data_structs.trees.Tree;
import data_structs.trees.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        TreeNode suc = t.find(4);
        assertEquals(t.find(2), suc.getLeft());
        assertEquals(TreeNode.nill, suc.getRight());
        assertEquals(TreeNode.nill, suc.getRight());
        assertEquals(t.find(5), suc.getParent());
        assertEquals(t.find(5).getLeft(), suc);
    }

    @Test
    void inorderWalkWhenTreeEmpty() {
        Tree t = new SearchTree();
        List<TreeNode> result = t.inorderWalk();
        assertTrue(result.isEmpty(), "Inorder walk of an empty tree should return an empty list.");
    }

    @Test
    void inorderWalkSingleElement() {
        Tree t = new SearchTree();
        t.insert(5);
        List<TreeNode> result = t.inorderWalk();
        assertEquals(1, result.size(), "Inorder walk of a tree with one element should return one node.");
        assertEquals(5, result.get(0).getValue(), "The single node value should be 5.");
    }

    @Test
    void inorderWalkMultipleElements() {
        Tree t = new SearchTree();
        t.insert(5);
        t.insert(3);
        t.insert(7);
        t.insert(2);
        t.insert(4);
        t.insert(6);
        t.insert(8);

        List<TreeNode> result = t.inorderWalk();

        assertEquals(7, result.size(), "Inorder walk should return 7 nodes.");
        assertEquals(2, result.get(0).getValue(), "The first node should have value 2.");
        assertEquals(3, result.get(1).getValue(), "The second node should have value 3.");
        assertEquals(4, result.get(2).getValue(), "The third node should have value 4.");
        assertEquals(5, result.get(3).getValue(), "The fourth node should have value 5.");
        assertEquals(6, result.get(4).getValue(), "The fifth node should have value 6.");
        assertEquals(7, result.get(5).getValue(), "The sixth node should have value 7.");
        assertEquals(8, result.get(6).getValue(), "The seventh node should have value 8.");
    }

    @Test
    void inorderWalkLeftSkewedTree() {
        Tree t = new SearchTree();
        t.insert(5);
        t.insert(4);
        t.insert(3);
        t.insert(2);
        t.insert(1);

        List<TreeNode> result = t.inorderWalk();

        assertEquals(5, result.size(), "Inorder walk of a left-skewed tree should return 5 nodes.");
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, result.get(i).getValue(), "Node value should be in ascending order.");
        }
    }

    @Test
    void inorderWalkRightSkewedTree() {
        Tree t = new SearchTree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);

        List<TreeNode> result = t.inorderWalk();

        assertEquals(5, result.size(), "Inorder walk of a right-skewed tree should return 5 nodes.");
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, result.get(i).getValue(), "Node value should be in ascending order.");
        }
    }

    @Test
    void inorderWalkBalancedTree() {
        Tree t = new SearchTree();
        t.insert(4);
        t.insert(2);
        t.insert(6);
        t.insert(1);
        t.insert(3);
        t.insert(5);
        t.insert(7);

        List<TreeNode> result = t.inorderWalk();

        assertEquals(7, result.size(), "Inorder walk of a balanced tree should return 7 nodes.");
        for (int i = 0; i < 7; i++) {
            assertEquals(i + 1, result.get(i).getValue(), "Node value should be in ascending order.");
        }
    }

    @Test
    void inorderWalkAfterDeletion() {
        Tree t = new SearchTree();
        t.insert(5);
        t.insert(3);
        t.insert(7);
        t.insert(2);
        t.insert(4);
        t.insert(6);
        t.insert(8);

        t.delete(7);

        List<TreeNode> result = t.inorderWalk();

        assertEquals(6, result.size(), "Inorder walk after deletion should return 6 nodes.");
        assertEquals(2, result.get(0).getValue(), "The first node should have value 2.");
        assertEquals(3, result.get(1).getValue(), "The second node should have value 3.");
        assertEquals(4, result.get(2).getValue(), "The third node should have value 4.");
        assertEquals(5, result.get(3).getValue(), "The fourth node should have value 5.");
        assertEquals(6, result.get(4).getValue(), "The fifth node should have value 6.");
        assertEquals(8, result.get(5).getValue(), "The sixth node should have value 8.");
    }

    @Test
    void leftRotateOnRoot() {
        Tree t = new SearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);

        TreeNode node = t.find(10);
        t.leftRotate(node);

        List<TreeNode> result = t.inorderWalk();
        assertEquals(3, result.size(), "Inorder walk after left rotating root should return 3 nodes.");
        assertEquals(5, result.get(0).getValue(), "The first node should have value 5.");
        assertEquals(10, result.get(1).getValue(), "The second node should have value 10.");
        assertEquals(15, result.get(2).getValue(), "The third node should have value 15.");
    }

    @Test
    void leftRotateOnLeaf() {
        Tree t = new SearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);

        TreeNode node = t.find(15);
        t.leftRotate(node);

        List<TreeNode> result = t.inorderWalk();
        assertEquals(3, result.size(), "Inorder walk after left rotating leaf should return 3 nodes.");
        assertEquals(5, result.get(0).getValue(), "The first node should have value 5.");
        assertEquals(10, result.get(1).getValue(), "The second node should have value 10.");
        assertEquals(15, result.get(2).getValue(), "The third node should have value 15.");
    }

    @Test
    void leftRotateWithRightChildOnly() {
        Tree t = new SearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(12);

        TreeNode node = t.find(10);
        t.leftRotate(node);

        List<TreeNode> result = t.inorderWalk();
        assertEquals(4, result.size(), "Inorder walk after left rotating node with right child only should return 4 nodes.");
        assertEquals(5, result.get(0).getValue(), "The first node should have value 5.");
        assertEquals(10, result.get(1).getValue(), "The second node should have value 10.");
        assertEquals(12, result.get(2).getValue(), "The third node should have value 12.");
        assertEquals(15, result.get(3).getValue(), "The fourth node should have value 15.");
    }

    @Test
    void leftRotateWithLeftChildOnly() {
        Tree t = new SearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(13);
        t.insert(17);

        TreeNode node = t.find(10);
        t.leftRotate(node);

        List<TreeNode> result = t.inorderWalk();
        assertEquals(5, result.size(), "Inorder walk after left rotating node with left child only should return 5 nodes.");
        assertEquals(5, result.get(0).getValue(), "The first node should have value 5.");
        assertEquals(10, result.get(1).getValue(), "The second node should have value 10.");
        assertEquals(13, result.get(2).getValue(), "The third node should have value 13.");
        assertEquals(15, result.get(3).getValue(), "The fourth node should have value 15.");
        assertEquals(17, result.get(4).getValue(), "The fifth node should have value 17.");
    }

    @Test
    void leftRotateWithChildren() {
        Tree t = new SearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(12);
        t.insert(18);

        TreeNode node = t.find(10);
        t.leftRotate(node);

        List<TreeNode> result = t.inorderWalk();
        assertEquals(5, result.size(), "Inorder walk after left rotating node with children should return 5 nodes.");
        assertEquals(5, result.get(0).getValue(), "The first node should have value 5.");
        assertEquals(10, result.get(1).getValue(), "The second node should have value 10.");
        assertEquals(12, result.get(2).getValue(), "The third node should have value 12.");
        assertEquals(15, result.get(3).getValue(), "The fourth node should have value 15.");
        assertEquals(18, result.get(4).getValue(), "The fifth node should have value 18.");
    }

    // Right Rotate Tests

    @Test
    void rightRotateOnRoot() {
        Tree t = new SearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);

        TreeNode node = t.find(15);
        t.rightRotate(node);

        List<TreeNode> result = t.inorderWalk();
        assertEquals(3, result.size(), "Inorder walk after right rotating root should return 3 nodes.");
        assertEquals(5, result.get(0).getValue(), "The first node should have value 5.");
        assertEquals(10, result.get(1).getValue(), "The second node should have value 10.");
        assertEquals(15, result.get(2).getValue(), "The third node should have value 15.");
    }

    @Test
    void rightRotateOnLeaf() {
        Tree t = new SearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);

        TreeNode node = t.find(5);
        t.rightRotate(node);

        List<TreeNode> result = t.inorderWalk();
        assertEquals(3, result.size(), "Inorder walk after right rotating leaf should return 3 nodes.");
        assertEquals(5, result.get(0).getValue(), "The first node should have value 5.");
        assertEquals(10, result.get(1).getValue(), "The second node should have value 10.");
        assertEquals(15, result.get(2).getValue(), "The third node should have value 15.");
    }

    @Test
    void rightRotateWithLeftChildOnly() {
        Tree t = new SearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(3);

        TreeNode node = t.find(10);
        t.rightRotate(node);

        List<TreeNode> result = t.inorderWalk();
        assertEquals(4, result.size(), "Inorder walk after right rotating node with left child only should return 4 nodes.");
        assertEquals(3, result.get(0).getValue(), "The first node should have value 3.");
        assertEquals(5, result.get(1).getValue(), "The second node should have value 5.");
        assertEquals(10, result.get(2).getValue(), "The third node should have value 10.");
        assertEquals(15, result.get(3).getValue(), "The fourth node should have value 15.");
    }

    @Test
    void rightRotateWithRightChildOnly() {
        Tree t = new SearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(7);

        TreeNode node = t.find(10);
        t.rightRotate(node);

        List<TreeNode> result = t.inorderWalk();
        assertEquals(4, result.size(), "Inorder walk after right rotating node with right child only should return 4 nodes.");
        assertEquals(5, result.get(0).getValue(), "The first node should have value 5.");
        assertEquals(7, result.get(1).getValue(), "The second node should have value 7.");
        assertEquals(10, result.get(2).getValue(), "The third node should have value 10.");
        assertEquals(15, result.get(3).getValue(), "The fourth node should have value 15.");
    }

    @Test
    void rightRotateWithChildren() {
        Tree t = new SearchTree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(3);
        t.insert(7);

        TreeNode node = t.find(10);
        t.rightRotate(node);

        List<TreeNode> result = t.inorderWalk();
        assertEquals(5, result.size(), "Inorder walk after right rotating node with children should return 5 nodes.");
        assertEquals(3, result.get(0).getValue(), "The first node should have value 3.");
        assertEquals(5, result.get(1).getValue(), "The second node should have value 5.");
        assertEquals(7, result.get(2).getValue(), "The third node should have value 7.");
        assertEquals(10, result.get(3).getValue(), "The fourth node should have value 10.");
        assertEquals(15, result.get(4).getValue(), "The fifth node should have value 15.");
    }
}
