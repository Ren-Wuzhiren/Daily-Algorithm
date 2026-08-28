package LeetCode_SlidingWindow;

public class Lc_209_MinimumSizeSubarraySum {

    class Solution {
        /**
         * 一刷（8.25）误区总结：
         * 1. ans = Math.min(sum, right-left+1) —— 拿"窗口和"当"长度"比，且更新在收缩之后（窗口已不满足条件）
         * 2. ans = Math.min(Integer.MAX_VALUE, ...) —— 把哨兵值当比较对象，ans 被每次覆盖；应为 Math.min(ans, ...)
         * 结论：答案 = 窗口长度；满足条件时先更新答案再收缩；Math.min 第一参永远是 ans 本身。
         *
         * 二刷（8.28）误区总结：
         * 1. 把"扩张"和"收缩"写成 if/else 二选一 —— 错位；正确是"每轮先扩张，再 while 持续收缩"
         * 2. 收缩用 if 而不是 while —— 缩一次可能仍满足条件，要缩到 sum < target 才停
         * 3. 收缩时忘了 left++ —— 窗口左端不动，和永远减不干净
         * 结论：每轮先 sum += nums[right]；while (sum >= target) 内更新 ans 再收缩；ans 用 right-left+1。
         */
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE, left = 0, sum = 0;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}
