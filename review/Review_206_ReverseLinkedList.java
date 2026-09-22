// 复习档案 · 2026-09-22 四刷 · 结果：🟡 L1 提示后 AC（1min50s，3/7 档续，9.25 重写）
// 主体五步无提示恢复；循环结束后误返回 curr，L1 后改为 prev，6 个测试全绿
// 历史：2026-09-19 三刷 · 🟡 L1+L2 后 AC（累计16min）；2026-09-14 二刷 · 🟡 提示后 AC（11min）
public class Review_206_ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        /**
         * 复习重写 · 2026-09-22 · 第 4 轮（L1 后 AC）
         */
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}
