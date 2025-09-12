import Linkedlist.Node;

class Solution{
    public Node addTwoNumbers(Node l1, Node l2){
        Node head = null;

        int val = 0;
        int carry = 0;
        Node prev = null;
        Node curr = null;

        while(l1 != null || l2 != null || carry != 0){
            val = carry; //start from the carry

            //add value from l1 if available
            if(l1 != null){
                val += l1.data;
                l1 = l1.next;
            }

            //add value from l2 if available
            if(l2 != null){
                val += l2.data;
                l2 = l1.next;
            }

            //calculate new carry and digit
            carry = val / 10;
            val = val % 10;

            //create new node with the digit
            curr = new Node(val);

            //if it is the first node, set it as head
            if(prev == null){
                head = curr;
            } else{ //otherwise, link the new node
                prev.next = curr;
            }

            prev = curr; //move prev pointer forward
        }

        return head;
    }
}