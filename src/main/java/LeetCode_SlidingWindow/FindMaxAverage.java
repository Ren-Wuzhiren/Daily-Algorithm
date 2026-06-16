package LeetCode_SlidingWindow;

public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {

        /**
         * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
         *
         * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
         *
         * 任何误差小于 10-5 的答案都将被视为正确答案。
         *
         * 示例 1：
         *
         * 输入：nums = [1,12,-5,-6,50,3], k = 4
         * 输出：12.75
         * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
         *
         * 示例 2：
         *
         * 输入：nums = [5], k = 1
         * 输出：5.00000
         *
         * 提示：
         *
         * n == nums.length
         * 1 <= k <= n <= 105
         * -104 <= nums[i] <= 104
         *
         */

        /**
         * 算法步骤：
         * 1.初始化 maxAvg 最大值
         * 2.维护窗口元素和
         * 3.进入窗口
         * 4.更新数据
         * 5.离开窗口
         */

        int maxAvg = Integer.MIN_VALUE;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];

            if (i < k - 1) {
                continue;
            }

            maxAvg = Math.max(maxAvg, s);

            s -= nums[i - k + 1];

        }

        return (double) maxAvg / k;
    }
}
