package LeetCode_Queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class Lc_3829_DesignRideSharingSystemTest {
    @Test
    public void testExample1() {
        // 手动创建两个队列，因为构造器需要它们
        Deque<Integer> riderQueue = new ArrayDeque<>();
        Deque<Integer> driverQueue = new ArrayDeque<>();
        Lc_3829_DesignRideSharingSystem system = new Lc_3829_DesignRideSharingSystem();
        system.addRider(3);
        system.addDriver(2);
        system.addRider(1);
        assertArrayEquals("第一次匹配", new int[]{2, 3}, system.matchDriverWithRider());
        system.addDriver(5);
        system.cancelRider(3);           // 3 已被匹配，等待集合里没有 3，取消无效
        assertArrayEquals("第二次匹配", new int[]{5, 1}, system.matchDriverWithRider());
        assertArrayEquals("第三次匹配", new int[]{-1, -1}, system.matchDriverWithRider());
    }
    @Test
    public void testExample2() {
        Deque<Integer> riderQueue = new ArrayDeque<>();
        Deque<Integer> driverQueue = new ArrayDeque<>();
        Lc_3829_DesignRideSharingSystem system = new Lc_3829_DesignRideSharingSystem();
        system.addRider(8);
        system.addDriver(8);
        system.addDriver(6);
        assertArrayEquals("第一次匹配", new int[]{8, 8}, system.matchDriverWithRider());
        system.addRider(2);
        system.cancelRider(2);           // 2 被取消，下一次匹配时应该没有可用乘客
        assertArrayEquals("第二次匹配", new int[]{-1, -1}, system.matchDriverWithRider());
    }
}


