package LeetCode_SlidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Lc_2090_KRadiusSubarrayAveragesTest {

    private final Lc_2090_KRadiusSubarrayAverages.Solution solution =
            new Lc_2090_KRadiusSubarrayAverages().new Solution();

    @Test
    public void example1() {
        // nums = [7,4,3,9,1,8,5,2,6], k = 3 -> [-1,-1,-1,5,4,4,-1,-1,-1]
        assertArrayEquals(new int[]{-1, -1, -1, 5, 4, 4, -1, -1, -1},
                solution.getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3));
    }

    @Test
    public void example2() {
        // nums = [100000], k = 0 -> [100000]
        assertArrayEquals(new int[]{100000}, solution.getAverages(new int[]{100000}, 0));
    }

    @Test
    public void example3() {
        // nums = [8], k = 100000 -> [-1] (not enough elements around the only index)
        assertArrayEquals(new int[]{-1}, solution.getAverages(new int[]{8}, 100000));
    }

    @Test
    public void edgeAllMinusOne() {
        // k larger than half of length -> all -1
        assertArrayEquals(new int[]{-1, -1, -1}, solution.getAverages(new int[]{1, 2, 3}, 2));
    }
}
