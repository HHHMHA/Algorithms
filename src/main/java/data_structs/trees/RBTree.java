package data_structs.trees;


import data_structs.trees.node.ColoredNode;

public class RBTree extends SearchTree {
    @Override
    public void insert(int element) {
        if (isDuplicate(element)) {
            return;
        }

        var node = new TreeNode(element);

        if (isEmpty()) {
            root = node;
            node.setProperty(ColoredNode.Black());
            ++size;
            return;
        }

        ++size;
        // Case 0 no violations
        TreeNode parent = getNewParent(element);

        setParent(node, parent);
        node.setProperty(ColoredNode.Red());

        var uncle = node.getUncle();

        // Case 1 Uncle and parent red
        if (uncle != TreeNode.nill && uncle.hasPropertyValue(ColoredNode.Red()) && parent.hasPropertyValue(ColoredNode.Red())) {
            uncle.setProperty(ColoredNode.Black());
            parent.setProperty(ColoredNode.Black());
            // TODO: recursive case and color grand parent red (will implement when I reach the test)
            return;
        }

        // Case 2: Left-Right
        TreeNode grandparent = parent.getParent();
        if (grandparent == TreeNode.nill) {
            return; // No grandparent, so no further fix-up needed now
        }
        // Case 2: Left-Right (triangle)
        if (parent == grandparent.getLeft() && node == parent.getRight()) {
            leftRotate(parent); // Turn it into Left-Left
            node = node.getLeft(); // After rotation, new current node
        }

        // Case 2 (continued): Left-Left
        if (node.getParent() == grandparent.getLeft()) {
            rightRotate(grandparent);

            TreeNode newRoot = node.getParent();
            newRoot.setProperty(ColoredNode.Black());
            newRoot.getLeft().setProperty(ColoredNode.Red());
            newRoot.getRight().setProperty(ColoredNode.Red());

            if (grandparent == root) {
                root = newRoot;
            }
        }
    }
//
//
//    @Override
//    public TreeNode delete(int element) {
//        if (isEmpty()) {
//            return TreeNode.nill;
//        }
//
//        TreeNode nodeToDelete = find(element);
//        if (nodeToDelete == TreeNode.nill) {
//            return TreeNode.nill;
//        }
//
//        TreeNode parent = nodeToDelete.getParent();
//
//        // Case 1: Node to delete is a leaf node
//        if (nodeToDelete.getLeft() == TreeNode.nill && nodeToDelete.getRight() == TreeNode.nill) {
//            if (parent == TreeNode.nill) {
//                root = TreeNode.nill;
//            } else if (parent.getLeft() == nodeToDelete) {
//                parent.setLeft(TreeNode.nill);
//            } else {
//                parent.setRight(TreeNode.nill);
//            }
//        }
//        // Case 2: Node to delete has only one child
//        else if (nodeToDelete.getLeft() == TreeNode.nill || nodeToDelete.getRight() == TreeNode.nill) {
//            TreeNode child = (nodeToDelete.getLeft() != TreeNode.nill) ? nodeToDelete.getLeft() : nodeToDelete.getRight();
//
//            if (parent == TreeNode.nill) {
//                root = child;
//            } else if (parent.getLeft() == nodeToDelete) {
//                parent.setLeft(child);
//            } else {
//                parent.setRight(child);
//            }
//            child.setParent(parent);
//        }
//        // Case 3: Node to delete has two children
//        else {
//            TreeNode successor = successor(nodeToDelete);
//
//            if (successor.getRight() != TreeNode.nill) {
//                successor.getRight().setParent(successor.getParent());
//            }
//            successor.setLeft(nodeToDelete.getLeft());
//            if (nodeToDelete.getRight() != successor) {
//                successor.setRight(nodeToDelete.getRight());
//            }
//            successor.setParent(parent);
//            if (parent == TreeNode.nill) {
//                root = successor;
//            }
//            if (parent.getRight() == nodeToDelete) {
//                parent.setRight(successor);
//            }
//            if (parent.getLeft() == nodeToDelete) {
//                parent.setLeft(successor);
//            }
//        }
//
//        size--;
//        return nodeToDelete;
//    }
}
