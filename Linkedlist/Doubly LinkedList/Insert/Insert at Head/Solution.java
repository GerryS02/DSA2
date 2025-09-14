import Linkedlist.Node;

public class Solution {
    public Node insertAtHead(Node head, int x){
        Node newNode = new Node(x);

        if(head == null){
            head = newNode;
        } else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        return head;
    }
}
