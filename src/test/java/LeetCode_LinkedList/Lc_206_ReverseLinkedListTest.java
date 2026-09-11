package LeetCode_LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class Lc_206_ReverseLinkedListTest {

    private final Lc_206_ReverseLinkedList.Solution solution =
            new Lc_206_ReverseLinkedList().new Solution();

    private Lc_206_ReverseLinkedList.ListNode build(int... vals) {
        Lc_206_ReverseLinkedList.ListNode dummy = new Lc_206_ReverseLinkedList.ListNode();
        Lc_206_ReverseLinkedList.ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new Lc_206_ReverseLinkedList.ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private void assertReverse(int[] input, int[] expected) {
        Lc_206_ReverseLinkedList.ListNode head = solution.reverseList(build(input));
        for (int v : expected) {
            assertNotNull("链表比期望短", head);
            assertEquals(v, head.val);
            head = head.next;
        }
        assertNull("链表比期望长（可能成环或多余节点）", head);
    }

    @Test
    public void example1() {
        assertReverse(new int[] {1, 2, 3, 4, 5}, new int[] {5, 4, 3, 2, 1});
    }

    @Test
    public void example2() {
        assertReverse(new int[] {1, 2}, new int[] {2, 1});
    }

    @Test
    public void example3Empty() {
        assertReverse(new int[] {}, new int[] {});
    }

    @Test
    public void edgeSingleNode() {
        assertReverse(new int[] {7}, new int[] {7});
    }

    @Test
    public void edgeTwoNodes() {
        assertReverse(new int[] {1, 2}, new int[] {2, 1});
    }

    @Test
    public void edgeNegativeValues() {
        assertReverse(new int[] {-1, -2, -3}, new int[] {-3, -2, -1});
    }
}
