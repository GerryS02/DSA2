import Linkedlist.Node;

public class Solution {
    public Node deleteMiddle(Node head){
        if(head == null || head.next == null) return null;

        Node prev = null;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;

            slow = slow.next;
        }

        prev.next = prev.next.next;

        return head;
    }
}
