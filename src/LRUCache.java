//**********146. LRU Cache
// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

// Implement the LRUCache class:

// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
// If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

// Example 1:

// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]

// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4
 

// Constraints:

// 1 <= capacity <= 3000
// 0 <= key <= 104
// 0 <= value <= 105
// At most 2 * 105 calls will be made to get and put.
import java.util.HashMap;
class LRUCache {

    public class Node {
        int data;
        int state;
        Node prev;
        Node next;

        public Node(int data, int state) {
            this.data = data;
            this.state = state;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public Node removeLast() {
        Node curr = this.tail;
        if (this.tail == null)
            return null;
        if (this.head == this.tail) {
            this.head = this.tail = null;
            return curr;
        }

        Node prev = curr.prev;
        prev.next = null;
        curr.prev = null;
        this.tail = prev;
        return curr;
    }

    public void addFirst(Node node) {
        if (this.head == null) {
            this.head = this.tail = node;
            return;
        }

        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    public Node removeNode(Node node) {
        if (node == this.tail) {
            return removeLast();

        }
        if (node == this.head) {
            Node temp = node.next;
            node.next = null;
            temp.prev = null;
            this.head = temp;
            return node;
        }

        Node prev = node.prev;
        Node fwd = node.next;
        prev.next = fwd;
        fwd.prev = prev;
        node.prev = node.next = null;
        return node;
    }

    private HashMap<Integer, Node> map;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        // list= new doublyList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {

            Node temp = map.get(key);
            temp = removeNode(temp);
            addFirst(temp);
            return temp.state;
        } else {

            return -1;
        }
    }

    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print("[" + temp.data + "," + temp.state + "] ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.state = value;
            temp = removeNode(temp);
            addFirst(temp);
            return;
        } else {
            if (this.capacity == 0) {

                Node temp = new Node(key, value);
                addFirst(temp);
                Node rm = removeLast();
                map.remove(rm.data, rm);
                map.put(temp.data, temp);
            } else {

                Node temp = new Node(key, value);
                addFirst(temp);
                map.put(key, temp);
                this.capacity--;

            }
        }
    }

}
/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */