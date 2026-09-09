// 复习档案 · 2026-09-09 三刷 · 结果：✅ 无提示重写 AC（3min42s，1/3 天档解除，升 7/14 档）
// 五要素一次写对、无卡点；解法正文与 Lc_26_RemoveDuplicatesFromSortedArray 一致
public class Review_26_RemoveDuplicatesFromSortedArray {

    class Solution {
        /**
         * 复习重写 · 2026-09-09 · 第 3 轮
         */
        public int removeDuplicates(int[] nums) {
            // 无提示重写：慢指针 / 快指针 / 判新元素 / 原地覆盖 / 返回值 —— 全部凭记忆
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
