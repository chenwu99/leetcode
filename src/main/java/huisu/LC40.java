package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class LC40 {

    private List<Integer> tmpList = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] visited = new boolean[256];

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumDfs(0,candidates, target, 0);
        return res;
    }

    private void combinationSumDfs(int start, int[] candidates, int target, int curSum) {

        if (curSum == target) {
            res.add(new ArrayList<>(tmpList));
            return;
        } else {
            if(curSum > target){
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if(i > 0 && !visited[i - 1] && candidates[i - 1] == candidates[i]){
                    continue;
                }
                visited[i] = true;
                tmpList.add(candidates[i]);
                combinationSumDfs(i + 1, candidates, target, curSum + candidates[i]);
                visited[i] = false;
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> res = new LC40().combinationSum2(nums, 8);
        System.out.println(res.toString());
    }
}
