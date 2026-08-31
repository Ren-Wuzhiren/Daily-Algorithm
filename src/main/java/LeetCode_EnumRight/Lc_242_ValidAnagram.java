package LeetCode_EnumRight;

public class Lc_242_ValidAnagram {

    class Solution {
        /**
         * 词汇表：
         * - 用计数数组当「种类+数量」的账本 → int[] count = new int[26]; count[c - 'a']++;
         * - 第二个字符串来对账 → count[c - 'a']--;
         * - 账本是否清零（全 0 判定） → for (int c : count) if (c != 0) return false;
         *
         * 一刷（8.28）误区：
         * 1. 循环嵌套重复计数 —— 应该一加一减两趟循环，不要嵌套
         * 2. count 声明位置 —— 应声明在方法内、循环外
         * 3. 全 0 判定漏写 —— 只判断了长度，没判断计数是否抵消干净
         * 结论：长度不等直接 false；一加一减两趟循环；最后全 0 校验。
         */
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
