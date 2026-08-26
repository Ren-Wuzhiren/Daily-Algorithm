package leetcode.editor.cn;

import java.util.*;

public class TwoSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                // 查询补数 "target - num[i]"，原来补数是这样写的：
                if (map.containsKey(target - nums[i])) {
                    // 有就返回 {补数的下标, i}
                    return new int[] {map.get(target - nums[i]), i};
                }
                // 没有就把 nums[i] 存进 map
                map.put(nums[i], i);
            }
            // 原来所谓的 "保证有解" 可以这样写：
            return new int[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // put your test code here
        
    }
}