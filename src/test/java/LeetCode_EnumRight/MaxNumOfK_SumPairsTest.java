package LeetCode_EnumRight;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxNumOfK_SumPairsTest {

    /*
        示例 1：
        输入：nums = [1,2,3,4], k = 5
        输出：2
        解释：开始时 nums = [1,2,3,4]：
                - 移出 1 和 4 ，之后 nums = [2,3]
                - 移出 2 和 3 ，之后 nums = []
        不再有和为 5 的数对，因此最多执行 2 次操作。

        示例 2：
        输入：nums = [3,1,3,4,3], k = 6
        输出：1
        解释：开始时 nums = [3,1,3,4,3]：
                - 移出前两个 3 ，之后nums = [1,4,3]
        不再有和为 6 的数对，因此最多执行 1 次操作。
    */

    private final MaxNumOfK_SumPairs solution = new MaxNumOfK_SumPairs();

    @Test
    public void testExample1(){
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        int actual = solution.maxOperations(nums, k);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2(){
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;
        int actual = solution.maxOperations(nums, k);
        int expected = 1;
        assertEquals(expected, actual);
    }
}