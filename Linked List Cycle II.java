//Given a linked list, return the node where the cycle begins. If there is no cycle, return null
//HashSet
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        Set<ListNode> set = new HashSet<>();
        while(head != null && head.next != null){
            if(set.contains(head)) return head;
            else set.add(head);
            head = head.next;
        }
        return null;
    }
}
//slow fast pointers work the same, return the node when slow == fast
