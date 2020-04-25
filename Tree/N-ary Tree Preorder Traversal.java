class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        stack.push(cur);
        while(!stack.empty()){
            cur = stack.pop();
            res.add(cur.val);
            int size = cur.children.size();
            for(int i = size - 1; i >= 0; i--){ //since we use stack so we need to add the children in the end first
                stack.push(cur.children.get(i));
            }
        }
        return res;
    }
}
