package array.slidingWindow;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 滑动窗口
 */
public class Lc209 {

    // target = 7, nums = [2,3,1,2,4,3]
    public int minSubArrayLen(int target, int[] nums) {

        int l = 0 ,r = -1;
        int sum = 0,length = nums.length+1;
        while (l < nums.length){

            if(sum < target && r < nums.length-1){
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if(sum >= target){
                length = Math.min(length,r - l + 1);
            }

        }
        if(length == nums.length+1){
            return 0;
        }
        return length;

    }

    public static void main(String[] args) {
        int[] num = new int[]{2,3,1,2,4,3};
        int length = new Lc209().minSubArrayLen(7,num);
        System.out.println(length);
    }

}
