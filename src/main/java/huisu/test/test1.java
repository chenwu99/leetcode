package huisu.test;

import java.util.Arrays;

public class test1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // write your code here.
        int k = m -1;
        int j = n -1;
        for(int i = nums1.length -1; i >=0; i --){
            if (k < 0) {
                nums1[i] = nums2[j];
                j --;
            } else if (j < 0) {
                break;
            } else if (nums1[k] < nums2[j]) {
                nums1[i] = nums2[j];
                j --;
            } else if (nums1[k] >= nums2[j]) {
                nums1[i] = nums1[k];
                k --;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        new test1().merge(nums1, 1, nums2 , 1);
        System.out.println(Arrays.toString(nums1));
    }
}
