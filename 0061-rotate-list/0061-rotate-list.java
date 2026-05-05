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
        if(k == 0 || head == null || head.next == null) return head;
        int len = 1;
        ListNode temp = head;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        k = k % len;
        if(k == 0) return head;

        //now temp is at the end
        temp.next = head; // all nodes linked
        // now it is a circular linked list - where temp is at the end
        // observe that the head is kth node from end at the end
        // so we have to traverse from head till (len - k - 1)th node to reach node just before the new head
        ListNode tail = head;
        for(int i = 1; i <= len - k - 1; i++){
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
}
// class Solution {
//     private int findLength(ListNode head){
//         ListNode temp = head;
//         int cnt = 0;
//         while(temp != null){
//             cnt++;
//             temp = temp.next;
//         }
//         return cnt;
//     }
//     private ListNode deleteAndAdd(ListNode head){
//         ListNode temp = head;
//         ListNode prev = head;
//         while(temp.next != null){
//             prev = temp;
//             temp = temp.next;
//         }
//         prev.next = null;
//         temp.next = head;
//         return head = temp;
//     }
//     public ListNode rotateRight(ListNode head, int k) {
//         if(head == null || head.next == null) return head;
//         int n = findLength(head);
//         k = k % n;
//         // delete from end -> insert from front
//         for(int i = 0; i < k; i++){
//             head = deleteAndAdd(head);
//         }
//         return head;
//     }
// }