package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC46、LC47、LC77
 */
public class FullPermutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,  new ArrayList<>(), res);
        return res;
    }

    private int[] visited = new int[256];


    /**
     * 样例输入：
     * [1,1,2]
     * 样例输出：
     * [[1,1,2],[1,2,1],[2,1,1]]
     * @param index
     * @param start
     * @param tempList
     * @param res
     */
    private void backtrack3(int[] nums, int index, int start, List<Integer> tempList, List<List<Integer>> res) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            System.out.println("结果" + tempList.toString());
        } else {
            System.out.println("backtrack3执行" + tempList.toString());
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] != 0){
                    System.out.println("visited is have i = " + i);
                    continue;
                }
                if (i > 0 && nums[i - 1] == nums[i] && visited[i-1] == 0) {
                    System.out.println("same is i  = " + i);
                    continue;
                }
                tempList.add(nums[i]);
                visited[i] = 1;
                System.out.println("加入=" + nums[i] + " i= " + i + " index=" + index);
                backtrack3(nums, index + 1, i + 1, tempList, res);
                System.out.println("回溯" + tempList.get(tempList.size() - 1) + "for中的i=" + i + " index=" + index);
                tempList.remove(tempList.size() - 1);
                visited[i] = 0;
            }
        }
    }

    /**
     * 输入n,k; 如 n = 4,k = 2; 输出 [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
     * @param n
     * @param k
     * @param index
     * @param start
     * @param tempList
     * @param res
     */
    private void backtrack2(int n , int k, int index, int start, List<Integer> tempList, List<List<Integer>> res) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            System.out.println("结果" + tempList.toString());
        } else {
            System.out.println("backtrack2执行" + tempList.toString());
            for (int i = start; i <= n; i++) {
                tempList.add(i);
                System.out.println("加入=" + i + " index=" + index);
                backtrack2(n, k, index + 1, i + 1, tempList, res);
                System.out.println("回溯" + tempList.get(tempList.size() - 1) + "for中的i=" + i + " index=" + index);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> res) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            System.out.println(tempList.toString());
        } else {
            System.out.println("backtrack执行" + tempList.toString());
            for (int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) {
                    continue;
                }
                System.out.println("加入"+nums[i]);
                tempList.add(nums[i]);
                backtrack(nums, tempList, res);
                System.out.println("回溯" + tempList.get(tempList.size() - 1) + "for中的i=" + i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        FullPermutation perm = new FullPermutation();
        perm.backtrack3(nums,1,0,new ArrayList<>(), result);
//        List<List<Integer>> result = perm.permute(nums);
        System.out.println(result);
    }



}
