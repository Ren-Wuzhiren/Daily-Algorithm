package LeetCode_EnumRight;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Lc_1_TwoSumTest {

    private final Lc_1_TwoSum.Solution solution =
            new Lc_1_TwoSum().new Solution();

    @Test
    public void example1() {
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    public void example2() {
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{3, 2, 4}, 6));
    }

    @Test
    public void example3() {
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    public void edgeNegativeNumbers() {
        assertArrayEquals(new int[]{0, 2}, solution.twoSum(new int[]{-3, 4, 3, 90}, 0));
    }

    @Test
    public void edgeAnswerAtBothEnds() {
        assertArrayEquals(new int[]{0, 3}, solution.twoSum(new int[]{1, 2, 3, 5}, 6));
    }
}
