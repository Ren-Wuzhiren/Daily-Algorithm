package leetcode.editor.cn;

import java.util.*;

public class TwoSumIiInputArrayIsSorted {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int right = numbers.length - 1, left = 0;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                // 以后做算法题，把 sum == target 作为一种特殊情况处理。
                if (sum == target) {
                    return new int[] {left + 1, right + 1};
                } else if (sum < target) {
                    left++;
                } else {
                    // 不要把右指针自减条件 sum > target 漏掉
                    right--;
                }
            }
            return new int[] {-1, -1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        // put your test code here
        testExample1();
        testExample2();
        testExample3();
    }

    public static void testExample1() {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ans = solution.twoSum(numbers, target);
        System.out.println("ans = " + ans);
    }

    public static void testExample2() {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        int[] numbers = {2, 3, 4};
        int target = 6;
        int[] ans = solution.twoSum(numbers, target);
        System.out.println("ans = " + ans);
    }

    public static void testExample3() {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        int[] numbers = {-1, 0};
        int target = -1;
        int[] ans = solution.twoSum(numbers, target);
        System.out.println("ans = " + ans);
    }
}