package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class LC78 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        split(0, nums, new ArrayList<>(),res);
        return res;
    }

    public void split(int index, int[] nums, List<Integer> tmpList,List<List<Integer>> res) {
        res.add(new ArrayList<>(tmpList));
        System.out.println("结果 i = " + tmpList.toString());

        for (int i = index; i < nums.length; i ++) {
            tmpList.add(nums[i]);
            split(i + 1, nums, tmpList,res);
            tmpList.remove(tmpList.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2,3};
        LC78 perm = new LC78();
        perm.subsets(nums);
    }


}
