package LeetCode_HashMap;

import java.util.HashMap;

public class Lc_1_TwoSum {

    class Solution {
        /**
         * 词汇表：
         * - 「补数」 → target - nums[i]
         * - 补数的下标 → map.get(target - nums[i])
         * - 存下值和它的下标 → map.put(nums[i], i)
         * - 保证有解，但代码要兜底 → return new int[0];
         *
         * 一刷（8.26）误区：
         * 1. 被 167 带偏，惯性想用双指针 —— 无序数组两数之和要用哈希查补
         * 2. map 键值方向写反 —— 应该是 值 -> 下标
         * 3. 返回下标顺序写错 —— 先查到的补数下标在前，当前 i 在后
         * 结论：先查补数再插当前值；map 存 值 -> 下标；返回 {map.get(补数), i}。
         *
         * 三刷（9.2）误区：
         * 1. 把「当前元素」写成 map.get(i) —— map 的键是数组值不是下标 i，map.get(i) 返回 null → target - null NPE
         * 2. if/return 自修对（查补数用 nums[i]）；put 存值靠 L2 提示才想起也该用 nums[i]
         * 结论：查补数用 nums[i]，存值也用 nums[i]；map 是用来查历史的，不是拿当前元素的。
         */
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
