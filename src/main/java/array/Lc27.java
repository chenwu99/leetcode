package array;

/**
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2,_,_]
 */
public class Lc27 {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[k] = nums[i];
                k ++;
            }
        }
        return k;
    }

}
