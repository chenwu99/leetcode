package binaryTreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC129 {
    // 4 9 7 -> 4 * 10

    private Integer sum = 0;
    private Integer preSum = 0;

    public int sumNumbers(TreeNode root) {
        if(null == root){
            return 0;
        }
        preSum = preSum * 10 + root.val;
        if(root.left == null && root.right == null){
            sum += preSum;
        }
        sumNumbers(root.left);
        sumNumbers(root.right);
        return sum;
    }
}
