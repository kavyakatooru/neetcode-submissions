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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head; 
        head= head.next;
        while (slow != head) {
            if (head == null || head.next == null) return false;
            slow = slow.next;
            head = head.next.next;
            if (slow == head) return true;
        }
        return true; 
    }
}
