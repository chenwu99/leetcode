package binaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC257 {

    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return null;
        }
        getIntegerList(root, "");
        return result;

    }

    public void getIntegerList(TreeNode root, String str){
        if(root == null){
            return;
        }
        StringBuilder sb = new StringBuilder(str);
        if(root.left == null && root.right == null){
            sb.append(root.val);
            result.add(sb.toString());
            System.out.println(sb);
            return;
        }
        String temp = sb.append(root.val).append("->").toString();
        getIntegerList(root.left, temp);
        getIntegerList(root.right, temp);
    }
}
