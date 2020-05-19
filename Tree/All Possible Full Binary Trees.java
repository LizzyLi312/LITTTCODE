//recursion
class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N == 1){ //base case 
            res.add(new TreeNode(0));
            return res;
        }
        for(int i = 1; i <= N - 1 - 1; i++){ //possible number of nodes on the left. since we need at lease one node on one side. 
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1); //number of nodes in right: N - 1(root) - i(nodes on the left)
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
