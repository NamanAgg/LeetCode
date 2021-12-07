//**************1290. Convert Binary Number in a Linked List to Integer
// Given head which is a reference node to a singly-linked list.
// The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
// Return the decimal value of the number in the linked list.

// Example 1:
// Input: head = [1,0,1]
// Output: 5
// Explanation: (101) in base 2 = (5) in base 10

// Example 2:
// Input: head = [0]
// Output: 0

// Example 3:
// Input: head = [1]
// Output: 1

// Example 4:
// Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
// Output: 18880

// Example 5:
// Input: head = [0,0]
// Output: 0

// Constraints:
// The Linked List is not empty.
// Number of nodes will not exceed 30.
// Each node's value is either 0 or 1.
public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        head = reverse(head);
        int ans = 0;
        int count = 0;
        while(head!=null){
            ans += (int)(Math.pow(2,count)*head.val);
            count++;
            head = head.next;
        }
        return ans;
    }
    
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        
        return prev;
    }
}
