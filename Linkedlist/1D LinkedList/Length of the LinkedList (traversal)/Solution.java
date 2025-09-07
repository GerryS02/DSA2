import Linkedlist.Node;

public class Solution {
    public int getLenght(Node head){
        int len = 0;

        //if the list is empty, the length is 0
        if(head == null) return 0;

        Node curr = head; //pointer to track the nodes

        //traverse the list until the end
        while(curr != null){
            curr = curr.next; //move to the next node
            len++; //increment the length
        }

        return len;
    }
}
