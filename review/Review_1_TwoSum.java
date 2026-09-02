// 复习档案 · 2026-09-02 三刷 · 结果：🟡 L1+L2 提示后 AC（3/7 天档续）
// 解法已并入 Lc_1_TwoSum；本文件保留当次手写版本供回看
import java.util.*;

public class Review_1_TwoSum {

    class Solution {
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
