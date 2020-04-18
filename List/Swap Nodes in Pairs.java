//e.g. [1,2,3,4] after the head = null return null. then temp  = null, head = 3
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = swapPairs(head.next.next);  //the temp is not the new head anymore 
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = temp;
        return newHead;
    }
}
