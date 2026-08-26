package LeetCode_EnumRight;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Lc_167_TwoSumIITest {

    private final Lc_167_TwoSumII.Solution solution =
            new Lc_167_TwoSumII().new Solution();

    @Test
    public void example1() {
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    public void example2() {
        assertArrayEquals(new int[]{1, 3}, solution.twoSum(new int[]{2, 3, 4}, 6));
    }

    @Test
    public void example3() {
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{-1, 0}, -1));
    }

    @Test
    public void edgeAnswerAtBothEnds() {
        assertArrayEquals(new int[]{1, 4}, solution.twoSum(new int[]{1, 2, 3, 4}, 5));
    }

    @Test
    public void edgeFirstAndLast() {
        assertArrayEquals(new int[]{1, 5}, solution.twoSum(new int[]{1, 2, 3, 4, 5}, 6));
    }

    @Test
    public void edgeMinimalArray() {
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{1, 2}, 3));
    }

    @Test
    public void edgeNegativeNumbers() {
        assertArrayEquals(new int[]{1, 4}, solution.twoSum(new int[]{-3, -1, 0, 2}, -1));
    }
}
