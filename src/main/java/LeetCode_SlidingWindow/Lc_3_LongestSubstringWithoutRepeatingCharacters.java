package LeetCode_SlidingWindow;

import java.util.HashMap;

public class Lc_3_LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        /**
         * 词汇表：
         * - 记录每个字符「上次出现的位置」 → HashMap<Character, Integer> last = new HashMap<>();
         * - 「这个字符出现过」 → last.containsKey(c)
         * - 左边界收缩到上次出现位置之后 → left = last.get(c) + 1;
         * - 从下标 0..len-1 逐个取字符 → s.charAt(right)
         *
         * 一刷（8.24 默写）误区：
         * 1. 漏掉「last.get(c) >= left」窗口内判断 —— 上次出现位置必须在当前窗口内才收缩
         * 2. 忘 put 键值对 —— last.put(c, right) 是每轮必做的
         * 二刷（8.25）：独立 AC —— 「存在」用 containsKey 表达
         * 结论：containsKey + 窗口内判断；每轮先收缩再更新 last，最后更新答案。
         */
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
