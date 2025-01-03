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
    public int length(ListNode head){
        int counter = 0;
        while(head != null){
            counter++;
            head = head.next;
        }
        return counter;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int N = length(head);
        int groups = N/k;
        ListNode prevHead = null;
        ListNode ansHead = null;
        ListNode currHead = head;
        for(int i=0; i<groups; i++){
            ListNode prev = null;
            ListNode curr = currHead;
            ListNode next = null;
            for(int j=0; j<k; j++){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
           
            if(prevHead == null){
                ansHead = prev;
            }
            else{
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = curr;
        }
        if (prevHead != null) {
            prevHead.next = currHead;
        }

        return ansHead;
    }
}