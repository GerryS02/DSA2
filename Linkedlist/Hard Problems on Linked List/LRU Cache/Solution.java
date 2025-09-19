import java.util.HashMap;

class LRUCache {

    //implementing LRU Chace using doubly linked for quick access to the most and least recently used items
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            next = prev = null;
        }
    }

    //create dummy head and tail nodes
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    int limit; //max capacity of the cache
    HashMap<Integer, Node> m = new HashMap<>();  //the HashMap provides fast O(1) lookups to find the node by key.

    //add a new node right after the head (most recently used)
    void addNode(Node newNode){
        Node nextNode = head.next;

        head.next = newNode;
        nextNode.prev = newNode;

        newNode.prev = head;
        newNode.next = nextNode;
    }

    //remove a node from the doubly linked list
    void delNode(Node oldNode){
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public LRUCache(int capacity) {
        limit = capacity;

        //initially, link head to tail and tail to head
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        //if the key doesn't exist in the cache, return -1
        if(!m.containsKey(key)){
            return -1;
        }

        Node ansNode = m.get(key); //fetch the node with the given key
        int ans = ansNode.val; //get the value associated with the key

        //remove the node from its current position in the doubly linked list
        delNode(ansNode);

        //add the node to the front (mark it as most recently used)
        addNode(ansNode);

        return ans;
    }
    
    public void put(int key, int value) {
        //if the key already exists in the cache, remove it first
        if(m.containsKey(key)){
            Node oldNode = m.get(key);
            delNode(oldNode);
            m.remove(key);
        }

        //if the cache is full, remove the least recently used (LRU) node (which is the node just before tail)
        if(m.size() == limit){
            m.remove(tail.prev.key);
            delNode(tail.prev);
        }

        //create a new node with the given key and value and add to the front
        Node newNode = new Node(key, value);
        addNode(newNode);
        m.put(key, newNode);
    }
}
