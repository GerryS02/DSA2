import Linkedlist.Node;

// You are given the head of a singly linked list and an integer key.
// Return true if the key exists in the linked list, otherwise return false.

class Solution {
    public boolean search(Node head, int key){
        Node curr = head;

        while(curr != null){
            if(curr.data == key){
                return true;
            }

            curr = curr.next;
        }


        return false;
    }
}
