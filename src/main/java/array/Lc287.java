package array;

import java.util.Arrays;

public class Lc287 {

    public int findDuplicate(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }

        return -1;

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,9,6,9,3,8,9,7,1};
        int len = new Lc287().findDuplicate(arr);
//        System.out.println(len);
//        System.out.println(Arrays.toString(arr));

    }
}
