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
                }
                fast++;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        // put your test code here
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int result = solution.removeElement(nums, val);
        System.out.println(result);
    }
}