/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return new int[]{-1, -1};

        List<Integer> pos = new ArrayList<>();
        ListNode t = head.next;
        int prev = head.val;
        int cnt = 2;
        int min = Integer.MAX_VALUE, prevPos = -1;
        while (t.next != null) {
            if (prev < t.val && t.val > t.next.val) {
                pos.add(cnt);
                if (prevPos != -1) 
                    min = Math.min(min, cnt - prevPos);
                prevPos = cnt;
            }
            else if (prev > t.val && t.val < t.next.val) {
                pos.add(cnt);
                if (prevPos != -1) 
                    min = Math.min(min, cnt - prevPos);
                prevPos = cnt;
            }
            cnt++;
            prev = t.val;
            t = t.next;
        }

        return pos.size() >= 2 ? new int[]{min, pos.get(pos.size() - 1) - pos.get(0)} : new int[]{-1, -1};
    }
}
