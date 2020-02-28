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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node cur = stack.pop();
            res.add(0, cur.val);
            int size = cur.children.size();
            for(int i = 0; i < size; i++){
                stack.push(cur.children.get(i));
            }
        }
        return res;
    }
}
