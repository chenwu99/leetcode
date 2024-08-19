package binaryTreeNode.test;

import binaryTreeNode.TreeNode;

public class LC101 {
    public boolean isSymmetric(TreeNode root) {

        if(null == root){
            return true;
        }
        return verifySame(root.left, root.right);
    }

    private boolean verifySame(TreeNode left, TreeNode right){
        if(left == null && right != null) {
            return false;
        }
        if(right == null && left != null) {
            return false;
        }
        if(left == null && right == null){
            return true;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                return true;
            }
        }


    }
}
