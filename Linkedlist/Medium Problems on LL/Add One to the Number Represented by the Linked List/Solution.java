import Linkedlist.Node;

//Add one to a number represented as a singly linked list of digits and return the updated list

public class Solution {
    //recursive function to add carry from the last digit
    public int addCarry(Node head){
        //base case: if we reach end, return carry = 1 (since we add one)
        if(head == null) return 1;

        //else, get carry(1) from next node
        int carry = addCarry(head.next);
        
        //add carry(1) to current digit
        head.data = head.data + carry;

        //after adding the carry(1), if no new carry added, stop here
        if(head.data < 10){
            return 0;
        }

        //else set the value of the node to be 0 and return carry to be 1
        head.data = 0;

        return 1;
    }

    public Node addOne(Node head){
        //start recursion and get final carry
        int carry = addCarry(head);

        //if carry remains, add new node at the front
        if(carry == 1){
            Node newHead = new Node(1);
            newHead.next = head;

            return newHead;
        }

        //otherwise return the updated list
        return head;
    }
}
