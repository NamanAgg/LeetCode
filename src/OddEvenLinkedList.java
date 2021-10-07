//************328. Odd Even Linked List
// Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices,
// and return the reordered list.
// The first node is considered odd, and the second node is even, and so on.
// Note that the relative order inside both the even and odd groups should remain as it was in the input.
// You must solve the problem in O(1) extra space complexity and O(n) time complexity.

// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]

// Example 2:
// Input: head = [2,1,3,5,6,4,7]
// Output: [2,3,6,7,1,5,4]

// Constraints:
// n == number of nodes in the linked list
// 0 <= n <= 104
// -106 <= Node.val <= 106

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode even = evenHead;
        ListNode curr = head;
        int cnt=0;
        while(curr!=null){
            cnt++;
            if(cnt%2==0){
                even.next=curr;
                even=curr;
            }
            else{
                odd.next=curr;
                odd=curr;
            }
            curr=curr.next;
        }
        even.next=null;
        odd.next=null;
        evenHead=evenHead.next;
        oddHead=oddHead.next;
        odd.next=evenHead;
        return oddHead;
    }
}
