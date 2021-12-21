//*************641. Design Circular Deque
// Design your implementation of the circular double-ended queue (deque).
// Implement the MyCircularDeque class:
// MyCircularDeque(int k) Initializes the deque with a maximum size of k.
// boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
// boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
// boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
// boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
// int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
// int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
// boolean isEmpty() Returns true if the deque is empty, or false otherwise.
// boolean isFull() Returns true if the deque is full, or false otherwise.

// Example 1:
// Input
// ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull",
// "deleteLast", "insertFront", "getFront"]
// [[3], [1], [2], [3], [4], [], [], [], [4], []]
// Output
// [null, true, true, true, false, 2, true, true, true, 4]
// Explanation
// MyCircularDeque myCircularDeque = new MyCircularDeque(3);
// myCircularDeque.insertLast(1);  // return True
// myCircularDeque.insertLast(2);  // return True
// myCircularDeque.insertFront(3); // return True
// myCircularDeque.insertFront(4); // return False, the queue is full.
// myCircularDeque.getRear();      // return 2
// myCircularDeque.isFull();       // return True
// myCircularDeque.deleteLast();   // return True
// myCircularDeque.insertFront(4); // return True
// myCircularDeque.getFront();     // return 4
 
// Constraints:
// 1 <= k <= 1000
// 0 <= value <= 1000
// At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.
public class DesignCircularDeque {
    int[]arr;
    int top;
    int rear;
    int size = 0;
    int capacity = 0;
    public MyCircularDeque(int k) {
        arr = new int[k];
        top = -1;
        rear = arr.length;
        capacity=k;
    }
    
    public boolean insertFront(int value) {
        if(size==capacity) return false;
        if(size==0){
            rear = 0;
            top = 0;
        }
        else if(top+1==arr.length) top = 0;
        else top++;
        arr[top] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size==capacity) return false;
        if(size==0){
            rear = 0;
            top = 0;
        }
        else if(rear==0) rear = arr.length-1;
        else rear--;
        arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0) return false;
        
        if(top==0) top = arr.length-1;
        else top--;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size==0) return false;
        
        if(rear==arr.length-1) rear = 0;
        else rear++;
        size--;
        return true;
    }
    
    public int getFront() {
        if(size==0) return -1;
        return arr[top];
    }
    
    public int getRear() {
        if(size==0) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}
