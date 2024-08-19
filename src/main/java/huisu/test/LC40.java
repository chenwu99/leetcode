package huisu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * // 1. 排序目的：为了判断在输出结果的集合里不会出现重复；
 *    2. 判断重复：一种是判断同层是否相同；
 *    3. 剪枝:
 *      index,
 *      还有判断sum > target
 */
public class LC40 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmpList = new ArrayList<>();
    boolean[] visited = new boolean[256];

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, 0);
        return res;
    }

    private void combinationSum2(int[] candidates, int target, int sum, int index) {

        if (sum == target) {
            res.add(new ArrayList<>(tmpList));
        } else {
            if (sum > target) {
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (i > 0 && !visited[i - 1] && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                visited[i] = true;
                tmpList.add(candidates[i]);
                System.out.println(tmpList.toString() + " " + sum);
                combinationSum2(candidates, target, sum + candidates[i], i + 1);
                visited[i] = false;
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) { // 1,1,2,5,6,7,10
        int[] nums = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> res = new LC40().combinationSum2(nums, 8);
        System.out.println("结果 "+res.toString());
    }
}
