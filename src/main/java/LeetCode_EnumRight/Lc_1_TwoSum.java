package LeetCode_EnumRight;

import java.util.HashMap;

public class Lc_1_TwoSum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                // 查补数 target - nums[i]
                if (map.containsKey(target - nums[i])) {
                    return new int[] {map.get(target - nums[i]), i};
                }
                // 先查后插：没有就存 值 -> 下标
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }
}
