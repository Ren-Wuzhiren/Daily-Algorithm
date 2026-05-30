package LeetCode_EnumRight;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int key) {
        /*
            给你一个整数数组 nums 和一个整数 key ，
            判断数组中是否存在两个 不同的索引 i 和 j ，
            满足 nums[i] == nums[j] 且 abs(i - j) <= key 。
            如果存在，返回 true ；否则，返回 false 。

            示例 1：
            输入：nums = [1,2,3,1], key = 3
            输出：true

            示例 2：
            输入：nums = [1,0,1,1], key = 1
            输出：true

            示例 3：
            输入：nums = [1,2,3,1,2,3], key = 2
            输出：false
        */

        // 示例 1：
        // 1. 将哈希表 Hashmap 和本题建立直觉
        Map<Integer, Integer> last = new HashMap<>();
        // 2. 遍历循环变量 i 由 0 自增至 nums.length 的 for 循环
        for (int i = 0; i < nums.length; i++) {
            // 3. 将遍历到的元素 nums[i] 交给变量 x 保存
            // 3.1 索引 0 的对应元素：1
            // 3.2 索引 1 的对应元素：2
            // 3.3 索引 2 的对应元素：3
            // 3.4 索引 3 的对应元素：1
            int x = nums[i];
            // 4. 哈希表 last 中包含元素 x 且 循环变量 i - 哈希表 last 中 x 的索引 <= key
            // 4.1 last 不包含元素 1
            // 4.2 last 不包含元素 2
            // 4.3 last 不包含元素 3
            // 4.4 last 包含元素 1，且 3 - 0 = 3
            if (last.containsKey(x) && i - last.get(x) <= key){
                // 返回 true
                return true;
            }
            // 5. 将 元素 x 和 循环变量 i 分别存入 key 和 value
            // 5.1 存入 (1, 0)
            // 5.2 存入 (2, 1)
            // 5.3 存入 (3, 2)
            last.put(x, i);
        }
        // 还没找到就返回 false
        return false;

        /*
            // 示例 2：
            // 1. 将哈希表 Hashmap 和本题建立直觉
            Map<Integer, Integer> last = new HashMap<>();
            // 2. 遍历循环变量 i 由 0 自增至 nums.length 的 for 循环
            for (int i = 0; i < nums.length; i++) {
                // 3. 将遍历到的元素 nums[i] 交给变量 x 保存
                // 3.1 索引 0 的对应元素：1
                // 3.2 索引 1 的对应元素：0
                // 3.3 索引 2 的对应元素：1
                // 3.4 索引 3 的对应元素：1
                int x = nums[i];
                // 4. 哈希表 last 中包含元素 x 且 循环变量 i - 哈希表 last 中 x <= key
                // 4.1 last 不包含元素 1
                // 4.2 last 不包含元素 0
                // 4.3 last 包含元素 1，且 2 - 0 = 2
                // 4.4 last 包含元素 1，且 3 - 2 = 1
                if (last.containsKey(x) && i - last.get(x) <= key){
                    // 返回 true
                    return true;
                }
                // 5. 将 元素 x 和 循环变量 i 分别存入 key 和 value
                // 5.1 存入 (1, 0)
                // 5.2 存入 (0, 1)
                // 5.3 存入 (1, 2)
                last.put(x, i);
            }
            // 还没找到就返回 false
            return false;
        */

        /*
            // 示例 3：
            // 1. 将哈希表 Hashmap 和本题建立直觉
            Map<Integer, Integer> last = new HashMap<>();
            // 2. 遍历循环变量 i 由 0 自增至 nums.length 的 for 循环
            for (int i = 0; i < nums.length; i++) {
                // 3. 将遍历到的元素 nums[i] 交给变量 x 保存
                // 3.1 索引 0 的对应元素：1
                // 3.2 索引 1 的对应元素：2
                // 3.3 索引 2 的对应元素：3
                // 3.4 索引 3 的对应元素：1
                // 3.5 索引 4 的对应元素：2
                // 3.6 索引 5 的对应元素：3
                int x = nums[i];
                // 4. 哈希表 last 中包含元素 x 且 循环变量 i - 哈希表 last 中 x <= key
                // 4.1 last 不包含元素 1
                // 4.2 last 不包含元素 2
                // 4.3 last 不包含元素 3
                // 4.4 last 包含元素 1，且 3 - 0 = 3
                // 4.5 last 包含元素 2，且 4 - 1 = 3
                // 4.6 last 包含元素 3，且 5 - 2 = 3
                if (last.containsKey(x) && i - last.get(x) <= key){
                    // 返回 true
                    return true;
                }
                // 5. 将 元素 x 和 循环变量 i 分别存入 key 和 value
                // 5.1 存入 (1, 0)
                // 5.2 存入 (2, 1)
                // 5.3 存入 (3, 2)
                last.put(x, i);
            }
            // 还没找到就返回 false
            return false;
        */

        // 难点：判断 last 是否存在 x
        // 找到上一个值相等的 x 对应的索引 value
        // 判断 i - value >= key

        // 时间复杂度： O (n)，n 为 nums 长度
        // 空间复杂度： O (n)
    }
}
