package leetcode.editor.cn;

import java.util.*;

public class RemoveDuplicatesFromSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 1;
            for (int fast = 1; fast < nums.length; fast++) {
                if (nums[fast] != nums[fast - 1]) {
                    nums[slow] = nums[fast];
                    slow++;
                }
            }

            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        // put your test code here
        testExample1();
        testExample2();
    }

    public static void testExample1() {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] nums = {1, 1, 2};
        int result = solution.removeDuplicates(nums);
        System.out.println("result = " + result);
    }

    public static void testExample2() {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = solution.removeDuplicates(nums);
        System.out.println("result = " + result);
    }
}