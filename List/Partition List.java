class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode bigger = new ListNode(0);
        ListNode smaller = new ListNode(0);
        ListNode cur_bigger = bigger;
        ListNode cur_smaller = smaller;
        // ListNode cur = head;  //do not need to keep the old head reference
        while(head != null){
            if(head.val >= x){
                cur_bigger.next = head;
                cur_bigger = cur_bigger.next;
            } 
            else{
                cur_smaller.next = head;
                cur_smaller = cur_smaller.next;
            } 
            head = head.next;
        }
        cur_smaller.next = bigger.next;
        cur_bigger.next = null;  //remeber to add the null pointer in the end. Otherwise the outof memory error could occur
        return smaller.next;
    }
}

//create 2 new linked lists to partition 
