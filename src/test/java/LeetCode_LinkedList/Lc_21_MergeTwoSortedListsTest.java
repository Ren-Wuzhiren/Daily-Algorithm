package LeetCode_LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Lc_21_MergeTwoSortedListsTest {

    private final Lc_21_MergeTwoSortedLists.Solution solution =
            new Lc_21_MergeTwoSortedLists().new Solution();

    private Lc_21_MergeTwoSortedLists.ListNode build(int... vals) {
        Lc_21_MergeTwoSortedLists.ListNode dummy =
                new Lc_21_MergeTwoSortedLists.ListNode();
        Lc_21_MergeTwoSortedLists.ListNode cur = dummy;
        for (int val : vals) {
            cur.next = new Lc_21_MergeTwoSortedLists.ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }

    private void assertMerged(int[] left, int[] right, int[] expected) {
        Lc_21_MergeTwoSortedLists.ListNode head =
                solution.mergeTwoLists(build(left), build(right));
        for (int val : expected) {
            assertEquals(val, head.val);
            head = head.next;
        }
        assertNull("链表比期望长", head);
    }

    @Test
    public void example1() {
        assertMerged(
                new int[] {1, 2, 4},
                new int[] {1, 3, 4},
                new int[] {1, 1, 2, 3, 4, 4});
    }

    @Test
    public void example2BothEmpty() {
        assertMerged(new int[] {}, new int[] {}, new int[] {});
    }

    @Test
    public void example3FirstEmpty() {
        assertMerged(new int[] {}, new int[] {0}, new int[] {0});
    }

    @Test
    public void edgeSecondEmpty() {
        assertMerged(new int[] {1, 2, 3}, new int[] {}, new int[] {1, 2, 3});
    }

    @Test
    public void edgeSingleNodes() {
        assertMerged(new int[] {1}, new int[] {2}, new int[] {1, 2});
    }

    @Test
    public void edgeDuplicates() {
        assertMerged(
                new int[] {2, 2},
                new int[] {2, 2},
                new int[] {2, 2, 2, 2});
    }

    @Test
    public void edgeNegativeValues() {
        assertMerged(
                new int[] {-3, -1, 2},
                new int[] {-2, 0, 3},
                new int[] {-3, -2, -1, 0, 2, 3});
    }
}
