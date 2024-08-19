package array;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 输入：nums = [1,1,2]
 输出：2, nums = [1,2,_]
 */
public class LC26 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]){
                 nums[k] = nums[i];
                 k ++;
            }
        }
        return k;
    }
}
