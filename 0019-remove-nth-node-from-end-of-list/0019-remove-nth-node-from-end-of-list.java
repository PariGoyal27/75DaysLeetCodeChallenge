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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < n && fast != null; i++){
            fast = fast.next;
        }
        if(fast == null){
            // head needs to be deleted
            return head.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        //Now slow is just before the node to be deleted
        slow.next = slow.next.next;
        return head;
    }   
}