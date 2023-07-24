package array;

import java.util.ArrayList;
import java.util.List;

public class Lc80 {

    public static int removeDuplicates1(int[] nums) {
        int left = 0;

        int repeatnum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] != nums[i]) {
                repeatnum = 1;
                res.add(nums[i]);
            }else{
                repeatnum ++;
                if(repeatnum <= 2){
                    res.add(nums[i]);
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }
        System.out.println(res.toString());
        return left;
    }

    /**
     * 快指针 与 慢指针的前两个做对比；
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {

        if(nums.length <= 2){
            return nums.length;
        }
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[k - 2] != nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;

    }

}
