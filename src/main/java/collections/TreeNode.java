package collections;

public class TreeNode {
    public static final TreeNode nill = new TreeNode();

    private Integer value;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    private TreeNode() {
        left = null;
        right = null;
        parent = null;
        value = null;
    }

    public TreeNode( int value, TreeNode left, TreeNode right, TreeNode parent ) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public TreeNode( int value ) {
        this( value, nill, nill, nill );
    }

    public void setLeft( TreeNode left ) {
        this.left = left;
    }

    public void setRight( TreeNode right ) {
        this.right = right;
    }

    public void setParent( TreeNode parent ) {
        this.parent = parent;
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

    public TreeNode getParent() {
        return parent;
    }
}
