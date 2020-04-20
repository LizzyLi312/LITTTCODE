class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0 ) return null;
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        for(ListNode l : lists){
            if(l != null) pq.offer(l); //l would be null [[], [1]]
        }
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            cur.next = temp;
            if(temp.next != null) pq.offer(temp.next);
            cur = cur.next;
        }
        return dummy.next;
    }
}
