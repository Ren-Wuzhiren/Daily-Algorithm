package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RemoveElementTest {

    /*
        27. 移除元素
        原地移除所有数值等于 val 的元素，返回新长度 k；
        要求 nums 前 k 位包含所有不等于 val 的元素（顺序可任意）。
    */

    private final RemoveElement.Solution solution = new RemoveElement().new Solution();

    /**
     * 复刻评测机逻辑：
     * 1. k 必须等于期望长度；
     * 2. 排序 nums 前 k 位后，必须与期望数组一致。
     */
    private void assertRemove(int[] nums, int val, int[] expectedNums) {
        int k = solution.removeElement(nums, val);
        assertEquals(expectedNums.length, k);
        int[] prefix = Arrays.copyOfRange(nums, 0, k);
        Arrays.sort(prefix);
        Arrays.sort(expectedNums);
        assertArrayEquals(expectedNums, prefix);
    }

    @Test
    public void example1() {
        // nums = [3,2,2,3], val = 3 -> k = 2, 前 2 位为 [2,2]
        assertRemove(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2});
    }

    @Test
    public void example2() {
        // nums = [0,1,2,2,3,0,4,2], val = 2 -> k = 5, 前 5 位为 [0,1,3,0,4]
        assertRemove(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 1, 3, 0, 4});
    }

    // TODO: 补边界用例（取消注释并确认断言后跑测试）
    @Test
    public void emptyArray() {
        // 空数组：k 应为 0
        assertRemove(new int[]{}, 1, new int[]{});
    }

    @Test
    public void noValExists() {
        // val 不在数组中：k 应等于数组长度
        assertRemove(new int[]{1, 2, 3}, 9, new int[]{1, 2, 3});
    }

    @Test
    public void allVal() {
        // 全部等于 val：k 应为 0
        assertRemove(new int[]{2, 2, 2}, 2, new int[]{});
    }

    @Test
    public void singleElement() {
        // 单元素：等于 / 不等于 val 两种情况
        assertRemove(new int[]{1}, 1, new int[]{});
        assertRemove(new int[]{1}, 2, new int[]{1});
    }
}
