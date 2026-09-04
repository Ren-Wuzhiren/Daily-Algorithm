public class Review_242_ValidAnagram {

    class Solution {
        /**
         * 复习重写 · 2026-09-04 · 第 2 轮 · 结果：🟡 L2 提示后 AC（3/7 天档续）
         * 上一轮状态：🟡 提示后 AC（3/7 天档）
         */
        public boolean isAnagram(String s, String t) {
            // 第二轮手写版：计数类型与两趟循环结构经 L2 提示修正
            int[] alphabet = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                alphabet[c1 - 'a']++;
            }

            for (int j = 0; j < t.length(); j++) {
                char c2 = t.charAt(j);
                alphabet[c2 - 'a']--;
            }

            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}

