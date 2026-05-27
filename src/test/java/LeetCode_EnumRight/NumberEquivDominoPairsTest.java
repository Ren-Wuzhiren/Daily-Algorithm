package LeetCode_EnumRight;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberEquivDominoPairsTest {
    /*
        示例 1：
        输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
        输出：1

        示例 2：
        输入：dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
        输出：3
    */

    private final NumberEquivDominoPairs solution = new NumberEquivDominoPairs();

    @Test
    public void testExample1(){
        int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        int result = 1;
        int actual = solution.numEquivDominoPairs(dominoes);
        assertEquals(result, actual);
    }

    @Test
    public void testExample2(){
        int[][] dominoes = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
        int result = 3;
        int actual = solution.numEquivDominoPairs(dominoes);
        assertEquals(result, actual);
    }
}