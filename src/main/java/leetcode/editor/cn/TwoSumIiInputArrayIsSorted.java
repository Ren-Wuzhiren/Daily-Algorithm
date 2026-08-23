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

        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ans = solution.twoSum(numbers, target);
        System.out.println("ans = " + ans);
    }
}