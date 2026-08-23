package LeetCode_SlidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc_1423_MaximumPointsYouCanObtainFromCardsTest {

    private final Lc_1423_MaximumPointsYouCanObtainFromCards.Solution solution =
            new Lc_1423_MaximumPointsYouCanObtainFromCards().new Solution();

    @Test
    public void example1() {
        assertEquals(12, solution.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }

    @Test
    public void example2() {
        assertEquals(4, solution.maxScore(new int[]{2, 2, 2}, 2));
    }

    @Test
    public void example3() {
        assertEquals(55, solution.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
    }

    @Test
    public void example4() {
        assertEquals(1, solution.maxScore(new int[]{1, 1000, 1}, 1));
    }

    @Test
    public void example5() {
        assertEquals(202, solution.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }

    @Test
    public void edgeTakeAll() {
        // k == length -> take all cards
        assertEquals(15, solution.maxScore(new int[]{1, 2, 3, 4, 5}, 5));
    }
}
