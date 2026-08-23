package LeetCode_SlidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc_2461_MaximumSumOfDistinctSubarraysWithLengthKTest {

    private final Lc_2461_MaximumSumOfDistinctSubarraysWithLengthK.Solution solution =
            new Lc_2461_MaximumSumOfDistinctSubarraysWithLengthK().new Solution();

    @Test
    public void example1() {
        assertEquals(15L, solution.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
    }

    @Test
    public void example2() {
        assertEquals(0L, solution.maximumSubarraySum(new int[]{4, 4, 4}, 3));
    }

    @Test
    public void example3() {
        assertEquals(3L, solution.maximumSubarraySum(new int[]{1, 2, 2}, 2));
    }

    @Test
    public void example4() {
        assertEquals(35L, solution.maximumSubarraySum(
                new int[]{13, 3, 15, 7, 12, 17, 5, 19, 16, 15}, 2));
    }
}
