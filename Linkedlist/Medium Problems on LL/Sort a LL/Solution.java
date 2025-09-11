import Linkedlist.Node;

public class Solution {
    private Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Node merge(Node left, Node right){
        Node dummy = new Node(-1); //create a dummy node to help build the result list
        Node curr = dummy; //current pointer to build the merged list

        //compare nodes from both lists and append the smaller node to the result
        while(left != null && right != null){
            if(left.data <= right.data){
                curr.next = left; //if left's value is smaller or equal, append it to result
                left = left.next; //move to the next node in left list
            } else{
                curr.next = right; //if right's value is smaller, append it to result
                right = right.next; //move to the next node in right list
            }

            curr = curr.next; //move the current pointer forward
        }

        //if there are remaining nodes in either list, append them to result
        if(left != null){
            curr.next = left;
        } else{
            curr.next = right;
        }

        return dummy.next; //return the sorted list starting from the first node
    }

    public Node sortList(Node head){
        //if the list is empty or has only one element, it's already sorted
        if(head == null || head.next == null) return head;

        //find the middle of the list
        Node middle = findMiddle(head);
        //get the node after the middle
        Node nextToMiddle = middle.next;
        middle.next = null; //split the list into two halves

        //recursively sort the left and right halves
        Node left = sortList(head);
        Node right = sortList(nextToMiddle);

        //merge the two sorted halves and return the result
        return merge(left, right);
    }
}
