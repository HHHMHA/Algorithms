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
        if (uncle == TreeNode.nill) return;

        // Case 1 Uncle and parent red
        if (uncle.hasPropertyValue(ColoredNode.Red()) && parent.hasPropertyValue(ColoredNode.Red())) {
            uncle.setProperty(ColoredNode.Black());
            parent.setProperty(ColoredNode.Black());
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
