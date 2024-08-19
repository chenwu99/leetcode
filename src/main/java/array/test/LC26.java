package array.test;

import java.util.Arrays;

public class LC26 {

    public int removeDuplicates(int[] nums) {

        int k = 1;
        for (int i = 1; i < nums.length; i++) {

            if(nums[i] != nums[k-1]){
                nums[k++] = nums[i];
            }
        }
        return k;

    }

    public static void main(String[] args) {

        int[] num2 = new int[]{0,0,1,1,1,2,2,3,3,4,4};
        int k = new LC26().removeDuplicates(num2);
        System.out.println(Arrays.toString(num2) + " " + k);
    }
}
