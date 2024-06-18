package binaryTreeNode;

import java.util.*;

public class LC113 {

    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return res;
        }
        pathSum(root, targetSum);
        return res;
    }

    public void path(TreeNode root, int targetSum) {
        if (null == root) {
            return;
        }
        path.add(root.val);
        if(null == root.left && null == root.right && 0 == targetSum - root.val){
            res.add(new LinkedList<>(path));
            return;
        }
        targetSum -= root.val;
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        path.remove(path.size() - 1);
    }
}
