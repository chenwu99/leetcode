package binaryTreeNode;

public class LC98 {

    public boolean isValidBST(TreeNode root) {
        if(null == root){
            return true;
        }
        return compare(root,root.val);
    }

    private boolean compare(TreeNode root,int val){
        if(null == root){
            return false;
        }
        if(root.left != null && (root.left.val >= root.val || root.left.val >= val)){
            return false;
        }
        if(root.right != null && (root.right.val <= root.val || root.right.val <= val)){
            return false;
        }
        return compare(root.left,val) && compare(root.right,val);

    }
}
