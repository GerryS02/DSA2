import Linkedlist.Node;

class Solution{
    public Node reverseList(Node head){
        Node prev = null; //initialize the previous pointer as null
        Node curr = head; //set current pointer to the head of the list
        Node nextptr; //temporary pointer to hold the next node

        //traverse the linked list until we reach the end
        while(curr != null){
            nextptr = curr.next; //set the next pointer next to the curr node
            curr.next = prev; //reverse the current node's next pointer

            prev = curr; //move the previous pointer to the current node
            curr = nextptr; //move the current pointer to the next node
        }

        //return the new head of the reversed list
        return prev;
    }
}