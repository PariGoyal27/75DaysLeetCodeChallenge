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
        ListNode temp = head;
        int size = 1;
        while(temp.next != null){
            size++;
            temp = temp.next;
        }
        // Head needs to be deleted
        if(size == n) return head.next;
        
        temp = head;
        // reach just before the node to be deleted
        for(int i = 1; i < size - n; i++){
            temp = temp.next;
        }
       
        temp.next = temp.next.next;
        // temp.next = first.next;
        return head;
    }   
    // Using slow and fast pointer
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     if(head == null) return head;
    //     ListNode slow = head;
    //     ListNode fast = head;
    //     for(int i = 0; i < n && fast != null; i++){
    //         fast = fast.next;
    //     }
    //     if(fast == null){
    //         // head needs to be deleted
    //         return head.next;
    //     }
    //     while(fast.next != null){
    //         slow = slow.next;
    //         fast = fast.next;
    //     }
    //     //Now slow is just before the node to be deleted
    //     slow.next = slow.next.next;
    //     return head;
    // }  
}