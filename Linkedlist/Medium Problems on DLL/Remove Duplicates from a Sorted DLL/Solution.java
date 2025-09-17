import Linkedlist.Node;

class Solution {
    public Node removeDuplicates(Node head){
        //if the list is empty or has only one node, return it
        if(head == null || head.next == null){
            return head;
        }

        Node curr = head;

        while(curr != null){
            Node nextNode = curr.next;

            //check if the current node has a duplicate
            while(nextNode != null && curr.data  == nextNode.data){
                //skip the duplicate node by adjusting the next pointer
                nextNode = nextNode.next;
            }

            //if nextNode is not null, link the current node to the next non-duplicate node
            curr.next = nextNode;
            if(nextNode != null){
                nextNode.prev = curr;
            }

            curr = curr.next; //move to the next unique node
        }

        return head;
    }
}
