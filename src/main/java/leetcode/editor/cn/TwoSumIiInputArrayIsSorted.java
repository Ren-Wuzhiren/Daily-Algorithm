package leetcode.editor.cn;

import java.util.*;

public class TwoSumIiInputArrayIsSorted {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int right = 0, left = 0;

            for (int i = 0; i < numbers.length; i++) {
                for (int j = numbers.length - 1; j > i; j--) {
                    if (numbers[i] + numbers[j] == target) {
                        right = j + numbers.length;
                    }
                }
                left = i + 1;
            }

            int[] result = {left, right};

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        // put your test code here

        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ans = solution.twoSum(numbers, target);

        System.out.println(ans);
    }
}