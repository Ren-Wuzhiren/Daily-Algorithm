package leetcode.editor.cn;

import java.util.*;

public class MoveZeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0;
            for (int fast = 0; fast < nums.length; fast++) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
            }

            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // put your test code here
        testExample1();
        testExample2();
    }

    public static void testExample1() {
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);               // 没有返回值，直接改 nums
        System.out.println("result = " + Arrays.toString(nums));   // 打印改完的数组
    }

    public static void testExample2() {
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = {0};
        solution.moveZeroes(nums);
        System.out.println("result = " + Arrays.toString(nums));
    }
}