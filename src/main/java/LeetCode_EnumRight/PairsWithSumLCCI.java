package LeetCode_EnumRight;

import java.util.*;

public class PairsWithSumLCCI {

    /*
        设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。

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

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // 历史容器：记录每个数字剩余可用的个数（“维护左”）
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {  // 枚举右
            int want = target - x;
            // 检查 want 是否有库存
            int c = count.getOrDefault(want, 0);
            if (c > 0) {
                // 配对成功，添加一对
                ans.add(Arrays.asList(want, x));
                count.put(want, c - 1);   // 消耗库存
            } else {
                // 等待被匹配
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }
        return ans;
    }
}
