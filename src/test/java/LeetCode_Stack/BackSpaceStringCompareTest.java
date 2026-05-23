package LeetCode_Stack;

import org.junit.Test;

public class BackSpaceStringCompareTest {
    /*
        示例 1：
        输入：s = "ab#c", t = "ad#c"
        输出：true
        解释：s 和 t 都会变成 "ac"。

        示例 2：
        输入：s = "ab##", t = "c#d#"
        输出：true
        解释：s 和 t 都会变成 ""。

        示例 3：
        输入：s = "a#c", t = "b"
        输出：false
        解释：s 会变成 "c"，但 t 仍然是 "b"。
    */

    @Test
    public void backspaceCompare01() {
        String s = "ad#c", t = "ad#c";
        boolean result = BackSpaceStringCompare.backspaceCompare(s, t);
        System.out.println("result = " + result);
    }

    @Test
    public void backspaceCompare02() {
        String s = "ab##", t = "c#d#";
        boolean result = BackSpaceStringCompare.backspaceCompare(s, t);
        System.out.println("result = " + result);
    }

    @Test
    public void backspaceCompare03() {
        String s = "a#c", t = "b";
        boolean result = BackSpaceStringCompare.backspaceCompare(s, t);
        System.out.println("result = " + result);
    }
}