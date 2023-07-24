package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    /**
     * lc26
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 元素的 相对顺序 应该保持 一致。
     *
     * @param nums
     * @return 返回 nums 中唯一元素的个数
     */
    public int removeDuplicates(int[] nums) {

        int k = 1;
        int deleteNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] != nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * lc27
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等va的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length < 0) {
            return 0;
        }
        int k = -1;
        int flag = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && flag == 0) {
                k = i;
                flag = 1;
            }
            if (k != -1 && nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        if (k == -1) {
            return nums.length;
        }
        return k;
    }

    // 3 2 2 3 /3

    //l r

    // 2 2 2 3

    // idx , i

    public int removeElement2(int[] nums, int val) {
        int idx = 0;
        int i = 0;

        while(i< nums.length ) {
            if(nums[i] != val) {
                if(idx ==  i ) {
                    i++;
                } else {
                    swap(nums, i, idx);
                    idx++;
                }
            } else {
                i++;
            }

        }
        return idx;

    }
        public int removeElement3(int[] nums, int val) {
            int n = nums.length;
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] != val) {
                    swap(nums,i,idx);
                    idx++;
                }
            }
            return idx;
        }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,1,2,3,3};
        int len = new BinarySearch().removeDuplicates(arr);
//        System.out.println(len);
//        System.out.println(Arrays.toString(arr));

    }
}
