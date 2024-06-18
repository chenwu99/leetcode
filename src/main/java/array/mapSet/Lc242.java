package array.mapSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc242 {
    public boolean isAnagram(String s, String t) {
        if(null == s && t == null){
            return true;
        }
        if(null == s || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        int[] integers = new int[26];
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            integers[sChar[i] - 'a'] += 1 ;
        }
        for (int i = 0; i < t.toCharArray().length; i++) {
            if(integers[t.charAt(i) - 'a'] == 0){
                return false;
            }
            integers[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < integers.length; i++) {
            if(integers[i] != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String t = "abcA";
        for (int i = 0; i < t.toCharArray().length; i++) {
            int a = (int)t.charAt(i);
            System.out.println(a);
        }
    }
}
