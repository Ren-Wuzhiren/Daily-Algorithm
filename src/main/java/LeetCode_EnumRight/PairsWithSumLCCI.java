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


    /**
     * 问题抽象：给定数组和target，找出所有和为target的数对（每个元素只能用一次）。
     * 解法模式：计数缓存 + 单次遍历（“枚举右维护左”）。
     *
     * 核心数据结构及角色：
     * - Map<Integer, Integer> count: 记录每个数字尚未被匹配的个数
     * - List<List<Integer>> ans：存放所有找到的数对
     *
     * 算法步骤：
     * 1. 初始化 count 为空，ans 为空列表。
     * 2. 遍历数组的每个元素 x：
     *    a. 计算 want = target - x。
     *    b. 查询 count 中 want 的余量 c（若不存在则为0）。
     *    c. 如果 c > 0，则配对成功：
     *       - 将 [want, x] 加入 ans（保持示例顺序）
     *       - count 中 want 的余量减1
     *    d. 如果 c == 0，则当前 x 未找到配对：
     *       - 将 x 的计数加1（等待未来元素与其配对）
     * 3. 返回 ans。
     *
     * 边界条件：
     * - 数组长度0 → 空列表。
     * - 大量相同元素 → count 计数正确增减即可。
     *
     * 易错点：
     * - 配对成功后一定要 ans.add(...)，不能只更新 count。
     * - 使用 count.getOrDefault(...) 避免 NPE。
     * - 内部列表顺序按题目示例（互补数在前，当前数在后）。
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
