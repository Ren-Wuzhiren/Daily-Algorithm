package LeetCode_SlidingWindow;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMaxAverageTest {
    FindMaxAverage solution = new FindMaxAverage();

    @Test
    public void testExample1() {
        /*
            输入：nums = [1,12,-5,-6,50,3], k = 4
            输出：12.75
            解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
        */

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double expected = 12.75;
        double actual = solution.findMaxAverage(nums, k);
        double delta = 1e-5;
        assertEquals(expected, actual, delta);
    }
}