package binaryTreeNode.test;

import binaryTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC113Test {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(null == root){
            return null;
        }
        caluPath(root, targetSum);
        return res;
    }

    private void caluPath(TreeNode root, int targetSum){

        if (null == root || targetSum - root.val < 0) {
            return;
        }
        path.add(root.val);
        if (targetSum - root.val == 0) {
            res.add(new ArrayList<>(path));
        }
        caluPath(root.left, targetSum - root.val);
        caluPath(root.right, targetSum - root.val);

    }
}
