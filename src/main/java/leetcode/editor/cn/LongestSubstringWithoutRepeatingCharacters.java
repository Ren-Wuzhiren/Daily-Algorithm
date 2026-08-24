package leetcode.editor.cn;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0, ans = 0;
            HashMap<Character, Integer> last = new HashMap<>();
            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                // 不要把 字符串下标 = 左指针 的条件漏掉！
                if (last.containsKey(c) && last.get(c) >= left) {
                    left = last.get(c) + 1;
                }
                // 不要忘记追加键值对！
                last.put(c, right);
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // put your test code here
        testExample1();
        testExample2();
        testExample3();
    }

    public static void testExample1() {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("result = " + result);
    }

    public static void testExample2() {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "bbbbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("result = " + result);
    }

    public static void testExample3() {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "pwwkew";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("result = " + result);
    }
}