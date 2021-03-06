//bc the order property in BST then the left side is always the smallest. So we should travers left side then root, then right side
//left++. traversal tree
//when root has right side then push it into the stack
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushNode(root);
    }
    private void pushNode(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        if(temp.right != null) pushNode(temp.right); 
        return temp.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
