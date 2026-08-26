package LeetCode_EnumRight;

public class Lc_167_TwoSumII {

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                // 把 sum == target 作为一种特殊情况处理
                if (sum == target) {
                    return new int[] {left + 1, right + 1};
                } else if (sum < target) {
                    left++;
                } else {
                    // 二刷经验：注意指针方向，不要写反了！（sum > target 时 right--）
                    right--;
                }
            }
            return new int[] {-1, -1};
        }
    }
}
