package binaryTreeNode;

public class LC236 {
    /**
     * 当前节点的左、右子树中，存在p 或 q;
     * 则返回
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null){
            return null;
        } else if(left != null && right != null){
            return root;
        } else if(left == null){
            return right;
        } else if(right == null){
            return left;
        }
        return null;
    }
}
