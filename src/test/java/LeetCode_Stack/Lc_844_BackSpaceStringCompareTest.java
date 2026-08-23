package LeetCode_Stack;

import org.junit.Test;

import static LeetCode_Stack.Lc_844_BackSpaceStringCompare.backspaceCompare;
import static org.junit.Assert.assertEquals;

public class Lc_844_BackSpaceStringCompareTest {
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
    public void Test(){
        assertEquals(true, backspaceCompare("ad#c", "ad#c"));
        assertEquals(true, backspaceCompare("ab##", "c#d#"));
        assertEquals(false, backspaceCompare("a#c", "b"));
    }
}