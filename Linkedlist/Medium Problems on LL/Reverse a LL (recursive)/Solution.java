import Linkedlist.Node;

public class Solution {
    public Node reverseList(Node head){
        //if the list is empty or has only one node, return the head as it is
        if(head == null || head.next == null) return head;

        //ecursively reverse the rest of the list starting from the second node
        Node newHead = reverseList(head.next);

        //change the link of the first node
        head.next.next = head;
        head.next = null;

        //return the new head of the reversed list
        return newHead;
    }
}
