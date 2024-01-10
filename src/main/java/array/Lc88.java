package array;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
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

        int num = nums1.length;
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
        for (int i = nums1.length-1; i >= 0;) {
            if(j < 0){
                return;
            }
            if(nums1[i-1] < nums2[j]){
                i++;
            }
            if(nums1[i] == nums2[j]){
                swap(nums1, i, m + j);
                i++;
                j++;
            }
            if(nums1[i] > nums2[j]){
                swap(nums1, i, m + j);
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
        int[] num1 = new int[]{1, 2, 7, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        new Lc88().merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }

    public static void moveZeroes1(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j = i + 1;
                swap(nums, i, j);
            }
        }
    }

    public static void moveZeroes2(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[k] = 0;
        }
    }

//    public static void main(String[] args) {
//        int[] num1 = new int[]{1, 0, 7, 0, 9, 10};
//        moveZeroes1(num1);
//        System.out.println(Arrays.toString(num1));
//
//    }

}
