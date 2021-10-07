//*****************82. Remove Duplicates from Sorted List II
// Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list. Return the linked list sorted as well.

// Example 1:
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]

// Example 2:
// Input: head = [1,1,1,2,3]
// Output: [2,3]

// Constraints:
// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.
public class RemoveDuplicatesFromSortedLists2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode curr = head, dummyHead=new ListNode(-1);
        ListNode dummyTail = dummyHead;
        
        while(curr!=null){
            if(curr.next!=null && curr.val==curr.next.val){
                int val = curr.val;
                while(curr!=null && curr.val==val)
                    curr=curr.next;
                continue;
            }
            dummyTail.next = curr;
            dummyTail=curr;
            curr=curr.next;
            dummyTail.next=null;
        }
        return dummyHead.next;
    }
    
    public ListNode addLast(ListNode tail,ListNode node){
        if(tail==null) return node;
        tail.next=node;
        tail=node;
        return tail;
    }
}
