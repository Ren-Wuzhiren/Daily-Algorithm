package LeetCode_TwoPointers;

public class Lc_167_TwoSumII {

    class Solution {
        /**
         * 词汇表：
         * - 两个数相加等于 target → numbers[left] + numbers[right] == target
         * - 和太小 → 需要更大的数 → left++
         * - 和太大 → 需要更小的数 → right--
         * - 相向走到碰头为止 → while (left < right)
         * - 返回下标从 1 开始 → new int[] {left + 1, right + 1}
         *
         * 一刷（8.23）误区：暴力 O(n²) 超时 → 需相向双指针（利用数组有序）
         * 二刷（8.26）误区：右指针方向笔误，sum > target 时应 right--（写成 right++）
         * 三刷（8.31）误区：把相向双指针写成 for 循环，for 的 right++ 与 else 的 right-- 互相抵消 → 死循环 TLE
         * 四刷（9.4）误区：算法结构无提示写对，但漏写 `left++` 分号 → Java 语法错误；修正后通过测试
         * 结论：谁动谁不动由比较结果现场决定 → 用 while；右指针从末尾起；返回下标 +1；算法正确也要做编译检查。
         */
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


