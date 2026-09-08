// 复习档案 · 2026-09-08 二刷 · 结果：🔴 看笔记后默写 AC（1/3 天档，9.9 无提示重写）
// 备注：曾看 Notion 笔记才写出；结构五要素最终独立拼对（slow=1/快指针驱动/判前一个/写入/return），仅 fast 起点靠 L1 提示
public class Review_26_RemoveDuplicatesFromSortedArray {

    class Solution {
        /**
         * 复习重写 · 2026-09-08 · 第 2 轮
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
