package binaryTreeNode;

public class LC112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(null == root){
            return false;
        }
        if(targetSum - root.val == 0 && (root.left == null && root.right == null)){
            return true;
        }
       return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
