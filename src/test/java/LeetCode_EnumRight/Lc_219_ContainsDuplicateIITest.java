package LeetCode_EnumRight;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc_219_ContainsDuplicateIITest {
    /*
        给你一个整数数组 nums 和一个整数 key ，
        判断数组中是否存在两个 不同的索引 i 和 j ，
        满足 nums[i] == nums[j] 且 abs(i - j) <= key 。
        如果存在，返回 true ；否则，返回 false 。

        示例 1：
        输入：nums = [1,2,3,1], k = 3
        输出：true

        示例 2：
        输入：nums = [1,0,1,1], k = 1
        输出：true

        示例 3：
        输入：nums = [1,2,3,1,2,3], k = 2
        输出：false
    */

    private final Lc_219_ContainsDuplicateII solution = new Lc_219_ContainsDuplicateII();

    @Test
    public void testExample1(){
        int[] nums = {1, 2, 3, 1};
        int key = 3;
        boolean actual = solution.containsNearbyDuplicate(nums, key);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2(){
        int[] nums = {1, 0, 1, 1};
        int key = 1;
        boolean actual = solution.containsNearbyDuplicate(nums, key);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3(){
        int[] nums = {1, 2, 3, 1, 2, 3};
        int key = 2;
        boolean actual = solution.containsNearbyDuplicate(nums, key);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}