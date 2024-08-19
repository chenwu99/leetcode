package binaryTreeNode.test;

import binaryTreeNode.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 */
public class LC230 {

    private Integer sum = 0;
    private Integer res = 0;

    public int kthSmallest(TreeNode root, int k) {
        kth(root,k);
        return res;
    }

    private void kth(TreeNode root, int k) {

        if(null == root){
            return;
        }
        kth(root.left,k);
        System.out.println(root.val);
        kth(root.right,k);
    }
}
