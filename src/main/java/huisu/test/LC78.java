package huisu.test;

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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmpList = new ArrayList<>();
    boolean[] visited = new boolean[256];

    public List<List<Integer>> split1(int[] candidates) {
        split(candidates,  0);
        return res;
    }

    private void split(int[] candidates, int index) {
        res.add(new ArrayList<>(tmpList));
        for (int i = index; i < candidates.length; i++) {
            tmpList.add(candidates[i]);
            split(candidates, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }

    }

    public static void main(String[] args) { // 1,1,2,5,6,7,10
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = new LC78().split1(nums);
        System.out.println("结果 "+res.toString());
    }
}
