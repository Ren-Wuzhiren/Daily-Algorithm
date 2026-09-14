package leetcode.editor.cn;

import java.util.*;

public class ValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
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
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // put your test code here
        testExample1();
        testExample2();
        testExample3();
        testExample4();
        testExample5();
    }

    public static void testExample1() {
        Solution solution = new ValidParentheses().new Solution();
        String s = "()";
        boolean result = solution.isValid(s);
        System.out.println("result = " + result);
    }

    public static void testExample2() {
        Solution solution = new ValidParentheses().new Solution();
        String s = "()[]{}";
        boolean result = solution.isValid(s);
        System.out.println("result = " + result);
    }

    public static void testExample3() {
        Solution solution = new ValidParentheses().new Solution();
        String s = "(]";
        boolean result = solution.isValid(s);
        System.out.println("result = " + result);
    }

    public static void testExample4() {
        Solution solution = new ValidParentheses().new Solution();
        String s = "([])";
        boolean result = solution.isValid(s);
        System.out.println("result = " + result);
    }

    public static void testExample5() {
        Solution solution = new ValidParentheses().new Solution();
        String s = "([)]";
        boolean result = solution.isValid(s);
        System.out.println("result = " + result);
    }
}