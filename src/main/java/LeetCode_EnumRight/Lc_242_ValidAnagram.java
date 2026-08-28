package LeetCode_EnumRight;

public class Lc_242_ValidAnagram {

    class Solution {
        public boolean isAnagram(String s, String t) {
            // 长度不同直接排除（缺字母/多字母）
            if (s.length() != t.length()) {
                return false;
            }
            int[] count = new int[26];
            // 一加：统计 s 每个字符
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            // 一减：用 t 抵消
            for (int i = 0; i < t.length(); i++) {
                count[t.charAt(i) - 'a']--;
            }
            // 全 0 才是异位词
            for (int c : count) {
                if (c != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
