package collections;

import java.util.List;

public interface Tree {
    TreeNode find(int element);

    TreeNode max();

    TreeNode max(TreeNode node);

    TreeNode min();

    TreeNode min(TreeNode node);

    TreeNode successor(TreeNode node);

    TreeNode predecessor(TreeNode node);

    void insert(int element);

    TreeNode delete(int element);

    int getSize();

    default boolean isEmpty() {
        return getSize() == 0;
    }

    List<TreeNode> inorderWalk();

    void leftRotate(TreeNode node);
    void rightRotate(TreeNode node);
}
