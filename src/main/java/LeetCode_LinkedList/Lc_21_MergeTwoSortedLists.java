package LeetCode_LinkedList;

public class Lc_21_MergeTwoSortedLists {

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
         * - 合并结果的占位头 -> ListNode dummy = new ListNode();
         * - 合并结果的末尾 -> ListNode tail = dummy;
         * - 选择较小的当前节点 -> if (list1.val <= list2.val)
         * - 接上被选中的节点 -> tail.next = list1;
         * - 只移动被选中的链表 -> list1 = list1.next;
         * - 接上剩余整段 -> tail.next = list1 != null ? list1 : list2;
         * - 返回真正的头 -> return dummy.next;
         *
         * 一刷（9.25）踩坑：
         * 1. 误把 tail.next 接成当前节点的后继，而不是当前节点本身；
         * 2. 选择一边后错误地让两边交叉前进，导致原链表断链；
         * 3. 通过 L3 参考理解 dummy + tail 后，合并逻辑跑通。
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode tail = dummy;

            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                }
                tail = tail.next;
            }

            tail.next = list1 != null ? list1 : list2;
            return dummy.next;
        }
    }
}
