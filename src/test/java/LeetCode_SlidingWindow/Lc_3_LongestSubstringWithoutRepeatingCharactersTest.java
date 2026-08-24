package LeetCode_SlidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc_3_LongestSubstringWithoutRepeatingCharactersTest {

    private final Lc_3_LongestSubstringWithoutRepeatingCharacters.Solution solution =
            new Lc_3_LongestSubstringWithoutRepeatingCharacters().new Solution();

    @Test
    public void example1() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void example2() {
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void example3() {
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void edgeEmpty() {
        assertEquals(0, solution.lengthOfLongestSubstring(""));
    }

    @Test
    public void edgeSingleChar() {
        assertEquals(1, solution.lengthOfLongestSubstring("a"));
        assertEquals(1, solution.lengthOfLongestSubstring(" "));
    }

    @Test
    public void edgeResetTrap() {
        // "dvdf": longest is "vdf" (3); reset approach would wrongly return 2
        assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    public void edgeAllDistinct() {
        assertEquals(5, solution.lengthOfLongestSubstring("abcde"));
    }

    @Test
    public void edgeLeftAdvance() {
        // "abba": at index 3, last[a]=0 < left=2 -> no shrink, ans stays 2
        assertEquals(2, solution.lengthOfLongestSubstring("abba"));
    }
}
