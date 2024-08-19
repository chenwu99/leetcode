package binaryTreeNode.test;

import binaryTreeNode.TreeNode;

public class LC222 {
    private Integer sum = 0;
    private Integer res = 0;

    public int countNodes(TreeNode root) {
        kth(root);
        return res;
    }

    private void kth(TreeNode root) {

        if(null == root){
            return;
        }
        kth(root.left);
        res ++;
        kth(root.right);
    }
}
