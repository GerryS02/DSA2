import Linkedlist.Node;

// Given the head of a singly linked list, find the length of the loop in the linked list if it
// exists. Return the length of the loop if it exists; otherwise, return 0.

public class Solution {
    public int findLenghtOfLoop(Node head){
        Node slow = head;
        Node fast = head;

        while(head != null && head.next != null){
            slow = slow.next;
            fast = fast.next.next;

            //if cycle is detected
            if(slow == fast){
                int len = 1; //start counting from the meeting point
                Node curr = slow.next; //start from the next node of slow

                //move around the cycle and count the nodes until we come back to the starting point
                while(curr != slow){
                    curr = curr.next;
                    len++;
                }

                //return the length of the cycle
                return len;
            }
        }

        //if cycle is not detected, return 0;
        return 0;
    }
}
