package binaryTreeNode;

public class LC404 {

    private Integer sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(null == root){
            return 0;
        }
        sum(root, sum);
        return sum;
    }

    public void sum(TreeNode root, int sum) {
        if(null == root){
            return;
        }
        TreeNode leftNode = root.left;
        if(null != leftNode && null == leftNode.left && null == leftNode.right){
            sum += leftNode.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
    }


    public static void main(String[] args) {
        System.out.println(new LC404().sumOfLeftLeaves(null));
    }

}
