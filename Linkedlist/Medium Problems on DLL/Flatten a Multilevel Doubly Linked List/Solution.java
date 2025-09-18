class Solution{
    public Node flatten(Node head){
        if(head == null) return null;

        Node curr = head;

        while(curr != null){
            //if the current node has a child node (i.e., nested list)
            if(curr.child != null){
                //step 1: Flatten the child list recursively
                Node nextNode = curr.next; //save the next node in the list

                //connect the current node to the flattened child list
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;

                //step 2: Find the last node of the newly flattened list
                while(curr.next != null){
                    curr = curr.next;
                }

                //step 3: Reconnect the flattened child list with the next node
                if(nextNode != null){
                    curr.next = nextNode;
                    nextNode.prev = curr;
                }

            }

            //if the current node do not have a child nod, move to the next node in the list
            curr = curr.next;
        }

        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};