package array.slidingWindow;

/**
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
