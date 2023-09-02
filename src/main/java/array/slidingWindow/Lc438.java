package array.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class Lc438 {

    /**
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6] r移动 如果包含变体且没有重复则，r++；如果遇到没有变体，则l++
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {


        List<Integer> res = new ArrayList<>();
        int[] freq = new int[256];
        int l = 0 ,r = -1;
        int length = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i)] ++;
        }
        while (l < chars.length){

            if(r+1 < chars.length && r-l+1 <= 3 && freq[chars[r+1]] == 1){
                freq[chars[++r]]++;
                if(r-l+1 == 3){
                    res.add(l);
                }
            }else{
                if(freq[chars[l]] > 1){
                    freq[chars[l]] --;
                }
                ++l;
                ++r;
            }
        }
        return res;

    }
    public static void main(String[] args) {
        String s = "cbaebabacd",p = "abc";
        List<Integer> res = new Lc438().findAnagrams(s,p);
        System.out.println(res.toString());
    }

}