package LeetCode_Stack;

import java.util.Stack;

public class Lc_20_ValidParentheses {

    class Solution {
        /**
         * 词汇表：
         * - 压栈（把元素放到栈顶） → stack.push(e)
         * - 弹栈（取走并返回栈顶） → stack.pop()
         * - 看栈顶（只看不取） → stack.peek()
         * - 栈是否为空 → stack.isEmpty()
         * - 左括号压入「对应的右括号」 → 匹配时只需 stack.pop() != c 一句搞定
         *
         * 一刷（9.1）踩坑：
         * 1. 开头 if (stack.isEmpty()) return false —— 放错位置；栈刚建当然空，判空应在右括号分支和循环结束
         * 2. 左括号用 peek() —— 回答反了；左括号该 push，peek 是给右括号匹配用的
         * 3. 重写时把 return stack.isEmpty() 写成 return true —— 被 "[" 用例抓住
         * 结论：判空只有两个位置——遇到右括号时（空→false）、循环结束后（非空→false）。
         */
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
