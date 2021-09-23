//**********25. Reverse Nodes in k-Group
// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
// k is a positive integer and is less than or equal to the length of the linked list.
// If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]

// Example 2:
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

// Example 3:
// Input: head = [1,2,3,4,5], k = 1
// Output: [1,2,3,4,5]

// Example 4:
// Input: head = [1], k = 1
// Output: [1]

// Constraints:
// The number of nodes in the list is in the range sz.
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz

// Follow-up: Can you solve the problem in O(1) extra memory space?
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int K) {
        int len = length(head);
        
        ListNode curr = head, ph=null,pt=null;
        
        while(len-K>=0){
            ListNode th=null,tt=null;
            int k = K;
            while(k-->0){
                ListNode temp = curr.next;
                if(th==null){
                    th=tt=curr;
                    curr.next=null;
                }
                else{
                    curr.next=th;
                    th=curr;
                }
                curr=temp;
            }
            
            if(ph==null){
                ph=th;
                pt=tt;
            }
            else{
                pt.next=th;
                pt=tt;
            }
            
            len-=K;
        }
        
        if(len>0) pt.next=curr;
        
        return ph;
    }
    
    public int length(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}
