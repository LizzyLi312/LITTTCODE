class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        left(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        right(root.right, res);
        return res;
    }
    private void left(TreeNode root, List<Integer> res){
        if(root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if(root.left != null) left(root.left, res);
        else left(root.right, res);
    }
    private void right(TreeNode root, List<Integer> res){
        //need to do it reversely. from bottom to the top. so after we reach the node at the bottom then we add it. 
        //or we can use a stack
        if(root == null || (root.left == null && root.right == null)) return;
        if(root.right != null) right(root.right, res);
        else right(root.left, res);
        res.add(root.val);
    }
    private void leaves(TreeNode root, List<Integer> res){
        if(root == null) return;
        if(root.left == null && root.right == null){
            res.add(root.val);
            return;
        }
        leaves(root.left, res);
        leaves(root.right, res);
    }
}
