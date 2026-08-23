package LeetCode_EnumRight;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc_3880_MinAbsoluteDifferenceTest {
    /*
        示例 1：
        输入： nums = [1,0,0,2,0,1]
        输出： 2
        解释：
        有效下标对有：
                (0, 3)，其绝对差为 abs(0 - 3) = 3。
                (5, 3)，其绝对差为 abs(5 - 3) = 2。
        因此，结果是 2。

        示例 2：
        输入： nums = [1,0,1,0]
        输出： -1
        解释：
        数组中不存在有效下标对，因此结果是 -1。
    */

    private final Lc_3880_MinAbsoluteDifference solution = new Lc_3880_MinAbsoluteDifference();

    @Test
    public void testExample1() {
        int[] nums = {1, 0, 0, 2, 0, 1};
        int expected = 2;
        int actual = solution.minAbsoluteDifference(nums);
        assertEquals(expected, actual);
    }
}