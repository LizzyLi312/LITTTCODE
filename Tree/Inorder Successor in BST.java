class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        TreeNode prev = null, cur = root;
        while(cur != null){
            if(cur.val <= p.val){
                cur = cur.right;  //since root.val < p so we do not have to update prev 
            }
            else{ //the last update value should be the last one who is larger than p
                prev = cur;
                cur = cur.left; //cur.left < cur. so the diff between p is def smaller than cur
            }
        }
        return prev;
    }
}

//iterator inorder 
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        TreeNode cur = root;
        boolean flag = false;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.empty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            } 
            else{
                cur = stack.pop();
                if(cur.val == p.val) flag = true;
                if(flag == true && cur.val > p.val) return cur;
                cur = cur.right;
            }
        }
        return null;
    }
}

