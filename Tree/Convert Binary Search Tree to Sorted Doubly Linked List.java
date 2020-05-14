/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        int leftv = root.val;
        Node left = treeToDoublyList(root.left);
        int rightv = root.val;
        Node right = treeToDoublyList(root.right);
        root.left = root; //dp not forget this part! each node should connect circularly with itself first 
        root.right = root;
        return connect(connect(left, root), right);
    }
    private Node connect(Node n1, Node n2){
        if(n1 == null) return n2;
        if(n2 == null) return n1;
        int n1v = n1.val, n2v = n2.val;
        Node tail1 = n1.left; //the last element in the left part
        Node tail2 = n2.left; //the last element in the right part
        tail1.right = n2;
        n2.left = tail1;
        tail2.right = n1;
        n1.left = tail2;
        return n1;
    }
}
