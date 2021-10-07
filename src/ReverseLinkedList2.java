//***************92. Reverse Linked List II
// Given the head of a singly linked list and two integers left and right where left <= right,
// reverse the nodes of the list from position left to position right, and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]

// Example 2:
// Input: head = [5], left = 1, right = 1
// Output: [5]
 
// Constraints:
// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n

// Follow up: Could you do it in one pass?
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt=0;
        ListNode curr=null,dum1=null,dum2=null,dum3=null,dum4=null;
        
        curr=head;
        ListNode nxt=null;
        while(curr!=null){
            // System.out.println(curr.val);
            nxt = curr.next;
            cnt++;
            if(cnt!=left){
                if(dum1==null && dum2==null){
                    dum1=curr;
                    dum2=curr;
                    dum2.next=null;
                }
                else{
                    dum2.next=curr;
                    dum2=curr;
                    dum2.next=null;
                }
                curr=nxt;
            }
            else{
                while(cnt++<=right){
                    // System.out.println(curr.val+" yeet");
                    nxt = curr.next;
                    if(dum3==null && dum4==null){
                        dum3=curr;
                        dum4=curr;
                        curr.next=null;
                        curr=nxt;
                    }
                    else{
                        curr.next=dum3;
                        dum3=curr;
                        curr=nxt;
                    }
                }
                if(dum2==null){
                    dum1=dum3;
                }
                else dum2.next=dum3;
                dum2=dum4;
                curr=nxt;
            }
        }
        
        return dum1;
    }
}
