package array.test;

import java.util.Arrays;

/**
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */
public class LC88Test {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int j = n - 1;
        int k = m -1;
        int i = m + n - 1;
        while (j >= 0) {
            if (k == -1) {
                nums1[i] = nums2[j];
                j --;
            } else if (nums2[j] >= nums1[k]) {
                nums1[i] = nums2[j];
                j --;
            } else if (nums2[j] < nums1[k]) {
                nums1[i] = nums1[k];
                k --;
            }
            i --;
        }

    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        int j = n - 1;
        int k = m -1;
        for (int i = m - 1; i < nums1.length; i++) {

        }

    }

    private void swap(int[] nums1, int m, int n){
        int tmp = nums1[m];
        nums1[m] = nums1[n];
        nums1[n] = tmp;
    }

    public static void main(String[] args) {

        int[] num1 = new int[]{2,2,3,0,0,0};
        int[] num2 = new int[]{1,5,6};
        new LC88Test().merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }



}
