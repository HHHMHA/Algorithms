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
//        TreeNode parent = getNewParent(element);
//
//        setParent(node, parent);
    }
//
//    // TODO: move to TreeNode
//    private void setParent(TreeNode node, TreeNode parent) {
//        node.setParent(parent);
//        if (parent.getValue() < node.getValue()) {
//            parent.setRight(node);
//        } else {
//            parent.setLeft(node);
//        }
//    }
//
//    private TreeNode getNewParent(int element) {
//        var parent = TreeNode.nill;
//        var target = root;
//        while (target != TreeNode.nill) {
//            parent = target;
//            target = moveTowards(element, target);
//        }
//        return parent;
//    }
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
