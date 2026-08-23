package LeetCode_SlidingWindow;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Lc_2841_MaximumSumOfAlmostUniqueSubarrayTest {

    private final Lc_2841_MaximumSumOfAlmostUniqueSubarray.Solution solution =
            new Lc_2841_MaximumSumOfAlmostUniqueSubarray().new Solution();

    private List<Integer> list(int... a) {
        return Arrays.stream(a).boxed().collect(java.util.stream.Collectors.toList());
    }

    @Test
    public void example1() {
        assertEquals(18L, solution.maxSum(list(2, 6, 7, 3, 1, 7), 3, 4));
    }

    @Test
    public void example2() {
        assertEquals(23L, solution.maxSum(list(5, 9, 9, 2, 4, 5, 4), 1, 3));
    }

    @Test
    public void example3() {
        assertEquals(0L, solution.maxSum(list(1, 2, 1, 2, 1, 2, 1), 3, 3));
    }
}
