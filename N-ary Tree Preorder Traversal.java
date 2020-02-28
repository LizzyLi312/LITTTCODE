/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        pre(root, res);
        return res;
    }
    private void pre(Node root, List<Integer> res){
        if(root == null) return;
        Node cur = root;  
        Stack<Node> stack = new Stack<>();
        stack.push(cur);
        while(!stack.isEmpty()){
            cur = stack.pop();
            res.add(cur.val);
            int size = cur.children.size();
            for(int i = size - 1; i >= 0; i--){  //first in last out
                stack.push(cur.children.get(i));
            }
        }
    }
}
