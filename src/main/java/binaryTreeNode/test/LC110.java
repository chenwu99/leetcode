package binaryTreeNode.test;

import binaryTreeNode.TreeNode;

public class LC110 {
    public boolean isBalanced(TreeNode root) {

        if(null == root){
            return true;
        }
        if(Math.abs(getTreeLength(root.left) - getTreeLength(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);


    }

    private Integer getTreeLength(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Integer leftLength = getTreeLength(root.left) + 1;
        Integer rightLength = getTreeLength(root.right) + 1;
        return Math.max(leftLength, rightLength);

    }
}
