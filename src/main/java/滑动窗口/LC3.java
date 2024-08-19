package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class LC3 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的,最长 子串的长度。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = s.length() - 1;
        int length = -1;
        if (null == s || "".equals(s)) {
            return 0;
        }
        String str = s.substring(0, 1);
        while (l <= r && r < s.length()) {


            if (verifyRepeatStr(str)) {
                l++;
                str = s.substring(l, r + 1);
            } else {
                length = Math.max(length, r - l + 1);
                r++;
                if (r < s.length()) {
                    str = s.substring(l, r + 1);
                }
            }
        }
        return length;
    }

    private boolean verifyRepeatStr(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for (char sr : s.toCharArray()) {
            if (map.containsKey(sr)) {
                return false;
            }
            map.put(sr, true);
        }
        return true;
    }
}
