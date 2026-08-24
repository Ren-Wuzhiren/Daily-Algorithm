package LeetCode_SlidingWindow;

import java.util.HashMap;

public class Lc_3_LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0, ans = 0;
            HashMap<Character, Integer> last = new HashMap<>();
            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                // 不要把 字符串下标 = 左指针 的条件漏掉！（last.get(c) >= left）
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
}
