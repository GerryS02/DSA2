import Linkedlist.Node;
import static Linkedlist.LinkedList.head;

class Solution {
    public void deleteAtLast(){
        //if the list is empyt, retun
        if(head == null){
            System.out.println("The list is empty");
            return;
        }

        //if there is just one node, remove that one node
        if(head.next == null){
            head = null;
        }

        Node secondLast = head; //initialize a second last node 
        Node lastNode = head.next; //initialize a last node

        //traverse the list to find second last and last nodes
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        //point the second last node to null
        secondLast.next = null;
    }
}
