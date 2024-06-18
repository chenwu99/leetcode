package binaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {
    /**
     * 前序遍历，栈实现思路， 输出顺序 根、左、右
     * a. 根节点入栈，右孩子入栈，左孩子入栈；
     * b. 根出栈，直到栈中元素不为空
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode rootNode = stack.pop();
            if(rootNode == null){
                break;
            }
            res.add(rootNode.val);
            if(rootNode.right != null){
                stack.push(rootNode.right);
            }
            if(rootNode.left != null){
                stack.push(rootNode.left);
            }
        }
        return res;

    }

    /**
     * 思路同上，输出顺序 左、根、右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        if (root == null) return res;
        stack.push("WHITE");
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = (TreeNode) stack.pop();
            String color = (String) stack.pop();
            if (node == null)
                continue;
            if (color == "WHITE") {
                stack.push("WHITE");
                stack.push(node.right);
                stack.push("GRAY");
                stack.push(node);
                stack.push("WHITE");
                stack.push(node.left);
            } else {
                res.add(node.val);
            }
        }
        return res;
    }
}
