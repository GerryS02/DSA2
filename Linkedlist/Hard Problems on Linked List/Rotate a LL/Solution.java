import Linkedlist.Node;

// Given the head of a linked list, rotate the list to the right by k places.

public class Solution {
    public Node findNthNode(Node head, int n){
        int count = 1;

        while(count < n){
            head = head.next;
            count++;
        }

        return head;
    }
    public Node rotateRight(Node head, int k){
        if(head == null || k == 0) return head;

        int len = 1;
        Node tail = head;

        //get the last node of the list
        while(tail.next != null){
            tail = tail.next;
            len++;
        }

        //if k is the multiple of the length, the list will be rotated to the original list
        if(k % len == 0){
            return head;
        }

        k = k % len;

        tail.next = head; //link tail to the head;

        Node newLastNode = findNthNode(head, len-k);

        head = newLastNode.next;
        newLastNode.next = null;

        return head;
    }
}
