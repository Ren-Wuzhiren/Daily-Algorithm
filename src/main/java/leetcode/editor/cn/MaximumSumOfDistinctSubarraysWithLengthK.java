package leetcode.editor.cn;

import java.util.*;

public class MaximumSumOfDistinctSubarraysWithLengthK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            long ans = Long.MIN_VALUE;
            long sum = 0;
            int distinct = 0;
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                // System.out.println("第" + (i + 1) + "轮");
                sum += nums[i];
                // System.out.println("sum自增后：" + sum);
                // 注意：merge函数里的 key 不要写成下标！测试样例 3 的错误答案 0 就栽在这里了！（正确答案是3）
                Integer count = freq.merge(nums[i], 1, Integer::sum);
                if (count == 1) {
                    distinct++;
                }

                // System.out.println("count自增后：" + count);
                // System.out.println("distinct自增后：" + distinct);

                if (i - k + 1 < 0) {
                    continue;
                }

                // 这里要让非重复元素 distinct 的数量和窗口长度 k 保持相同！
                if (distinct == k) {
                    // 注意这里要更新维护的答案是 answer 和 sum，用 count 比较没有意义！
                    ans = Math.max(ans, sum);
                }

                // System.out.println("ans更新后：" + ans);

                // 更新答案以后不要把左端点写成右端点下标，否则减了等于没减！
                sum -= nums[i - k + 1];
                // System.out.println("sum自减后：" + sum);

                Integer newCount = freq.merge(nums[i - k + 1], -1, Integer::sum);
                if (newCount == 0) {
                    // 注意：这里是数字不是下标！测试样例 4 的错误答案 29 就栽在这里了！（正确答案是35）
                    freq.remove(nums[i - k + 1]);
                    distinct--;
                }

                // System.out.println("distinct自减后：" + distinct);
            }
            return ans == Long.MIN_VALUE ? 0 : ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximumSumOfDistinctSubarraysWithLengthK().new Solution();
        // put your test code here
        testExample1();
        testExample2();
        testExample3();
        testExample4();
    }

    public static void testExample1() {
        Solution solution = new MaximumSumOfDistinctSubarraysWithLengthK().new Solution();
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(solution.maximumSubarraySum(nums, k));
        System.out.println("-------------分割线----------------");
    }

    public static void testExample2() {
        Solution solution = new MaximumSumOfDistinctSubarraysWithLengthK().new Solution();
        int[] nums = {4, 4, 4};
        int k = 3;
        System.out.println(solution.maximumSubarraySum(nums, k));
        System.out.println("-------------分割线----------------");
    }

    public static void testExample3() {
        Solution solution = new MaximumSumOfDistinctSubarraysWithLengthK().new Solution();
        int[] nums = {1, 2, 2};
        int k = 2;
        System.out.println(solution.maximumSubarraySum(nums, k));
        System.out.println("-------------分割线----------------");
    }

    public static void testExample4() {
        Solution solution = new MaximumSumOfDistinctSubarraysWithLengthK().new Solution();
        int[] nums = {13, 3, 15, 7, 12, 17, 5, 19, 16, 15};
        int k = 2;
        System.out.println(solution.maximumSubarraySum(nums, k));
        System.out.println("-------------分割线----------------");
    }
}