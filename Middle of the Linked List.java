class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){  //this two conditions is and relationship
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null) return slow;
        else return slow.next;
    }
}
//if you wanna find the 1/3 point position in the linked list
//let fast move 3 steps while slow move one step each time
