class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int count = 1;
        ListNode cur = head;
        while(cur.next != null){ //get the length of the list, and it needs to be initilize as 1. since it starts from the head listnode
            cur = cur.next;
            count++;
        }
        ListNode slow = head;
        for(int i = 0; i < count - k % count - 1; i++){ //k % count to make it a circular list. -1 means the slow.next will be the new head 
            slow = slow.next;
        }
        cur.next = head; //cur stops at the last node which should connect to the head node
        head = slow.next; //head = new head
        slow.next = null; // disconnect it avoid the circal
        return head;
    }
}
