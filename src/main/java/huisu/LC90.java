package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集
 * （幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class LC90 {

    private boolean[] visited = new boolean[256];

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        split(0, nums, new ArrayList<>(),res);
        return res;
    }

    public void split(int index, int[] nums, List<Integer> tmpList,List<List<Integer>> res) {
        res.add(new ArrayList<>(tmpList));
        for (int i = index; i < nums.length; i ++) {
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            visited[i] = true;
            tmpList.add(nums[i]);
            split(i + 1, nums, tmpList,res);
            visited[i] = false;
            tmpList.remove(tmpList.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new LC90().subsetsWithDup(nums));
    }
}
