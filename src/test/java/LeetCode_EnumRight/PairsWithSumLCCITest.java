package LeetCode_EnumRight;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PairsWithSumLCCITest {

    /*
        示例 1：

        输入：nums = [5,6,5], target = 11
        输出：[[5,6]]

        示例 2：

        输入：nums = [5,6,5,6], target = 11
        输出：[[5,6],[5,6]]
        提示：

        nums.length <= 100000
        -105 <= nums[i], target <= 105
    */

    private final PairsWithSumLCCI solution = new PairsWithSumLCCI();

    @Test
    public void testExample1(){
        int[] nums = {5, 6, 5};
        int target = 11;
        List<List<Integer>> actual = solution.pairSums(nums, target);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(5, 6)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2(){
        int[] nums = {5, 6, 5, 6};
        int target = 11;
        List<List<Integer>> actual = solution.pairSums(nums, target);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(5, 6),
                Arrays.asList(5, 6)
        );
        assertEquals(expected, actual);
    }

}