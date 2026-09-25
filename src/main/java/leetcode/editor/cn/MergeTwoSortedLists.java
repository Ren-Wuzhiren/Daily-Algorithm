package leetcode.editor.cn;

import java.util.*;

public class MergeTwoSortedLists {

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
    //leetcode submit region end(Prohibit modification and deletion)
    
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // put your test code here
        
    }
}