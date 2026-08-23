package leetcode.editor.cn;

import java.util.*;

public class RemoveElement {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int fast = 0, slow = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                    // fast++;
                }
                fast++;
                // slow++;
            }
            return slow;
            // return nums[slow];

            // 不要把快慢指针位置写反，还有放回的内容应该是慢指针，而不是数组！
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        // put your test code here
        testExample1();
        testExample2();
    }

    public static void testExample1() {
        Solution solution = new RemoveElement().new Solution();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int result = solution.removeElement(nums, val);
        System.out.println("result = " + result);
    }

    public static void testExample2() {
        Solution solution = new RemoveElement().new Solution();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int result = solution.removeElement(nums, val);
        System.out.println("result = " + result);
    }
}