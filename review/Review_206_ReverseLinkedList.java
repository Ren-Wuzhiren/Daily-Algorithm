// 复习档案 · 2026-09-14 二刷 · 结果：🟡 提示后 AC（11min，升 3/7 档）
// 首版③④两行接错对象（prev=next / next=curr.next）→ curr 不前进 + 死循环；提示后修正
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
         * 复习重写 · 2026-09-14 · 第 2 轮
         */
        public ListNode reverseList(ListNode head) {
            // 无提示重写：三指针全部凭记忆
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
