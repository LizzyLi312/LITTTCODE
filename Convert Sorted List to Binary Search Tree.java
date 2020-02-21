class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return dfs(head, null);
    }
    private TreeNode dfs(ListNode head, ListNode tail){ 
        if(head == tail) return null;  //if there is nothing in the linkedlist then return null
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != tail && fast.next.next != tail){ //find the middle to be the root since BST is sorted
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);  //every parent node should be the middle of the children nodes
        root.left = dfs(head, slow);  //should always be in the left part
        root.right = dfs(slow.next, tail);
        return root;
    }
}

//the numbers of node at left side and the right side are the same so it can make sure
