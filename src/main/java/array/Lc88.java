package array;

import java.util.Arrays;

/**
 * 双撞指针
 */
public class Lc88 {

    /**
     *  两个按 非递减顺序 排列的整数数组
     *  输入：nums1 = [1,2,7,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     *  输出：[1,2,2,5,6,7]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(m <= 0 && n != 0){
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return ;
        }
        if(m != 0 && n <= 0){
            return;
        }
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            if(j >= nums2.length){
                return;
            }
            if(nums1[i] < nums2[j]){
                i++;
            }
            if(nums1[i] == nums2[j]){
                swap(nums1,i,m+j);
                i++;
                j++;
            }
            if(nums1[i] > nums2[j]){
                swap(nums1,i,m+j);
                nums1[i] = nums2[j];
                j++;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,7,0,0,0};
        int[] num2 = new int[]{2,5,6};
        new Lc88().merge(num1,3,num2,3);
        System.out.println(Arrays.toString(num1));
    }

}
