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
    private int findLength(ListNode head){
        ListNode temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    private ListNode deleteAndAdd(ListNode head){
        ListNode temp = head;
        ListNode prev = head;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.next = head;
        return head = temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int n = findLength(head);
        k = k % n;
        // delete from end -> insert from front
        for(int i = 0; i < k; i++){
            head = deleteAndAdd(head);
        }
        return head;
    }
}