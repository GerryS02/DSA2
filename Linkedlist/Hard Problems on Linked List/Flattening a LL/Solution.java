// Flatten a special linked list where each node has a next pointer to the next list and a child
// pointer to a sorted sublist, into one sorted list using child pointers

class Solution {
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.child = l1;
                curr = l1;
                l1 = l1.child;
            } else{
                curr.child = l2;
                curr = l2;
                l2 = l2.child;
            }

            curr.next = null;
        }

        if(l1 != null){
            curr.child = l1;
        } else{
            curr.child = l2;
        }

        return dummy.child;
    }

    public ListNode flattenLinkedList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mergedHead = flattenLinkedList(head.next);

        return merge(head, mergedHead);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}