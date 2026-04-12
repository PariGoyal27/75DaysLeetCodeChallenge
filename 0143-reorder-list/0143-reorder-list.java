/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//1. reach middle
//2. reverse second half
//3. merge both parts alternately

class Solution {
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        //1.find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }        
        //reverse second half
        ListNode second = reverse(slow.next);
        slow.next = null; //breaking the list

        //now merge both the halves alternately bcz list is like
        // 1 2 3 4 --> 1 2 4 3 --> 1 4 2 3(required) [1 2] [4 3]
        ListNode first = head;
        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}