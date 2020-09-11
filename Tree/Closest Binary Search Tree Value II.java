class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                if(res.size() < k) res.add(cur.val);
                else{
                    if(Math.abs(res.get(0) - target) > Math.abs(target - cur.val)){
                        res.remove(0);
                        res.add(cur.val);
                    }
                }
                cur = cur.right;
            }
        }
        return res;
    }
}

//recursive
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        helper(root, res, target, k);
        return res;
    }
    private void helper(TreeNode root, List<Integer> list, double target, int k){
        if(root == null) return;
        helper(root.left, list, target, k);
        if(list.size() < k) list.add(root.val);
        else{ 
            if(root.val <= target){
                list.remove(0);
                list.add(root.val);
            }
            else{
                if(Math.abs(list.get(0) - target) > Math.abs(root.val - target)){
                    list.remove(0);
                    list.add(root.val);
                }
                else return;
            }
        }
        helper(root.right, list, target, k);
    }
}
