package binaryTreeNode.test;

import binaryTreeNode.TreeNode;

import javax.tools.Tool;

public class LC404 {

    private Integer sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        if(null == root){
            return 0;
        }
        if(null != root.left && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }

    private int sumOfLeft(TreeNode root) {

        if(null == root){
            return 0;
        }
        sumOfLeft(root.left);
        sumOfLeft(root.right);
        return sum;
    }
}
