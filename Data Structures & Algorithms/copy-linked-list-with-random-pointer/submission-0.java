/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node head1 = head;
        Node head2 = head;
        Node prev = new Node(0);
        boolean first = true;
        while (head != null) {
            Node node = new Node(head.val);
            if (first) {
                head2 = prev;
                first = !first;
            };
            map.put(head,node);
            prev.next = node;
            prev = prev.next;
            head = head.next;
        }

        head = head1;

        while (head != null) {
            Node node = map.get(head);
            node.random = map.get(head.random);
            head = head.next;
        }
        return head2 == null ? null : head2.next;
    }
}
