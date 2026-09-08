package LeetCode_TwoPointers;

public class Lc_26_RemoveDuplicatesFromSortedArray {

    class Solution {
        /**
         * 词汇表：
         * - 慢指针 = 下一个可写位置（首元素保留） → int slow = 1;
         * - 判断是否「新元素」（数组有序，重复必相邻） → nums[fast] != nums[fast - 1]
         * - 原地覆盖 → nums[slow] = nums[fast]; slow++;
         * - 返回去重后长度 → return slow;
         *
         * 一刷（9.3）踩坑：
         * 1. slow 初值写成 0 —— 第一个元素没人保留，首元素被覆盖丢失（[1,1,2] 返回 1）
         * 2. return nums[slow] —— 误返回「数组元素」；且无重复数组时 slow 走到 length → 越界崩溃
         * 结论：数组首元素一定是新元素 → slow 从 1 起；返回的是「长度」= slow，不是元素。
         *
         * 二刷（9.8）踩坑：
         * 结构曾全乱 —— slow 从数组末尾起、把「循环变量」和「快指针」当成两个东西（其实是一个）
         * 心法：快指针 = for 计数器（负责看），慢指针 = 写入位（负责写）；nums[fast-1] 是「紧邻前一个」。
         */
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
}
