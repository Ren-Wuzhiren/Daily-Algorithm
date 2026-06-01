package LeetCode_EnumRight;

import java.util.HashMap;
import java.util.Map;

public class MinimumCardPickUp {
    public int minimumCardPickup(int[] cards) {
        /*
            给你一个整数数组 cards ，其中 cards[i] 表示第 i 张卡牌的值。如果两张卡牌的值相同，则认为这一对卡牌匹配 。
            返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 -1 。

            示例 1：
            输入：cards = [3,4,2,3,4,7]
            输出：4
            解释：拿起卡牌 [3,4,2,3] 将会包含一对值为 3 的匹配卡牌。注意，拿起 [4,2,3,4] 也是最优方案。

            示例 2：
            输入：cards = [1,0,5,3]
            输出：-1
            解释：无法找出含一对匹配卡牌的一组连续卡牌。
        */

        // 1. 将 HashMap 与 题干建立直觉
        Map<Integer, Integer> map = new HashMap<>();
        // 2. 把最大值 Integer.MAX_VALUE 存入 answer
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            // 4.1 当 i = 3 时，map 包含索引 i = 0 的元素 3
            // 4.2 当 i = 4 时，map 包含索引 i = 1 的元素 4
            if (map.containsKey(cards[i])) {
                // 5.1 将 answer 更新至 (3 - 0 + 1)，也就是 answer = 4
                // 5.2 将 answer 更新至 (4 - 1 + 1)，也就是 answer = 4
                answer = Math.min(answer, i - map.get(cards[i]) + 1);
            }
            // 3.1 将 3 和 0 存入 map 里
            // 3.2 将 4 和 1 存入 map 里
            // 3.3 将 2 和 2 存入 map 里
            // 3.4 将 7 和 4 存入 map 里
            map.put(cards[i], i);
        }
        // answer 与 Integer.MAX_VALUE 不相等，返回 4
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // 时间复杂度：O (n)，n 为 cards 的长度
    // 空间复杂度：O (n)
}
