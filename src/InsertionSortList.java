//***************147. Insertion Sort List
// Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
// The steps of the insertion sort algorithm:
// Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
// At each iteration, insertion sort removes one element from the input data,
// finds the location it belongs within the sorted list and inserts it there.
// It repeats until no input elements remain.
// The following is a graphical example of the insertion sort algorithm. The partially sorted list (black)
// initially contains only the first element in the list. One element (red) is removed from the input data and
// inserted in-place into the sorted list with each iteration.

// Example 1:
// Input: head = [4,2,1,3]
// Output: [1,2,3,4]

// Example 2:
// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]

// Constraints:
// The number of nodes in the list is in the range [1, 5000].
// -5000 <= Node.val <= 5000
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head.next;
        ListNode ansHead = head;
        head.next = null;
        
        while(curr!=null){
            int val = curr.val;
            ListNode  nxt = curr.next;
            curr.next = null;
            if(ansHead.val>val){
                curr.next = ansHead;
                ansHead = curr;
            }
            else{
                ListNode prev = ansHead;
                ListNode node = prev;
                while(node!=null){
                    if(node.val>val){
                        prev.next = curr;
                        curr.next = node;
                        break;
                    }
                    else{
                        prev = node;
                        node = node.next;
                    }
                }
                
                if(curr.next==null)
                    prev.next = curr;
            }
            curr = nxt;
        }
        
        return ansHead;
    }
}
