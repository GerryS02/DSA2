import Linkedlist.Node;

// Given the head of a doubly linked list and an integer target. Delete all nodes in the linked 
// list with the value target and return the head of the modified linked list.

public class Solution {
    public Node deleteAllOccurrences(Node head, int target){
        Node curr = head;

        while(curr != null){
            //if curr is the head node, update the head pointer
            if(head.data == target){

                if(head == curr){
                    head = head.next;
                }

                //get references to the next and previous nodes
                Node nextNode = curr.next;
                Node prevNode = curr.prev;

                //remove curr node from the linked list
                if(nextNode != null) nextNode.prev = prevNode;
                if(prevNode != null) prevNode.next = nextNode;

                curr = nextNode; //move curr to the next node in the list
            } else{
                //if the current node doesn't match the target, just move to the next node
                curr = curr.next;
            }
        }

        return head;
    }
}
