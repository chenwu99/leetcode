package array.test;

import java.util.Arrays;

public class LC80 {

    /**
     * nums = [0,0,1,1,1,1,2,3,3]
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        //end结尾代表的数组是满足要求的
        int end = 0;
        for(int n : nums) {
            if(end < 2 || n != nums[end-2]) {
                nums[end++] = n;
            }
        }
        return end;

    }

    public static void main(String[] args) {

        int[] num2 = new int[]{0,1,1,1,1,2,3,3};
        int k = new LC80().removeDuplicates(num2);
        System.out.println(Arrays.toString(num2) + k);
    }
}
