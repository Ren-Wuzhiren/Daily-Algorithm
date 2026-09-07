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
         *
         * 二刷（9.2）踩坑：
         * return true 误放在 for 循环内 —— 第一次迭代就提前宣布成功（"(" 会返回 true）
         * 结论：主体（push 右括号 / 匹配 / 最后判空）独立写对；"成功出口"只在循环结束后 return stack.isEmpty()，循环内不要 return true。
         * 三刷（9.7）独立 AC：5m37s，一次写对主体与最终判空，未再把 return true 放进循环。
         * 结论：复习时先按行为拆分三段：左括号入栈、右括号匹配、遍历结束判空。
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

