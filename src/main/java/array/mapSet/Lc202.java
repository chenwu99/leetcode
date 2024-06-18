package array.mapSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc202 {
    public boolean isHappy(int n) {

        List<Integer> nums = getSingleNum(n);
        if(nums.size() == 1 && nums.get(0) == 1){
            return true;
        }

        int res = convertDouble(nums);
        if(res == 1){
            return true;
        }
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            isHappy(n);
        }
        return isHappy(res);

    }


    public int convertDouble(List<Integer> nums){

        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            res += nums.get(i) * nums.get(i);
        }
        return res;
    }

    public List<Integer> getSingleNum(int n){
        List<Integer> nums = new ArrayList<>();
        while(n > 0){
            nums.add(n % 10);
            n = n /10;
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new Lc202().isHappy(19));

    }

}
