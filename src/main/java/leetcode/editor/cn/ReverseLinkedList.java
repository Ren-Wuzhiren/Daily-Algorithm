package leetcode.editor.cn;

import java.util.*;

public class ReverseLinkedList {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

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
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // put your test code here
        testExample1();
        testExample2();
        testExample3();
    }


    public static void testExample1() {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode head = buildList(new int[] {1, 2, 3, 4, 5});
        ListNode result = solution.reverseList(head);          // 返回新头节点
        System.out.println("result = " + printList(result));   // 遍历打印
    }

    public static void testExample2() {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode head = buildList(new int[] {1, 2});
        System.out.println("result = " + printList(solution.reverseList(head)));
    }

    public static void testExample3() {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode head = buildList(new int[] {});               // 空链表
        System.out.println("result = " + printList(solution.reverseList(head)));
    }

    /** 用数组建一个链表，返回头节点 */
    public static ListNode buildList(int[] nums) {
        ListNode dummy = new ListNode();     // 哑节点：省去"第一个节点"的特判
        ListNode cur = dummy;
        for (int v : nums) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    /** 遍历链表，拼成 "[1, 2, 3]" 这样的字符串 */
    public static String printList(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(", ");
            }
            head = head.next;
        }
        return sb.append("]").toString();
    }
}

// 本地编译/运行用的 ListNode 定义：位于提交区域之外，提交时不会上传，LeetCode 用平台自带的 ListNode
class ListNode {
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
