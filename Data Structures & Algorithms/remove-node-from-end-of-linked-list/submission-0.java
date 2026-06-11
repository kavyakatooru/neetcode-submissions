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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;

        ListNode dummy = head;
        while (dummy.next != null) {
            dummy = dummy.next;
            len++;
        }
        dummy = new ListNode(0);
        dummy.next = head;
        int i = 0;

        while (i < len - n) {
            dummy = dummy.next;
            i++;
        }
        if (dummy.next == null) return head;
        if (dummy.next == head) {
            head = head.next;
        }else {
            dummy.next = dummy.next.next;
        }

        return head;

    }
}
