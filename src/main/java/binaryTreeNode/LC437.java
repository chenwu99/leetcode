package binaryTreeNode;

public class LC437 {

    public int pathSum(TreeNode root, int targetSum) {
        if(null == root){
            return 0;
        }
        Integer sum = 0;
        return getPath(root, sum, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int getPath(TreeNode root, int sum, long targetSum) {
        if (null == root) {
            return 0;
        }
        targetSum -= root.val;
        if (targetSum == 0) {
            sum ++;
        }
        getPath(root.left, sum, targetSum);
        getPath(root.right, sum, targetSum);
        return sum;
    }

}
