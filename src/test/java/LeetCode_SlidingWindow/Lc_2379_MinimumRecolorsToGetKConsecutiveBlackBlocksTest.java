package LeetCode_SlidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc_2379_MinimumRecolorsToGetKConsecutiveBlackBlocksTest {

    private final Lc_2379_MinimumRecolorsToGetKConsecutiveBlackBlocks.Solution solution =
            new Lc_2379_MinimumRecolorsToGetKConsecutiveBlackBlocks().new Solution();

    @Test
    public void example1() {
        assertEquals(3, solution.minimumRecolors("WBBWWBBWBW", 7));
    }

    @Test
    public void example2() {
        assertEquals(0, solution.minimumRecolors("WBWBBBW", 2));
    }

    @Test
    public void edgeAllBlack() {
        assertEquals(0, solution.minimumRecolors("BBBBB", 2));
    }

    @Test
    public void edgeAllWhite() {
        assertEquals(1, solution.minimumRecolors("WWW", 1));
    }
}
