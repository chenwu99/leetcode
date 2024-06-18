package binaryTreeNode;

public class LC110 {

    public boolean isBalanced(TreeNode root) {
        if(null == root){
            return true;
        }
        if(Math.abs(getLength(root.left) - getLength(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getLength(TreeNode root){
        if(null == root){
            return 0;
        }
        int leftLength = getLength(root.left) + 1;
        int rightLength = getLength(root.right) + 1;
        return Math.max(leftLength , rightLength);
    }

    public static void main(String[] args) {
        System.out.println(false || true);
    }
}
