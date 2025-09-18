import Linkedlist.Node;

public class Solution {
    public Node mergeLists(Node l1, Node l2){
        Node dummy = new Node(-1);
        Node curr = dummy;

        while(l1 != null && l2 != null){

            if(l1.data <= l2.data){
                curr.next = l1;
                l1 = l1.next;
            } else{
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if(l1 != null){
            curr.next = l1;
        } else{
            curr.next = l2;
        }

        return dummy.next;
    }
}
