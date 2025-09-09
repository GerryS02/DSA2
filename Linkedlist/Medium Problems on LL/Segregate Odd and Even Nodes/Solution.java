import Linkedlist.Node;

public class Solution {
    public Node oddEvenList(Node head){
        //if the list is empty or has only one node, no rearrangement is needed
        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head; //the first node is the odd indexed node
        Node even = head.next; //the sec node is the neven indexed node
        Node evenHead = even; //store the first even node

        while(even != null && even.next != null){
            //ink the current odd and even nodes to their next odd and even nodes
            odd.next = odd.next.next;
            even.next = even.next.next;

            //move the odd/even pointer to the next odd/even node
            odd = odd.next;
            even = even.next;
        }

        //connect the last odd node to the first even node
        odd.next = evenHead;

        return head;
    }
}
