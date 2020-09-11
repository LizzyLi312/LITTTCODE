class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root == null) return -1;
        TreeNode cur = root;
        TreeNode res = root;
        double diff = Math.abs(target - root.val); //do not assign Integer.Max_value. since the diff could be larger than it
        while(cur != null){
            if(cur.val == target) return cur.val;
            if(diff > Math.abs(target - cur.val)){
                res = cur;
                diff = Math.abs(target - cur.val);
            }
            if(target > cur.val) cur = cur.right;
            else cur = cur.left;
        }
        return res.val;
    }
}
