class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);  //add value at the first position 
            if(cur.left != null) stack.push(cur.left);  //do not need to switch the order of left and right since first in last one. so the left one will be out afte the right. but it will be added before the right since res.add(0, val)
            if(cur.right != null) stack.push(cur.right);
        }
        return res;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        pre(root, res);
        return res;
    }
    private void pre(TreeNode root, List<Integer> res){
        if(root == null) return;
        pre(root.left, res);
        pre(root.right, res);
        res.add(root.val);
    }
}
