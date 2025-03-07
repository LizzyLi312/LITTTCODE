// inorder traversal : when you need to visit node in order 

class Solution {
    Node head;
    Node tail;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        
        dfs(root);

        tail.right = head;
        head.left = tail;
        
        return head;
    }

    private void dfs(Node root) {
        if (root == null) return;
       
        dfs(root.left);
        
        if (head == null) { // 1 time process when we got the most left node we can store it as head
            head = root;
        } 

        if (tail != null) {
            tail.right = root;
            root.left = tail;
        }
        tail = root;
        dfs(root.right);
    }
}
