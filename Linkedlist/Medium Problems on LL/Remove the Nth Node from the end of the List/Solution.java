import Linkedlist.Node;

class Solution{
    public Node removeNthFromEnd(Node head, int n){
        //if the list has only one node, return null after removing it
        if(head.next == null) return null;

        //find the size of the list
        int size = 0;
        Node curr = head;

        while(curr != null){
            curr = curr.next;
            size++;
        }

        //if the size of the list is equal to n, remove the first node
        if(size == n) return head.next;

        int indexToDel = size-n; //calculate the index of the node to be deleted
        int i = 1;
        Node prev = head;

        //traverse the list to reach the node just before the one to be deleted
        while(i < indexToDel){
            prev = prev.next;
            i++;
        }

        //delete the Nth node by changing the link of the prev node to the next node
        prev.next = prev.next.next;

        return head; //return the modified list
    }
}