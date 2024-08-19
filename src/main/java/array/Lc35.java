package array;

/**
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 */
public class Lc35 {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        int res = 0;
        while (l < r) {
            int middle = (l + r) / 2;
            if(nums[middle] > target){
                r = middle - 1;
            } else if(nums[middle] < target){
                l = middle + 1;
            } else {
                res = middle;
                break;
            }
        }
        return res;
    }
}
