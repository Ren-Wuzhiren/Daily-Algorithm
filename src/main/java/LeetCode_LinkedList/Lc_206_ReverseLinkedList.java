package LeetCode_LinkedList;

public class Lc_206_ReverseLinkedList {

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
         * 词汇表：
         * - 三指针反转 → prev（前一个节点）/ curr（当前节点）/ next（后路）
         * - 先存后路 → ListNode next = curr.next;（改箭头前必须保存，否则丢链）
         * - 翻箭头 → curr.next = prev;
         * - 接力棒前进 → prev = curr; curr = next;
         * - 新头 → return prev;（循环结束时 curr == null，prev 停在最后一个节点）
         *
         * 一刷（9.11）踩坑：
         * 1. 初始想"两两交换"（behindTemp = head.next.next / 互相指）——方向错：反转是"每个节点指向前一个"，不是交换相邻节点
         * 2. 误以为会用到排序——排序按值重排，会破坏链结构，此题全程不比较任何值
         * 3. curr 起点写成 head.next → 节点 1 永远没人翻（最后成环）
         * 4. 翻转对象写成 head（应为 prev）→ 每个节点都指向节点 1，造环
         * 5. ListNode 定义在 Solution 内部 → 力扣报 "ListNode cannot be converted to Solution.ListNode"；
         *    ListNode 由平台提供，本地版要放在提交区域外、顶层
         * 结论：prev=null / curr=head / while(curr!=null)：先存 next，再 curr.next=prev，然后 prev=curr，curr=next；return prev。
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
