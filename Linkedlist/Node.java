package Linkedlist;

public class Node{
        public int data;
        public TreeNode next;
        public TreeNode prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null; //for doubly linked list
        }

        public Node(int data, TreeNode next){
            this.data = data;
            this.next = next;
        }

        public Node(int data, TreeNode next, TreeNode prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }