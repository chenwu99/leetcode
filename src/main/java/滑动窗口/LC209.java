package 滑动窗口;

/**
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class LC209 {


    public int minSubArrayLen(int target, int[] nums) {

        int l = 0;
        int r = 0;
        int sum = nums[l];

        int length = Integer.MAX_VALUE;
        while (l <= r && r < nums.length) {
            if (sum >= target) {
                length = Math.min(length, r - l + 1);
                sum -= nums[l];
                l++;
            } else {
                r++;
                if (r < nums.length) {
                    sum += nums[r];
                }
            }
        }
        return length == Integer.MAX_VALUE ? 0: length;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        int len = new LC209().minSubArrayLen(target, nums);
        System.out.println(len);

    }
}
