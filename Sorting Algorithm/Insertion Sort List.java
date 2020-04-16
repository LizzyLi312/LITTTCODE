//using dummy node. one LinkedList
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head.next, prev = head; //need to know the previous node and current node so we can insert 
        while(cur != null){ 
            if(prev.val > cur.val){
                ListNode temp = fetchNode(prev, cur); //take the node out
                insert(dummy, temp); //insert it into the right position
                cur = prev; //put the cur pointer at the right position. since after insert the cur pointer could be moved to the front
            }
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
    private ListNode fetchNode(ListNode prev, ListNode cur){ 
        prev.next = cur.next; //cut the prev and cur connection
        cur.next = null; //cut the cur and cur.next connection
        return cur;
    }
    private void insert(ListNode dummy, ListNode node){
        ListNode pre = dummy, cur = dummy.next;
        while(cur.val < node.val){ //find the insert position
            pre = cur;
            cur = cur.next;
        }
        node.next = cur;
        pre.next = node;
    }
}
//time: O(n^2)
