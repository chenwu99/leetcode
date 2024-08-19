package array.test;

import java.util.ArrayList;
import java.util.List;

public class Test12 {

    public List<Integer> getDiff(int[] nums1, int[] nums2) {

        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    res.add(nums1[i]);
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    j++;
                }
            }
        }
        //
        if (nums1.length > nums2.length) {
            for (int i = j + 1; i < nums1.length; i++) {
                res.add(nums1[i]);
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int[] num1 = new int[]{1, 4, 5, 6, 7};
        int[] num2 = new int[]{1, 3, 4, 5};
        List<Integer> res = new Test12().getDiff(num1, num2);
        System.out.println(res.toString());
    }
}
