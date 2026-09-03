package LeetCode_TwoPointers;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Lc_26_RemoveDuplicatesFromSortedArrayTest {

    private final Lc_26_RemoveDuplicatesFromSortedArray.Solution solution =
            new Lc_26_RemoveDuplicatesFromSortedArray().new Solution();

    private void assertRemoveDuplicates(int[] nums, int[] expected) {
        int k = solution.removeDuplicates(nums);
        assertEquals(expected.length, k);
        assertArrayEquals(expected, Arrays.copyOf(nums, k));
    }

    @Test
    public void example1() {
        assertRemoveDuplicates(new int[] {1, 1, 2}, new int[] {1, 2});
    }

    @Test
    public void example2() {
        assertRemoveDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[] {0, 1, 2, 3, 4});
    }

    @Test
    public void edgeSingleElement() {
        assertRemoveDuplicates(new int[] {1}, new int[] {1});
    }

    @Test
    public void edgeAllDuplicates() {
        assertRemoveDuplicates(new int[] {1, 1, 1}, new int[] {1});
    }

    @Test
    public void edgeNoDuplicates() {
        // 无重复：slow 会走到 length，return 必须是 slow（9.3 踩坑：写成 nums[slow] 会越界）
        assertRemoveDuplicates(new int[] {1, 2, 3}, new int[] {1, 2, 3});
    }

    @Test
    public void edgeNegativeNumbers() {
        assertRemoveDuplicates(new int[] {-1, -1, 0, 0, 1}, new int[] {-1, 0, 1});
    }

    @Test
    public void edgeExtremeValues() {
        assertRemoveDuplicates(new int[] {-100, 100}, new int[] {-100, 100});
    }
}
