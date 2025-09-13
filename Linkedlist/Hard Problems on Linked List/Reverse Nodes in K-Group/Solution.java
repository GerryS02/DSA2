import Linkedlist.Node;

public class Solution {
    public Node reverseKGroup(Node head, int k){
        Node temp = head;
        int count = 0;

        //check if the list have k nodes
        while(count < k){
            if(temp == null) return head;

            temp = temp.next;
            count++;
        }

        Node prevNode = reverseKGroup(temp, k);

        temp = head; count = 0;

        while(count < k){
            Node next = temp.next;
            temp.next = prevNode;

            prevNode = temp;
            temp = next;

            count++;
        }

        return prevNode;
    }
}
