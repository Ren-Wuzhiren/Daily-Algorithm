public class Review_167_TwoSumII {

    class Solution {
        /**
         * 复习重写 · 2026-09-04 · 第 4 轮 · 结果：✅ 无提示算法重写 AC（修正分号后通过）
         * 上一轮状态：🟡 提示后 AC（3/7 天档续）
         */
        public int[] twoSum(int[] numbers, int target) {
            // 第 4 轮手写版：算法结构无提示完成；left++ 分号由编译检查发现并修正
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[] {left + 1, right + 1};
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[] {-1, -1};
        }
    }
}

