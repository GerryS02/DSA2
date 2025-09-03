import Linkedlist.Node;

class Solution{

   private Node head;  // Declare the head of the linked list

   public Solution() {
      head = null;  // Initialize head to null (empty list)
   }

   public void addAtFirst(int data){
      Node newNode = new Node(data);
      if(head == null){
         newNode = head;
         return;
      }

      newNode.next = head;
      head = newNode;
   }
}