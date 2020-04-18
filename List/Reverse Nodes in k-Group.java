class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //check corner case, need to cache head and k since you don't want them to be changed 
        //also find the next node after K nodes
        int times = k;
        ListNode tempHead = head;
        while(tempHead != null && times > 0){ //need to check tempHead == null 
            tempHead = tempHead.next;
            times--;
        }
        if(times == 0){ //times == 0 means there are k nodes. using iteration method to reverse linkedlist with size K
            tempHead = reverseKGroup(tempHead, k);
            ListNode cur = head, next = head.next;
            while(times ++ < k){
                next = cur.next;
                cur.next = tempHead;  //link with the node after K nodes
                tempHead = cur;
                cur = next;
            }
            return prev;  //return the head of the k size reversed linklist 
        }
        return head;
    }
}
