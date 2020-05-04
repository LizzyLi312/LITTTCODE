class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){ //fine the next non repeating character
                cur = cur.next;
            }
            if(prev.next == cur) prev = cur;
            else prev.next = cur.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
/*
remove duplicate: 
  case1: only 2 duplicate. store a prev value
  case2: multiple dupliates. using while loop to find the next non repeating position
*/
