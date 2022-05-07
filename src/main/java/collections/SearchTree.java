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
        return null;
    }

    @Override
    public TreeNode max( TreeNode node ) {
        return null;
    }

    @Override
    public TreeNode min() {
        return null;
    }

    @Override
    public TreeNode min( TreeNode node ) {
        return null;
    }

    @Override
    public TreeNode successor( TreeNode node ) {
        return null;
    }

    @Override
    public TreeNode predecessor( TreeNode node ) {
        return null;
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