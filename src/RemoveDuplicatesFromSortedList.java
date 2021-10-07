//************83. Remove Duplicates from Sorted List
// Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
// Return the linked list sorted as well.

// Example 1:
// Input: head = [1,1,2]
// Output: [1,2]

// Example 2:
// Input: head = [1,1,2,3,3]
// Output: [1,2,3]

// Constraints:
// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
          ListNode curr = head.next, prev=head;
        ListNode origHead = prev;
        while(curr!=null){
            if(curr.val!=prev.val)
                prev = addLast(prev,curr);
            curr=curr.next;
        }
        prev.next=null;
        return head;
    }
    
    public ListNode addLast(ListNode tail,ListNode node){
        if(tail==null) return node;
        tail.next=node;
        tail=node;
        return tail;
    }
}
