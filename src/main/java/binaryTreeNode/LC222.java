package binaryTreeNode;

public class LC222 {
    public int countNodes(TreeNode root) {
        if(null == root){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        System.out.println(left);
        return left + right + 1;
    }

}
