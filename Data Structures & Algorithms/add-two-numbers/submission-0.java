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
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode node = new ListNode(sum%10);
            if (first) { 
                head = node;
                first = false;
            }
            cur.next = node;
            cur = cur.next;
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            cur.next = node;
            cur = cur.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            l2 = l2.next;
            cur.next = node;
            cur = cur.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        return head;
    }
}
