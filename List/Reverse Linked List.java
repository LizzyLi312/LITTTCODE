//iteration
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

//recursion
public ListNode reverse(ListNode head) {
	if (head == null || head.next == null) return head;
	ListNode newHead = reverse(head.next); //recursive from the end to the beginning; the next should be the new next!
	reverse(head);
	head.next.next = head;
	head.next = null;
	return newHead;  //the final result, always not be changed
}

//newHead: the last one always return the new head 
