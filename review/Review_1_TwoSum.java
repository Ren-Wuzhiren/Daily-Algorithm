// 复习档案 · 2026-09-08 四刷 · 结果：✅ 无提示独立 AC（升 7/14 档）
// 三行全对（含 9.2 曾靠提示的 put 存值）；解法正文与 Lc_1_TwoSum 一致

import java.util.HashMap;

public class Review_1_TwoSum {

    class Solution {
        /**
         * 复习重写 · 2026-09-08 · 第 4 轮（目标：无提示独立 AC）
         */
        public int[] twoSum(int[] nums, int target) {
            // TODO: 在此实现（无提示）
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[] {map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }

            return new int[0];
        }
    }
}
