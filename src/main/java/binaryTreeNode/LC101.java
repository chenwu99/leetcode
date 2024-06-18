package binaryTreeNode;

public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.right) && isSame(p.right, q.left);
    }
}
