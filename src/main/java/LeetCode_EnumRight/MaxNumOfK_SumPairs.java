package LeetCode_EnumRight;

import java.util.HashMap;

public class MaxNumOfK_SumPairs {
    public int maxOperations(int[] nums, int key) {
        /*
            给你一个整数数组 nums 和一个整数 key 。
            每一步操作中，你需要从数组中选出和为 key 的两个整数，并将它们移出数组。
            返回你可以对数组执行的最大操作数。

            示例 1：
            输入：nums = [1,2,3,4], key = 5
            输出：2
            解释：开始时 nums = [1,2,3,4]：
                    - 移出 1 和 4 ，之后 nums = [2,3]
                    - 移出 2 和 3 ，之后 nums = []
            不再有和为 5 的数对，因此最多执行 2 次操作。

            示例 2：
            输入：nums = [3,1,3,4,3], key = 6
            输出：1
            解释：开始时 nums = [3,1,3,4,3]：
                    - 移出前两个 3 ，之后nums = [1,4,3]
            不再有和为 6 的数对，因此最多执行 1 次操作。
        */

        //将哈希表，"枚举右，维护左" 和该题干建立直觉
        //知识点：merge，getOrDefault，put

        //1. 以测试样例 1 为例：
        HashMap<Integer, Integer> count = new HashMap<>();
        //2. 初始化 answer 为 0
        int answer = 0;
        //3. 增强 for 循环实现 "枚举右" 效果
        for (int num: nums) {
            //4.1 num == 1，key == 5，key - num == 4，哈希表 count 中不存在 4，c 为 0
            //4.2 num == 2，key == 5，key - num == 3，哈希表 count 中不存在 3，c 为 0
            //4.3 num == 3，key == 5，key - num == 2，哈希表 count 中存在 2，c 为 1
            //4.3 num == 3，key == 5，key - num == 2，哈希表 count 中存在 1，c 为 1
            int c = count.getOrDefault(key - num, 0);
            if (c > 0) {
                //5.3 c == 1，将 (2, 1) 变为 (2, 0)，answer自增
                //5.3 c == 1，将 (1, 1) 变为 (1, 0)，answer自增
                count.put(key - num, c - 1);
                answer++;
            } else {
                //5.1 c <= 0 将 num == 1 和 c == 1 分别存入 key 和 value
                //5.2 c <= 0 将 num == 2 和 c == 1 分别存入 key 和 value
                count.merge(num, 1, Integer::sum);
            }
        }
        //6. 返回答案
        return answer;
    }

    // 难点：c 在 0 和 1 之间的转换条件：
    // 当 (key - num) 的结果与哈希表 count 中的 num 不匹配时
    // 将 c 作为 0 处理，存放 num 至 count

    // 当 (key - num) 的结果与哈希表 count 中的 num 匹配时
    // 将 c 作为 1 处理，最后将 c 置 0，存放 (key - num) 和 c 至 count 中

    // 时间复杂度：O (n)，n 为 nums的长度
    // 空间复杂度：O (n)，n 为 nums的长度
}
