package binaryTreeNode.层次遍历;

import binaryTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC637 {


    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0.00;

            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();

                sum += node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
            res.add(Double.valueOf(sum / queue.size()));
        }
        return res;

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null == root){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();

                list.add(node.val);
                if(null != node.left){
                    queue.offer(node.left);
                }
                if(null != node.right){
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
