package LeetCode_Stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static LeetCode_Stack.Lc_1441_BuildAnArrayWithStackOperations.buildArray;
import static org.junit.Assert.assertEquals;

public class Lc_1441_BuildAnArrayWithStackOperationsTest{

    /*
        示例 1：
        输入：target = [1,3], n = 3
        输出：["Push","Push","Pop","Push"]
        解释：一开始栈为空。最后一个元素是栈顶。
        从流中读取 1 并推入数组。s = [1]。
        从流中读取 2 并推入数组。s = [1,2]。
        从栈顶删除整数。s = [1]。
        从流中读取 3 并推入数组。s = [1,3]。

        示例 2：
        输入：target = [1,2,3], n = 3
        输出：["Push","Push","Push"]
        解释：一开始栈为空。最后一个元素是栈顶。
        从流中读取 1 并推入数组。s = [1]。
        从流中读取 2 并推入数组。s = [1,2]。
        从流中读取 3 并推入数组。s = [1,2,3]。

        示例 3：
        输入：target = [1,2], n = 4
        输出：["Push","Push"]
        解释：一开始栈为空。最后一个元素是栈顶。
        从流中读取 1 并推入数组。s = [1]。
        从流中读取 2 并推入数组。s = [1,2]。
        由于栈（从底部到顶部）等于 target，我们停止栈操作。
        从流中读取整数 3 的答案不被接受。
    */

    @Test
    public void testExample1() {
        int[] target = {1, 3};
        int max = 3;
        List<String> expected = Arrays.asList("Push", "Push", "Pop", "Push");
        List<String> actual = buildArray(target, max);
        assertEquals(expected, actual);
    }


    @Test
    public void testExample2() {
        int[] target = {1, 2, 3};
        int max = 3;
        List<String> expected = Arrays.asList("Push", "Push", "Push");
        List<String> actual = buildArray(target, max);
        assertEquals(expected, actual);
    }


    @Test
    public void testExample3() {
        int[] target = {1, 2};
        int max = 4;
        List<String> expected = Arrays.asList("Push", "Push");
        List<String> actual = buildArray(target, max);
        assertEquals(expected, actual);
    }
}