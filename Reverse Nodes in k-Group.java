class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //check corner case, need to cache head and k since you don't want them to be changed 
        //also find the next node after K nodes
        int times = k;
        ListNode tempHead = head;
        while(tempHead != null && times > 0){
            tempHead = tempHead.next;
            times--;
        }
        if(times == 0){
        //using iteration method to reverse linkedlist with size K
            tempHead = reverseKGroup(tempHead, k);
            ListNode cur = head, next = head.next;
            while(times ++ < k){
                next = cur.next;
                cur.next = tempHead;  //link with the node after K nodes
                tempHead = cur;
                cur = next;
            }
            head = tempHead;  //start next reverse
        }
        return head;
    }
}