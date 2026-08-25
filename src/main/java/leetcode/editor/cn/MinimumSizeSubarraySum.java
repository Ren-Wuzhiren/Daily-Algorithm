package leetcode.editor.cn;

import java.util.*;

public class MinimumSizeSubarraySum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        // put your test code here
        testExample1();
        testExample2();
        testExample3();
    }

    public static void testExample1() {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = solution.minSubArrayLen(target, nums);
        System.out.println("result = " + result);
    }

    public static void testExample2() {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        int target = 4;
        int[] nums = {1, 4, 4};
        int result = solution.minSubArrayLen(target, nums);
        System.out.println("result = " + result);
    }

    public static void testExample3() {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int result = solution.minSubArrayLen(target, nums);
        System.out.println("result = " + result);
    }
}