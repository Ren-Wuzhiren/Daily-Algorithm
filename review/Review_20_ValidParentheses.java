// 复习档案 · 2026-09-02 二刷 · 结果：🟡 L1 提示后 AC（3/7 天档续）
// 解法已并入 Lc_20_ValidParentheses；本文件保留当次手写版本供回看
import java.util.*;

public class Review_20_ValidParentheses {

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '(') {
                    stack.push(')');
                } else {
                    if (stack.isEmpty() || c != stack.pop()) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
