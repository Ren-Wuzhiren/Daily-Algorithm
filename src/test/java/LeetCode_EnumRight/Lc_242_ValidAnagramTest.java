package LeetCode_EnumRight;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Lc_242_ValidAnagramTest {

    private final Lc_242_ValidAnagram.Solution solution =
            new Lc_242_ValidAnagram().new Solution();

    @Test
    public void example1() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void example2() {
        assertFalse(solution.isAnagram("rat", "car"));
    }

    @Test
    public void edgeChangedChar() {
        // 数量对但种类变（r -> q）
        assertFalse(solution.isAnagram("anagram", "nagaqam"));
    }

    @Test
    public void edgeMissingChar() {
        // 少一个 'a'
        assertFalse(solution.isAnagram("anagram", "nagarm"));
    }

    @Test
    public void edgeExtraChar() {
        // 多一个 'a'
        assertFalse(solution.isAnagram("anagram", "nagaraam"));
    }

    @Test
    public void edgeSameLengthDifferentCount() {
        assertFalse(solution.isAnagram("aab", "abb"));
    }

    @Test
    public void edgeEmptyStrings() {
        assertTrue(solution.isAnagram("", ""));
    }

    @Test
    public void edgeSingleSameChar() {
        assertTrue(solution.isAnagram("a", "a"));
        assertFalse(solution.isAnagram("a", "b"));
    }
}
