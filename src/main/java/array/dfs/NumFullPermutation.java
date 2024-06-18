package array.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumFullPermutation {

    public List<List<Integer>> get(Integer num){

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            Map<Integer,Boolean> isVisited = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(i);
            for (int j = i; j <= num; j++) {
                if (null == isVisited.get(j)) {
                    list.add(j);
                    isVisited.put(j, true);
                } else {
                    list.add(j);
                    isVisited.put(j, true);
                }

            }

        }
        return res;
    }
    public static void main(String[] args) {

    }
}
