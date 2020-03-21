class Solution {
    public List<TreeNode> generateTrees(int n) {
        return gen(1, n);
    }
    private List<TreeNode> gen(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = gen(start, i - 1);
            List<TreeNode> right = gen(i + 1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
