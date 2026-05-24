package LeetCode_Queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfRecentCounterTest {
    /*
        示例 1：
        输入：
                ["RecentCounter", "ping", "ping", "ping", "ping"]
                [[], [1], [100], [3001], [3002]]
        输出：
                [null, 1, 2, 3, 3]
    */
    @Before
    public void setUp() {
        NumberOfRecentCounter.RecentCounter();
    }

    @Test
    public void Test() {
        assertEquals(1, NumberOfRecentCounter.ping(1));
        assertEquals(2, NumberOfRecentCounter.ping(100));
        assertEquals(3, NumberOfRecentCounter.ping(3001));
        assertEquals(3, NumberOfRecentCounter.ping(3002));
    }
}