/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstNode = findNode(dummy, m - 1); //prev1
        ListNode end = findNode(dummy, n); //prev2
        ListNode start = firstNode.next; //cur1
        ListNode secondNode = end.next; //cur2
        
        firstNode.next = null;
        end.next = null;
        
        ListNode newHead = reverse(start);
        firstNode.next = newHead;
        start.next = secondNode;
        return dummy.next;
    }
    private ListNode findNode(ListNode head, int count){
        while(count-- > 0){
            head = head.next;
        }
        return head;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null, cur = head, next = null;
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
