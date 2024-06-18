package binaryTreeNode;

public class LC235 {

    private int num = 0;
    private TreeNode node;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root) {
            return null;
        }
        long res = (long) (root.val - p.val) * (root.val - q.val);
        if (res <= 0) {
            return root;
        }
        if (q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

}
