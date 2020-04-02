class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            if(cur != null){ //when the pointer travers the null below leaf node, them push the value
                stack.push(cur);  //go fine the most left node
                cur = cur.left;  //go left
            }
            else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
