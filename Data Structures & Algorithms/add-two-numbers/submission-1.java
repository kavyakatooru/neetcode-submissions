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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        int carry = 0;
        boolean first = true;
        ListNode cur = new ListNode(0);
        while (l1 != null || l2 != null || carry != 0) {
            int i = l1 != null ? l1.val : 0;
            int j = l2 != null ? l2.val : 0;
            int sum = i + j + carry;
            ListNode node = new ListNode(sum%10);
            if (first) { 
                head = node;
                first = false;
            }
            cur.next = node;
            cur = cur.next;
            carry = sum/10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return head;
    }
}
