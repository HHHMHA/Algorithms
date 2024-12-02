package collections;

import java.util.Objects;

public class TreeNode {
    public static final TreeNode nill = new TreeNode();

    private final Integer value;
    private TreeNode left, right, parent;

    private TreeNode() {
        left = null;
        right = null;
        parent = null;
        value = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right, TreeNode parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public TreeNode(int value) {
        this(value, nill, nill, nill);
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setParent(TreeNode parent) {
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

    @Override
    public String toString() {
        return "TreeNode{" + "value=" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(value, treeNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean isRightChild() {
        parent = this.getParent();
        if (parent == TreeNode.nill) return false;

        return parent.getRight().equals(this);
    }

    public boolean isLeftChild() {
        parent = this.getParent();
        if (parent == TreeNode.nill) return false;

        return parent.getLeft().equals(this);
    }

    public boolean isChild(TreeNode childNode) {
        return this != TreeNode.nill && childNode != TreeNode.nill && (childNode.equals(this.getLeft()) || childNode.equals(this.getRight()));
    }
}
