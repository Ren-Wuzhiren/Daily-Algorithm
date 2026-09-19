// 复习档案 · 2026-09-19 三刷 · 结果：🟡 L1+L2 提示后 AC（累计16min，3/7 档续，9.22 重写）
// 起点与循环四拍恢复；最初漏“从 head 起”并交叉覆盖 next，最终只漏 return prev
// 历史：2026-09-14 二刷 · 🟡 提示后 AC（11min，升 3/7 档）
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
         * 复习重写 · 2026-09-19 · 第 3 轮（L1+L2 后 AC）
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
