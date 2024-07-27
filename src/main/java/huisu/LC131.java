package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */
public class LC131 {

    private List<String> tmpList = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        partitionStr(s, 0);
        return res;
    }

    public void partitionStr(String s, int splitIndex) {

        if (splitIndex == s.length()) {
            res.add(new ArrayList<>(tmpList));
        }

        for (int i = splitIndex; i < s.length(); i++) {
            String str = s.substring(splitIndex, i + 1);
            if (verifyPalindromeStr(str)) {
                tmpList.add(str);
                partitionStr(str,  i + 1);
                tmpList.remove(tmpList.size() - 1);
            }

        }
    }

    private boolean verifyPalindromeStr(String s) {

        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new LC131().verifyPalindromeStr("aba"));
        List<List<String>> res = new LC131().partition("aab");
        System.out.println(res.toString());
    }
}
