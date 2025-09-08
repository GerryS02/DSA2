import Linkedlist.Node;

// Given the head of a linked list, return the node where the cycle begins. If there is no 
// cycle, return null.

public class Solution {
    public Node detectCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            //if cycle is found
            if(slow == fast){
                slow = head; //reset slow to the head of the list

                //move both slow and fast one step at a time until they meet again at the cycle start
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; //return the slow (node where the cycle begins)
            }
        }

        return null; //if no cycle exist, return null
    }
}
