package binaryTreeNode;

import java.util.Comparator;

public class LC104 {


    public int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        int leftLength = maxDepth(root.left) + 1;
        int rightLength = maxDepth(root.right) + 1;
        System.out.println(maxDepth(root));
        return Math.abs(leftLength - rightLength);
    }

    public static void main(String[] args) {
        System.out.println(Math.abs(-2));
    }

}
