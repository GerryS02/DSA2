import Linkedlist.Node;

public class Solution {
    public int length(Node head){
        int count = 0;
        Node temp = head;

        while(temp != null){
            temp = temp.next;
            count++;
        }

        return count;
    }

    public Node getIntersectionNode(Node headA, Node headB){
        int l1 = length(headA);
        int l2 = length(headB);

        int d = 0;
        Node ptr1;
        Node ptr2;

        if(l1 > l2){
            d = l1-l2;
            ptr1 = headA;
            ptr2 = headB;
        } else{
            d = l2-l1;
            ptr1 = headB;
            ptr2 = headA;
        }

        while(d>0){
            ptr1 = ptr1.next;

            if(ptr1 == null){
                return null;
            }

            d--;
        }

        while(ptr1 != null && ptr2 != null){
            if(ptr1 == ptr2){
                return ptr1;
            }
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return null;
    }
}
