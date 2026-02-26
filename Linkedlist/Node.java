package Linkedlist;

public class Node{
        public int data;
        public Node next;
        public Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null; //for doubly linked list
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public Node(int data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }