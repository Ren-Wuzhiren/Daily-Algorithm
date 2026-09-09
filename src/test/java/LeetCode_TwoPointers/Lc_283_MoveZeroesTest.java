package LeetCode_TwoPointers;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Lc_283_MoveZeroesTest {

    private final Lc_283_MoveZeroes.Solution solution =
            new Lc_283_MoveZeroes().new Solution();

    private void assertMoveZeroes(int[] nums, int[] expected) {
        solution.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void example1() {
        assertMoveZeroes(new int[] {0, 1, 0, 3, 12}, new int[] {1, 3, 12, 0, 0});
    }

    @Test
    public void example2() {
        assertMoveZeroes(new int[] {0}, new int[] {0});
    }

    @Test
    public void edgeNoZeros() {
        assertMoveZeroes(new int[] {1, 2, 3, 4}, new int[] {1, 2, 3, 4});
    }

    @Test
    public void edgeAllZeros() {
        assertMoveZeroes(new int[] {0, 0, 0}, new int[] {0, 0, 0});
    }

    @Test
    public void edgeLeadingZeros() {
        assertMoveZeroes(new int[] {0, 0, 1}, new int[] {1, 0, 0});
    }

    @Test
    public void edgeAlternating() {
        assertMoveZeroes(new int[] {1, 0, 2, 0, 3}, new int[] {1, 2, 3, 0, 0});
    }

    @Test
    public void edgeNegativeAndMixed() {
        assertMoveZeroes(new int[] {-1, 0, 0, 5, 0}, new int[] {-1, 5, 0, 0, 0});
    }
}
