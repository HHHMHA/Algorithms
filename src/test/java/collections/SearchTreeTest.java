package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTreeTest {

    @Test
    void emptyTree() {
        Tree t = new SearchTree();
        assertTrue( t.isEmpty() );
        assertEquals( 0, t.getSize() );
    }

    @Test
    void findWhenTreeEmpty() {
        Tree t = new SearchTree();
        assertEquals( TreeNode.nill, t.find( 0 ) );
    }

    @Test
    void find() {
        Tree t = new SearchTree();
        t.insert( 1 );
        t.insert( 2 );
        t.insert( 0 );
        assertEquals( 1, t.find( 1 ).getValue() );
        assertEquals( 2, t.find( 2 ).getValue() );
        assertEquals( 0, t.find( 0 ).getValue() );
    }

    @Test
    void max() {
        Tree t = new SearchTree();
        assertEquals( TreeNode.nill, t.max() );

        t.insert( 1 );
        assertEquals( 1, t.max().getValue() );

        t.insert( 10 );
        assertEquals( 10, t.max().getValue() );

        t.insert( 2 );
        assertEquals( 10, t.max().getValue() );
    }

    @Test
    void max_param() {
        Tree t = new SearchTree();
        assertEquals( TreeNode.nill, t.max( TreeNode.nill ) );

        t.insert( 5 );
        t.insert( 10 );
        t.insert( 3 );
        t.insert( 4 );
        t.insert( 1 );

        var node = t.find( 3 );
        assertEquals( 4, t.max( node ).getValue() );
    }

    @Test
    void min() {
        Tree t = new SearchTree();
        assertEquals( TreeNode.nill, t.min() );

        t.insert( 2 );
        assertEquals( 2, t.min().getValue() );

        t.insert( 10 );
        assertEquals( 2, t.min().getValue() );

        t.insert( 1 );
        assertEquals( 1, t.min().getValue() );
    }

    @Test
    void min_param() {
        Tree t = new SearchTree();
        assertEquals( TreeNode.nill, t.min( TreeNode.nill ) );

        t.insert( 5 );
        t.insert( 10 );
        t.insert( 3 );
        t.insert( 4 );
        t.insert( 1 );

        var node = t.find( 3 );
        assertEquals( 1, t.min( node ).getValue() );
    }

    @Test
    void successor() {
    }

    @Test
    void predecessor() {
    }

    @Test
    void insertWhenTreeEmpty() {
        Tree t = new SearchTree();
        t.insert( 1 );
        var node = t.find( 1 );
        assertEquals( 1, node.getValue() );
        assertEquals( TreeNode.nill, node.getRight() );
        assertEquals( TreeNode.nill, node.getLeft() );
        assertEquals( TreeNode.nill, node.getParent() );
        assertEquals( 1, t.getSize() );
        assertFalse( t.isEmpty() );
    }

    @Test
    void insertMultipleElementsThenCorrectRelation() {
        Tree t = new SearchTree();
        t.insert( 1 );
        t.insert( 2 );
        t.insert( 0 );
        var node = t.find( 1 );
        var left = node.getLeft();
        var right = node.getRight();

        assertEquals( TreeNode.nill, node.getParent() );
        assertEquals( 3, t.getSize() );

        // Left node properties
        assertEquals( 0, left.getValue() );
        assertEquals( TreeNode.nill, left.getRight() );
        assertEquals( TreeNode.nill, left.getLeft() );
        assertEquals( node.getValue(), left.getParent().getValue() );

        // Right node properties
        assertEquals( 2, right.getValue() );
        assertEquals( TreeNode.nill, right.getRight() );
        assertEquals( TreeNode.nill, right.getLeft() );
        assertEquals( node.getValue(), right.getParent().getValue() );
    }

    @Test
    void delete() {
    }
}
