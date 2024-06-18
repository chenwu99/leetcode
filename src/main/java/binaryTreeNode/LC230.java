package binaryTreeNode;

public class LC230 {

    private int value = 0;
    private int num = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(null == root){
            return 0;
        }
        kthSmallest(root.left, k);
        num ++;
        if(num == k){
            value = root.val;
            return value;
        }
        kthSmallest(root.right, k);
        return value;
    }
}
