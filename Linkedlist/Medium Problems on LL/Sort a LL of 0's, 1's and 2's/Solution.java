import Linkedlist.Node;

public class Solution {
    public Node sortList(Node head){
        if(head == null && head.next == null) return head;

        //create dummy nodes for 0, 1, and 2
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);

        //pointers to the current end of each list
        Node zeroTail = zero;
        Node oneTail = one;
        Node twoTail = two;

        Node curr = head;

        //distribute nodes into 0, 1, and 2 lists
        while(curr != null){
            if(curr.data == 0){
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if(curr.data == 1){
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else{
                twoTail.next = curr;
                twoTail = twoTail.next;
            }

            curr = curr.next;
        }

        //merge the three lists

        zeroTail.next = (one.next != null) ? one.next : two.next; ////link 0 list with 1 or 2
        oneTail.next = two.next; //link 1 list with 2 list
        twoTail.next = null; //terminate the third list

        return zero.next; //return the sorted list (skipping the dummy node)
    }
}
