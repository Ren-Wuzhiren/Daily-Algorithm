package LeetCode_SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSumOfAlmostUniqueSubarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxSum(List<Integer> nums, int m, int k) {
            long ans = Long.MIN_VALUE;
            long sum = 0;
            int distinct = 0;
            Map<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < nums.toArray().length; i++) {
                Integer right = nums.get(i);
                sum += nums.get(i);

                Integer count = freq.merge(right, 1, Integer::sum);
                if (count == 1) {
                    distinct++;
                }

                // System.out.println("累加sum：" + sum);

                if (i - k + 1 < 0) {
                    continue;
                }

                if (distinct >= m) {
                    ans = Math.max(ans, sum);
                }
                // System.out.println("互不相同的元素个数：" + distinct);

                // System.out.println("最大结果：" + ans);

                Integer left = nums.get(i - k + 1);
                sum -= nums.get(i - k + 1);
                int newCount = freq.merge(left, -1, Integer::sum);
                if (newCount == 0) {
                    freq.remove(left);
                    distinct--;
                }
                // System.out.println("减滑窗左端：" + sum);
            }

            return ans == Long.MIN_VALUE ? 0 : ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximumSumOfAlmostUniqueSubarray().new Solution();
        // put your test code here
        testExample1();
        testExample2();
        testExample3();
    }

    public static void testExample1() {
        Solution solution = new MaximumSumOfAlmostUniqueSubarray().new Solution();
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(6);
        nums.add(7);
        nums.add(3);
        nums.add(1);
        nums.add(7);
        int m = 3;
        int k = 4;
        long result = solution.maxSum(nums, m, k);
        System.out.println("结果：" + result);
        System.out.println("-----------分割线----------");
    }

    public static void testExample2() {
        Solution solution = new MaximumSumOfAlmostUniqueSubarray().new Solution();
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(9);
        nums.add(9);
        nums.add(2);
        nums.add(4);
        nums.add(5);
        nums.add(4);
        int m = 1;
        int k = 3;
        long result = solution.maxSum(nums, m, k);
        System.out.println("结果：" + result);
        System.out.println("-----------分割线----------");
    }

    public static void testExample3() {
        Solution solution = new MaximumSumOfAlmostUniqueSubarray().new Solution();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        nums.add(2);
        nums.add(1);
        nums.add(2);
        nums.add(1);
        int m = 3;
        int k = 3;
        long result = solution.maxSum(nums, m, k);
        System.out.println("结果：" + result);
        System.out.println("-----------分割线----------");
    }
}