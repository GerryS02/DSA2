import Linkedlist.Node;

public class Solution {
    public Node deleteAtLast(Node head){
        //if the list is empty or there's only one node, return null 
        if(head == null || head.next == null){
            return null;
        }

        Node curr = head;

        //traverse to the last node
        while(curr.next != null){
            curr = curr.next;
        }

        //move the prev node's next to null (removing tail)
        curr.prev.next = null;
        curr.prev = null; //break the backward link from the tail node

        return head;
    }
}
