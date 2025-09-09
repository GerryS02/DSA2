import Linkedlist.Node;

class Solution{
    //function to find the middle node of the linked list using Hare and Tortoise approach
    public Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //function to reverse the linked list
    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node nextptr;

        while(curr != null){
            nextptr = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextptr;
        }

        return prev;
    }

    public boolean isPalidrome(Node head){
        //if the list is empty or has only one element, it's considered a palindrome
        if(head == null || head.next == null){
            return true;
        }

        //ind the middle of the linked list
        Node middle = findMiddle(head);
        //reverse the second half of the list starting from the node after middle
        //and set a pointer to the start of the second half (reversed) list
        Node secHandStart = reverse(head.next);
        //set a pointer for the start of first half of the list
        Node firstHandStart = head;

        //compare the two halves of the list
        while(secHandStart != null){
            //if values don't match, it's not a palindrome
            if(secHandStart.data != firstHandStart.data){
                return false;
            }

            //move the both pointers forward
            firstHandStart = firstHandStart.next;
            secHandStart = secHandStart.next;
        }

        return true; //if no mismatch found, it's a palindrome
    }
}