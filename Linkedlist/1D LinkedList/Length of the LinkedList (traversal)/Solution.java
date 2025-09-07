import Linkedlist.Node;

public class Solution {
    public int getLenght(Node head){
        int len = 0;

        //if the list is empty, the length is 0
        if(head == null) return 0;

        //while the list is empty
        while(head != null){
            head = head.next; //move the head forward
            len++; //increment the length
        }

        return len;
    }
}
