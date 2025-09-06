import Linkedlist.Node;
import static Linkedlist.LinkedList.head;

class Solution {
    public void deleteAtFirst(){
        //if the list is empyt, retun
        if(head == null){
            System.out.println("The list is empty");
            return;
        }

        //move the head to the second element
        head = head.next;
    }
}
