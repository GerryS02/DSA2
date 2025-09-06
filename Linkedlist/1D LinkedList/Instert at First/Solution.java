import Linkedlist.Node;
import static Linkedlist.LinkedList.head;

class Solution{

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