package 双指针;

public class LC125 {

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while(l <= r){
            if(Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[r])){
                return false;
            }
            l ++;
            r --;
        }

        return true;
    }
}
