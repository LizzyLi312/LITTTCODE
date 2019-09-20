class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

//find the 2 new head, and cache them
//connect the next odd/even one first and then move the pointer to the next one
//the pointer stays on the new linked list, not the old order list 

//Or using dummy node to create 2 linked lists: odd list & even list
