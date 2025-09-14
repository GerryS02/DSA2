import Linkedlist.Node;

public class Solution {
    public Node reverseDLL(Node head){
        Node currNode = head;
        Node backNode = null;

        while(currNode != null){
            backNode = currNode.prev; //save the current's prev (for later)

            //swap the prev and next pointers of the current node
            currNode.prev = currNode.next;
            currNode.next = backNode;

            //move to the "next" node in the original list (which is now currNode.prev after swapping)
            currNode = currNode.prev;
        }

        //at the end, the backNode would be the first of the list(reversed) and 
        // the new head of the reversed list is backNode.prev
        return backNode.prev;
    }
}
