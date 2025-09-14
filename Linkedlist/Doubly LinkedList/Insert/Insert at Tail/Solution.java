import Linkedlist.Node;

public class Solution {
    public Node insertAtTail(Node head, int x){
        Node newNode = new Node(x);

        if(head == null){
            head = newNode;
        }

        Node curr = head;
        //go to the next node
        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.prev = curr;

        return head;
    }
}
