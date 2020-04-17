//O(nlogn) merge sort
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head, slow = head, prev = null;
         //find the middle 
        while(fast != null &&fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; //need to disconnect
        //then split
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        //merge 
        return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next; //remember to move it to the next pointer
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2; //add the reminding element 
        return dummy.next;
    }
}
