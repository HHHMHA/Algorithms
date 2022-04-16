package collections;

public class TreeNode {
    public static final TreeNode nill = new TreeNode();

    private Integer value;
    private TreeNode left;
    private TreeNode right;

    private TreeNode() {
        left = null;
        right = null;
        value = null;
    }

    public TreeNode( int value, TreeNode next, TreeNode previous ) {
        this.value = value;
        this.left = next;
        this.right = previous;
    }

    public TreeNode( int value ) {
        this( value, nill, nill );
    }

    public void setLeft( TreeNode left ) {
        this.left = left;
    }

    public void setRight( TreeNode right ) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
