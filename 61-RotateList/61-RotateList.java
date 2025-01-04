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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int length = 1;
        if (head == null || head.next == null || k == 0) return head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        k = k % length;
        if(k==0) return head;
        temp.next = head;
        ListNode end = head;
        for(int i=1; i<length-k; i++){
            end = end.next;
        }
        ListNode start = end.next;
        end.next = null;
        return start;
    }
}