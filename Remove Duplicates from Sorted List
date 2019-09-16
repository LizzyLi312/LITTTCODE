class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        while(cur.next != null){
            ListNode next = cur.next;
            if(cur.val == next.val) cur.next = next.next;
            else cur = cur.next; 
        }
        return head;
    }
}

//Using while loop to skip all the duplicates 
//time:O(n)
