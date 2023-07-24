package array;

public class Lc283 {

    public void moveZeroes(int[] nums) {

        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                swap(nums,i,idx);
                idx ++;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
