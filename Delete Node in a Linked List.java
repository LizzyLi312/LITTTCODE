class Solution {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

//remove the node, but you dont know the head
//so assign the value to remove it 
