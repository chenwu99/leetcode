package binaryTreeNode;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {

        if (null == root) {
            return null;
        }
        if (null != root.left && null != root.right) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
