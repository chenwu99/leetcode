package array.slidingWindow;

public class Lc16 {


    //  s = "abcabcbb"
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];
        int l = 0 ,r = -1;
        int length = -1;
        char[] chars = s.toCharArray();
        while (l < chars.length){

            // [l,r] 没有重复字符;
            if(r+1 < chars.length && freq[chars[r+1]] == 0){
                r++;
                freq[chars[r]] ++;
                length = Math.max(length,r-l+1);
            }else{ // 出现重复；
                freq[chars[l]] --;
                l ++;
            }
        }
        return length;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = new Lc16().lengthOfLongestSubstring(s);
        System.out.println(length);
    }



}
