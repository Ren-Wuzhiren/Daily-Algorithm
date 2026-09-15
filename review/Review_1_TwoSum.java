// 复习档案 · 2026-09-15 五刷 · 结果：🟡 L1 提示后 AC（6min33s，降回 3/7 天档）
// 一周后重写时把补数方向写成 nums[i] - target；L1 后修正为 target - nums[i]，5 个测试全绿
// 历史：2026-09-08 四刷 · ✅ 无提示独立 AC（升 7/14 档）

import java.util.HashMap;

public class Review_1_TwoSum {

    class Solution {
        /**
         * 复习重写 · 2026-09-15 · 第 5 轮（L1 后 AC）
         */
        public int[] twoSum(int[] nums, int target) {
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
