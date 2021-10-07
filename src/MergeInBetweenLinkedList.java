//***************1669. Merge In Between Linked Lists
// You are given two linked lists: list1 and list2 of sizes n and m respectively.
// Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
// The blue edges and nodes in the following figure incidate the result:
// Build the result list and return its head.

// Example 1:
// Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
// Output: [0,1,2,1000000,1000001,1000002,5]
// Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place.
// The blue edges and nodes in the above figure indicate the result.

// Example 2:
// Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
// Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
// Explanation: The blue edges and nodes in the above figure indicate the result.

// Constraints:
// 3 <= list1.length <= 104
// 1 <= a <= b < list1.length - 1
// 1 <= list2.length <= 104
public class MergeInBetweenLinkedList {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        a++;
        b++;
        ListNode dummyHead = new ListNode();
        ListNode tail = findTail(list2);
       
        dummyHead.next = list1;
        int cnt=0;
        ListNode curr = dummyHead;
        while(curr!=null){
            cnt++;
            if(cnt==a){
                ListNode store = curr;
             
                curr=curr.next;
                while(cnt++<=b){
                    curr=curr.next;
                }
               
                store.next = list2;
                tail.next= curr;
                break;
            }
            curr=curr.next;
        }
        
        return dummyHead.next;
    }
    
    public ListNode findTail(ListNode head){
        while(head.next!=null)
            head=head.next;
        
        return head;
    }
}
