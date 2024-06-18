package binaryTreeNode;

public class LC111 {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftLength = 0, rightLength = 0;

        if(root.left != null){
            leftLength = minDepth(root.left);
        }
        if(root.right != null){
            rightLength = minDepth(root.right);
        }

        if (leftLength == 0) {
            return rightLength + 1;
        } else if (rightLength == 0) {
            return leftLength + 1;
        } else {
            return Math.min(leftLength, rightLength) + 1;
        }
    }
}
