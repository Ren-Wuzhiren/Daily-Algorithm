package LeetCode_TwoPointers;

public class Lc_283_MoveZeroes {

    class Solution {
        /**
         * 词汇表：
         * - slow = 下一个「非零元素」该写的位置（从 0 起）；fast = 扫描指针
         * - 只有非零才有资格被写往前：if (nums[fast] != 0) nums[slow++] = nums[fast]
         * - 第二段：尾巴 [slow, length) 全部填 0（第一段搬完后还留着旧的非零副本，必须覆盖）
         *
         * 一刷（9.9）踩坑与心路：
         * 1. 初始直觉「把 0 搬到末尾」= 赋值覆盖 → 会抹掉末尾非零（[0,1,0,3,12] 丢 12/3）
         * 2. 排序 / 和末尾交换 → 都会打乱非零相对顺序（违反契约）
         * 3. 想通关键：0 是「空」，不需要搬；只把非零按原序写到前面，顺序自动保持
         * 4. 卡点：把「从 slow 写到末尾」翻译成 for 循环（L2 骨架后补上）——词汇层问题，非思路问题
         * 结论：两段式——先搬非零（slow 记录写入位），再 for 从 slow 到末尾填 0。
         */
        public void moveZeroes(int[] nums) {
            int slow = 0;
            for (int fast = 0; fast < nums.length; fast++) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
            }
            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}
