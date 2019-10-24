//nth from the end of it 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if(head == null || head.next == null) return head;
        //find nth node
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null) return head.next;  //address the corner case, n = length of linkedlist
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        //remove it from the list
        slow.next = slow.next.next;
        return head;
    }
}

//One pass solution. Of course you could use dummy node.
//Time: O(length of linkedlist) space: O(1)
