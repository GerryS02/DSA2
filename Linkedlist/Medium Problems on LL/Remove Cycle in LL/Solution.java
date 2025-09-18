import Linkedlist.Node;

class Solution{
    public Node removeCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                Node prev = null;

                while(slow != fast){
                    slow = slow.next;
                    prev = fast; //store the last value of the fast pointer
                    fast = fast.next;
                }

                prev.next = null;
            }
        }

        return head;
    }
}