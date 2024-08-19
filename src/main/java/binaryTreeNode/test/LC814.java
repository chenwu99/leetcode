package binaryTreeNode.test;

import binaryTreeNode.TreeNode;

public class LC814 {

    public TreeNode pruneTree(TreeNode root) {

        if(null == root){
            return  null;
        }
        return removeNode(root);

    }

    private TreeNode removeNode(TreeNode root) {

        if (null == root) {
            return null;
        }
        if(root.left != null && root.left.val == 0 && root.left == null){
            root.left = null;
        }
        removeNode(root.left);
        if(root.right != null && root.right.val == 0 && root.right == null){
            root.right = null;
        }
        removeNode(root.right);
        return root;
    }
}
