package leetcode.editor.cn;

import java.util.*;

public class ValidAnagram {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] alphabet = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                alphabet[c - 'a']++;
            }

            for (int j = 0; j < t.length(); j++) {
                char c = t.charAt(j);
                alphabet[c - 'a']--;
            }

            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] != 0) {
                    return false;
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        // put your test code here
        testExample1();
        testExample2();
    }

    public static void testExample1() {
        Solution solution = new ValidAnagram().new Solution();
        String s = "anagram";
        String t = "nagaram";
        boolean result = solution.isAnagram(s, t);
        System.out.println("result = " + result);
    }

    public static void testExample2() {
        Solution solution = new ValidAnagram().new Solution();
        String s = "rat";
        String t = "car";
        boolean result = solution.isAnagram(s, t);
        System.out.println("result = " + result);
    }
}