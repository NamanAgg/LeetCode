//************24. Swap Nodes in Pairs
// Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying
// the values in the list's nodes (i.e., only nodes themselves may be changed.)

// Example 1:
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]

// Example 2:
// Input: head = []
// Output: []

// Example 3:
// Input: head = [1]
// Output: [1]

// Constraints:
// The number of nodes in the list is in the range [0, 100].
// 0 <= Node.val <= 100
public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode dummy= new ListNode(-1);
        ListNode dummy_head=dummy;
        while(curr!=null && curr.next!=null){
            ListNode temp1=curr;
            ListNode temp2=curr.next;
            ListNode temp3= curr.next.next;
            dummy.next=temp2;
            temp2.next=temp1;
            temp1.next=null;
            dummy=temp1;
            curr=temp3;
        }
        if(curr!=null) dummy.next=curr;
        
        return dummy_head.next;
    }
}
