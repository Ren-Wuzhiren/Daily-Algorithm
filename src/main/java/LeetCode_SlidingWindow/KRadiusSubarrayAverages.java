package LeetCode_SlidingWindow;

import java.util.Arrays;

public class KRadiusSubarrayAverages {

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
        给你一个下标从 0 开始的数组 nums ，
        数组中有 n 个整数，另给你一个整数 k 。

        半径为 k 的子数组平均值是指：nums 中一个以下标 i 为 中心且半径为 k 的子数组中所有元素的平均值，
        即下标在 i - k 和 i + k 范围（含 i - k 和 i + k）内所有元素的平均值。
        如果在下标 i 前或后不足 k 个元素，那么 半径为 k 的子数组平均值 是 -1 。

        构建并返回一个长度为 n 的数组 avgs ，
        其中 avgs[i] 是以下标 i 为中心的子数组的半径为 k 的子数组平均值 。

        x 个元素的平均值是 x 个元素相加之和除以 x ，此时使用截断式整数除法 ，即需要去掉结果的小数部分。

        例如，四个元素 2、3、1 和 5 的平均值是 (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75，截断后得到 2 。
    */
    class Solution {
        public int[] getAverages(int[] nums, int k) {
            int[] avgs = new int[nums.length];
            long sum = 0;
            Arrays.fill(avgs, -1);
            for (int i = 0; i < nums.length; i++) {
                // 1.累加
                sum += nums[i];
                if (i < 2 * k) {
                    continue;
                }

                // 2.更新答案
                avgs[i - k] = (int) (sum / (1 + 2 * k));

                // 3.推出窗口
                sum -= nums[i - 2 * k];
            }
            return avgs;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new KRadiusSubarrayAverages().new Solution();
        // put your test code here
    }
}