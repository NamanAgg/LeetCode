// 23. Merge k Sorted Lists
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6

// Example 2:
// Input: lists = []
// Output: []

// Example 3:
// Input: lists = [[]]
// Output: []

// Constraints:
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] is sorted in ascending order.
// The sum of lists[i].length won't exceed 10^4.
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head =null,tail=null;
        PriorityQueue<ListNode> que = new PriorityQueue<>((a,b)->{
           return a.val-b.val; 
        });
        
        for(ListNode h : lists)
            if(h!=null) que.add(h);
        
        
        while(que.size()!=0){
            ListNode temp = que.remove();
            if(head==null && tail==null){
                head=temp;
                tail=temp;
            }
            else{
                tail.next=temp;
                tail = temp;
            }
            if(temp.next!=null) que.add(temp.next);
            temp.next=null;
        }
        
        return head;
    }
}
