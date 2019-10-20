class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        //create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //find the start node and the node before it
        ListNode cur = head, pre = dummy;
        for(int i = 1; i < m; i++){
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        ListNode start = cur, cur2 = cur.next;
        //find the end node and the node after it
        for(int i = 0; i < n - m; i++){
            start = cur2;
            cur2 = cur2.next;
        }
        start.next = null;
        //reverse
        ListNode temp_newHead = reverse(cur);
        //link
        pre.next = temp_newHead;
        cur.next = cur2;
        return dummy.next;
        
    }
    private ListNode reverse(ListNode head){
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

//need to use dummy node. otherwise it will throw nullpointerexception
//if the range is (n,m). then you need to keep the #n-1 node and #node
