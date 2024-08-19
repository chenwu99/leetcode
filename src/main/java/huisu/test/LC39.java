package huisu.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 */
public class LC39 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmpList = new ArrayList<>();
    boolean[] visited = new boolean[256];

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumDfs(0, candidates, target, 0);
        return res;
    }

    private void combinationSumDfs(int index, int[] candidates, int target, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(tmpList));
        } else {
            if(sum > target){
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                tmpList.add(candidates[i]);
                System.out.println(tmpList.toString() + " " + sum);
                combinationSumDfs(i , candidates, target, sum + candidates[i]);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
        List<List<Integer>> res = new LC39().combinationSum(nums, 7);
        System.out.println("结果 "+res.toString());
    }

}
