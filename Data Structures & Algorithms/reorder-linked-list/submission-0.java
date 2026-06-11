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
    public void reorderList(ListNode head) {
        // Find mid node
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        // Separate second half as a LinkedList
        slow.next = null;
        ListNode cur = null;

        // Reverse second half

        while(head2 != null) {
            ListNode temp = head2;
            head2 = head2.next;
            temp.next = cur;
            cur = temp;
        }
        // Merge 2 lists alternatively
        int i = 1;
        while (cur != null && head != null) {
            if (i%2 != 0) {
                ListNode temp2 = cur;
                ListNode temp1 = head;
                head = head.next;
                cur = cur.next;
                temp1.next = temp2;
                temp2.next = head;
            }
        }
    }
}
