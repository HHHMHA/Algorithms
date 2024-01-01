package collections;

public class SearchTree implements Tree {
    private int size = 0;
    private TreeNode root = TreeNode.nill;

    @Override
    public TreeNode find( int element ) {
        var node = root;
        while ( node != TreeNode.nill ) {
            if ( node.getValue() == element ) {
                return node;
            }

            node = moveTowards( element, node );
        }
        return node;
    }

    // TODO: move to TreeNode
    private TreeNode moveTowards( int element, TreeNode node ) {
        return node.getValue() < element ? node.getRight() : node.getLeft();
    }

    @Override
    public TreeNode max() {
        return max( root );
    }

    @Override
    public TreeNode max( TreeNode node ) {
        if ( node == TreeNode.nill )
            return node;

        while ( node.getRight() != TreeNode.nill )
            node = node.getRight();
        return node;
    }

    @Override
    public TreeNode min() {
        return min( root );
    }

    @Override
    public TreeNode min( TreeNode node ) {
        if ( node == TreeNode.nill )
            return node;

        while ( node.getLeft() != TreeNode.nill )
            node = node.getLeft();
        return node;
    }

    @Override
    public TreeNode successor( TreeNode node ) {
        if (node == TreeNode.nill) {
            return TreeNode.nill;
        }

        if ( node.getRight() != TreeNode.nill ) {
            return min( node.getRight() );
        }

        var parent = node.getParent();
        while (parent != TreeNode.nill && parent.getRight() == node) {
            node = parent;
            parent = node.getParent();
        }

        return parent;
    }

    @Override
    public TreeNode predecessor( TreeNode node ) {
        if (node == TreeNode.nill) {
            return TreeNode.nill;
        }

        if ( node.getLeft() != TreeNode.nill ) {
            return min( node.getLeft() );
        }

        var parent = node.getParent();
        while (parent != TreeNode.nill && parent.getLeft() == node) {
            node = parent;
            parent = node.getParent();
        }

        return parent;
    }

    @Override
    public void insert( int element ) {
        if ( isDuplicate( element ) ) {
            return;
        }

        var node = new TreeNode( element );

        if ( isEmpty() ) {
            root = node;
            ++size;
            return;
        }

        ++size;
        TreeNode parent = getNewParent( element );

        setParent( node, parent );
    }

    // TODO: move to TreeNode
    private void setParent( TreeNode node, TreeNode parent ) {
        node.setParent( parent );
        if ( parent.getValue() < node.getValue() ) {
            parent.setRight( node );
        } else {
            parent.setLeft( node );
        }
    }

    private TreeNode getNewParent( int element ) {
        var parent = TreeNode.nill;
        var target = root;
        while ( target != TreeNode.nill ) {
            parent = target;
            target = moveTowards( element, target );
        }
        return parent;
    }

    private boolean isDuplicate( int element ) {
        return find( element ) != TreeNode.nill;
    }

    @Override
    public TreeNode delete( int element ) {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }
}
