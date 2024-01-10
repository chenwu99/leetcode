package array;

import java.util.Arrays;

/**
 * 三路排序
 */
public class Lc75 {

    /**
     * 一个数组中，有0、1、2这三个数；请对这三个数进行排序；
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < nums.length;) {// num[zero,two];
            if(nums[i] == 0){// num[0,zero]
                zero ++;
                swap(nums,i,zero);
                i++;
            }else if(nums[i] == 1){// num[zero + 1,two]
                i++;
            }else {// num[two,size-1]
                if(nums.length == i || two <= i){
                    return;
                }
                two--;
                swap(nums,i,two);
            }
        }
    }

    // {1,0,2,0,2,1,2};
    public void sort(int[] nums){
        int zero = -1; //nums[0,zero]
        int two = nums.length; // nums[two,num.length-1]
        for (int i = 0; i < nums.length;) {// num[zero,two];
            if(nums[i] == 0){
                zero++;
                swap(nums, zero, i);
                i++;
            } else if(nums[i] == 1){
                i++;
            } else {
                if(nums.length >= i || two <= i){
                    return;
                }
                two--;
                swap(nums,two,i);
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,0,2,0,2,1,2};
        new Lc75().sortColors(num);
        System.out.println(Arrays.toString(num));
    }
}
