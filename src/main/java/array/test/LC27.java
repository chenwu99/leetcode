package array.test;


import java.util.Arrays;

public class LC27 {

    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j;) {
            if(nums[i] == val){
                nums[i] = nums[j];
                j --;
            } else {
                i ++;
            }

        }
        return j + 1;

    }

    private void swap(int[] nums1, int m, int n){
        int tmp = nums1[m];
        nums1[m] = nums1[n];
        nums1[n] = tmp;
    }

    public static void main(String[] args) {

        int[] num2 = new int[]{3,2,2,3};
        int k = new LC27().removeElement(num2, 3);
        System.out.println(Arrays.toString(num2) + k);
    }

}
