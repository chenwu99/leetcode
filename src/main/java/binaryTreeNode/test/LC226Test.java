package binaryTreeNode.test;

import binaryTreeNode.TreeNode;

public class LC226Test {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }


    public TreeNode invertTree1(TreeNode root) {

        if (null == root) {
            return null;
        }
        Integer leftVal = null;
        if(null != root.left){
            leftVal = root.left.val;
        }
        if (null != root.right && null != root.right) {
            root.left.val = root.right.val;
            root.right.val = root.left.val;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
