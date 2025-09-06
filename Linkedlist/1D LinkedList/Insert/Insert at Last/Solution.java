import Linkedlist.Node;
import static Linkedlist.LinkedList.head;

public class Solution {
    
    public void insertAtLast(int data){
        Node newNode = new Node(data); //create a new node

        //if the list is empty, make the new node the head node and return
        if(head == null){
            newNode = head;
            return;
        }

        //point the head to current node
        Node currNode = head;

        //while the current node is not the last node
        while(currNode.next != null){
            currNode = currNode.next; //increment the current node
        }

        //point the next of the current node to the new node
        currNode.next = newNode;
    }
}
