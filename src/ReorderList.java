//****************143. Reorder List
// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

// Example 1:
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]

// Example 2:
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
 
// Constraints:
// The number of nodes in the list is in the range [1, 5 * 104].
// 1 <= Node.val <= 1000
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode mid = findMidNode(head);
        ListNode temp = mid.next;
        mid.next = null;
        ListNode head1 = head;
        ListNode head2 = reverse(temp);
        ListNode origHead = new ListNode(-1);
        ListNode curr = origHead;
        while(head1!=null && head2!=null){
            ListNode temp1 = head1.next , temp2 = head2.next;
            
            curr.next = head1;
            curr.next.next = head2;
            head2.next = null;
            
            curr = head2;
            head2 = temp2;
            head1 = temp1;
        }
        if(head1!=null) curr.next = head1;
        if(head2!=null) curr.next = head2;
        
    }
    
    public ListNode findMidNode(ListNode head){
        if(head==null || head.next==null) return head;
        
        ListNode curr = head;
        ListNode fwd = head.next;
        while(fwd!=null && fwd.next!=null){
            curr = curr.next;
            fwd = fwd.next.next;
        }
        return curr;     
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
