// 复习档案 · 2026-09-10 三刷 · 结果：✅ 无提示重写 AC（3min53s，3/7 天档解除，升 7/14 档）
// 一加一减两趟循环 + 全 0 校验全部独立写出；未加长度短路（不影响正确性）
public class Review_242_ValidAnagram {

    class Solution {
        /**
         * 复习重写 · 2026-09-10 · 第 3 轮
         */
        public boolean isAnagram(String s, String t) {
            // 无提示重写：全部凭记忆
            int[] alphabet = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                alphabet[c - 'a']++;
            }

            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
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
}

