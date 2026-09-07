import java.util.Stack;

public class Review_20_ValidParentheses {

    class Solution {
        /**
         * 复习重写 · 2026-09-07 · 第 3 轮（目标：无提示独立 AC）
         * 上一轮状态：🟡 提示后 AC（3/7 天档续）
         */
        public boolean isValid(String s) {
            // TODO: 在此实现（无提示）
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '{') {
                    stack.push('}');
                } else if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
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

