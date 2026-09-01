package LeetCode_Stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Lc_20_ValidParenthesesTest {

    private final Lc_20_ValidParentheses.Solution solution =
            new Lc_20_ValidParentheses().new Solution();

    @Test
    public void example1() {
        assertTrue(solution.isValid("()"));
    }

    @Test
    public void example2() {
        assertTrue(solution.isValid("()[]{}"));
    }

    @Test
    public void example3() {
        assertFalse(solution.isValid("(]"));
    }

    @Test
    public void example4() {
        assertTrue(solution.isValid("([])"));
    }

    @Test
    public void edgeSingleLeftBracket() {
        // 只有一个左括号，没有配对 → false（9.1 踩坑：return true 漏最后判空）
        assertFalse(solution.isValid("["));
    }

    @Test
    public void edgeSingleRightBracket() {
        // 只有一个右括号，栈空 → false
        assertFalse(solution.isValid(")"));
    }

    @Test
    public void edgeWrongOrder() {
        // 类型对但顺序错
        assertFalse(solution.isValid("([)]"));
    }

    @Test
    public void edgeAllLeftBrackets() {
        assertFalse(solution.isValid("((("));
    }

    @Test
    public void edgeAllRightBrackets() {
        assertFalse(solution.isValid("}}}"));
    }

    @Test
    public void edgeNestedValid() {
        assertTrue(solution.isValid("((()))"));
    }

    @Test
    public void edgeReversedPair() {
        assertFalse(solution.isValid("[}]"));
    }
}
