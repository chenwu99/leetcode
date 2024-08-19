package binaryTreeNode.test;

import binaryTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC437Test {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private Integer sum = 0;
    public int pathSum(TreeNode root, int targetSum) {

        if(null == root){
            return sum;
        }
        caluPath(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return sum;
    }

    private void caluPath(TreeNode root, int targetSum){

        if (null == root || targetSum - root.val < 0) {
            return;
        }
        if (targetSum - root.val == 0) {
            sum ++;
        }
        caluPath(root.left, targetSum - root.val);
        caluPath(root.right, targetSum - root.val);

    }
}
