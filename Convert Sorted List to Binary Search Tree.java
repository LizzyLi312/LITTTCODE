class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return dfs(head, null);
    }
    private TreeNode dfs(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head == tail) return null;
        while(fast.next != tail && fast.next.next != tail){ //find the middle to be the root since BST is sorted 
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(head, slow);  //should always be in the left part
        root.right = dfs(slow.next, tail);
        return root;
    }
}
