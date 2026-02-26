package Linkedlist;

public class LinkedList {
    public static Node head;  // Declare the head of the linked list

    // Constructor
    public LinkedList() {
        head = null;  // Initialize head to null (empty list)
    }

    // Other common methods like printList, getLength, etc. can be added here
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
