class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode newHead = null;
        if(l1.val <= l2.val){
            newHead = l1;
            l1 = l1.next; //!! 
        }
        else{
            newHead = l2;
            l2 = l2.next;
        }
        ListNode cur = newHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;  //!!
        }
        if(l1 != null) cur.next = l1;
        if(l2 != null) cur.next = l2;
        return newHead;
    }
}
//Without using dummy node
//do not have to keep the l1 and l2 
