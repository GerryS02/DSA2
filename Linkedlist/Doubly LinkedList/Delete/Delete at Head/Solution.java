import Linkedlist.Node;

public class Solution {
    public Node deleteAtHead(Node head){
        //if there's only one node, delete that note and return empty list(null)
        if(head.next == null) return null;

        Node temp = head;
        head = head.next; //move the head forward to the next node

        //delete the temp node by changing the links to the next node
        head.prev = null;
        temp.next = null;

        return head;
    }
}
