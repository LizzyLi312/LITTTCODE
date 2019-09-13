n/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        ListNode insert = null;
        ListNode cur = head;
        while(cur != null){
            start = dummy;
            while(start.next != null && cur.val > start.next.val){
                start = start.next;
            }
            insert = cur;
            cur = cur.next;
            insert.next = start.next;
            start.next = insert;
        }
        return dummy.next;
    }
}

//time: O(n^2)
