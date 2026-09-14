// 复习档案 · 2026-09-14 二刷 · 结果：🟡 提示后 AC（4min53s，3/7 天档续）
// 第一段独立写对；第二段「擦尾巴」忘掉，提示后补上（复用 slow 做索引）
public class Review_283_MoveZeroes {

    class Solution {
        /**
         * 复习重写 · 2026-09-14 · 第 2 轮
         */
        public void moveZeroes(int[] nums) {
            // 无提示重写：全部凭记忆
            int slow = 0;
            for (int fast = 0; fast < nums.length; fast++) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
            }

            for (; slow < nums.length; slow++) {
                nums[slow] = 0;
            }
        }
    }
}
