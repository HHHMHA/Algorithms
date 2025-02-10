package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeNode {
    public static final TreeNode nill = new TreeNode();

    private final Integer value;
    private TreeNode left, right, parent;
    private final List<NodeProperty> properties = new ArrayList<>();

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

    /**
     * Assumes NodeProperty implementations check for correct class in equals method
     *
     * @param value the value to check if it exists in one of the properties
     * @return What do you think this will return bro!
     */
    public boolean hasPropertyValue(NodeProperty value) {
        return this.properties.stream().anyMatch(e -> e.equals(value));
    }

    public void setProperty(NodeProperty property) {
        this.properties.removeIf(p -> p.getClass() == property.getClass());
        this.properties.add(property);
    }
}
