//using fast and slow pointer.
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;  
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){  //remember to the fast.next != null. otherwise casue time exceed. maybe
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
//using hashset to deduplicate
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();
        while(head != null && head.next != null){
            if(set.contains(head)) return true;
            else set.add(head);
            head = head.next;
        }
        return false;
    }
}
//to be updated: add visited in the field
