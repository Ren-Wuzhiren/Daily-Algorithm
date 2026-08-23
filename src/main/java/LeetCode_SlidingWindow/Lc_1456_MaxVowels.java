package LeetCode_SlidingWindow;

import java.util.ArrayList;

public class Lc_1456_MaxVowels {
    /**
     * 给你字符串 s 和整数 k 。
     * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
     * 英文中的 元音字母 为（a, e, i, o, u）。
     *
     * 示例 1：
     *
     * 输入：s = "abciiidef", k = 3
     * 输出：3
     * 解释：子字符串 "iii" 包含 3 个元音字母。
     *
     * 示例 2：
     *
     * 输入：s = "aeiou", k = 2
     * 输出：2
     * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
     *
     * 示例 3：
     *
     * 输入：s = "leetcode", k = 3
     * 输出：2
     * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
     *
     * 示例 4：
     *
     * 输入：s = "rhythms", k = 4
     * 输出：0
     * 解释：字符串 s 中不含任何元音字母。
     *
     * 示例 5：
     *
     * 输入：s = "tryhard", k = 4
     * 输出：1
     * 提示：
     *
     * 1 <= s.length <= 10^5
     * s 由小写英文字母组成
     * 1 <= k <= s.length
     */

    /**
     * 算法步骤：
     * 1.初始化 vowel 和 ans 的值
     * 2.右端点进窗口
     * 如果进入的元素是元音字母
     * vowel 自增一次
     * 3.窗口左端点 = 右端点 - 长度 + 1
     * 如果窗口长度不足，就不形成窗口
     * 4.更新答案
     * 5.左端点退出窗口
     * 如果左端点是元音字母
     * vowel 自减一次
     * 6.最后返回 ans
     */

    public int maxVowels(String S, int k) {
        int vowel = 0;
        int ans = 0;

        char[] s = S.toCharArray();
        for (int i = 0; i < s.length; i++) {
            // 右端点进入窗口
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                vowel++;
            }

            // 窗口左端点
            int left = i - k + 1;
            if (left < 0) {
                continue;
            }

            // 更新答案
            ans = Math.max(ans, vowel);

            // 左端点退出窗口
            char out = s[left];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                vowel--;
            }
        }

        return ans;
    }
}
