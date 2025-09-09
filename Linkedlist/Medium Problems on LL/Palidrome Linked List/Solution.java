import Linkedlist.Node;

class Solution{
    public Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

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
        if(head == null || head.next == null){
            return true;
        }

        Node middle = findMiddle(head);
        Node secHandStart = reverse(head.next);
        Node firstHandStart = head;

        while(secHandStart != null){
            if(secHandStart.data != firstHandStart.data){
                return false;
            }

            firstHandStart = firstHandStart.next;
            secHandStart = secHandStart.next;
        }

        return true;
    }
}