class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode mid = findMid(head);
        mid = reverse(mid);
        head = merge(head, mid);
    }
    //find the middle, there are 2 situations. there # of node is odd or is even
    //cant use the count++ and find the middle it could cause out of memory error
    //useing slow and fast two pointers to find the middle node. AND remeber to cut the linked list
    private ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;  //cut it here
        return temp;  
    }
    //reverse Linked List
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode cur = node;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    //merge 2 linked list without dummy node
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode cur = l1;
        l1 = l1.next;
        while(l1 != null && l2 != null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        return cur;
    }
}
