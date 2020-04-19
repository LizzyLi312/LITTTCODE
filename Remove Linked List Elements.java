class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0); //need to add dummy node since if there are duplicates and they both need to be deleted
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;  //need to keep 2 variables
        while(cur != null){
            if(cur.val == val) pre.next = cur.next;
            else pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
