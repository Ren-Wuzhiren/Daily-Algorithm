package LeetCode_SlidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc_209_MinimumSizeSubarraySumTest {

    private final Lc_209_MinimumSizeSubarraySum.Solution solution =
            new Lc_209_MinimumSizeSubarraySum().new Solution();

    @Test
    public void example1() {
        assertEquals(2, solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    public void example2() {
        assertEquals(1, solution.minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    @Test
    public void example3() {
        assertEquals(0, solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void edgeExactlyTarget() {
        // [5,10] sum = 15 exactly, length 2
        assertEquals(2, solution.minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
    }

    @Test
    public void edgeSingleElementHit() {
        assertEquals(1, solution.minSubArrayLen(5, new int[]{5}));
    }

    @Test
    public void edgeSingleElementMiss() {
        assertEquals(0, solution.minSubArrayLen(6, new int[]{5}));
    }

    @Test
    public void edgeTotalTooSmall() {
        assertEquals(0, solution.minSubArrayLen(100, new int[]{1, 2, 3}));
    }

    @Test
    public void edgeFirstElementAlone() {
        assertEquals(1, solution.minSubArrayLen(2, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
