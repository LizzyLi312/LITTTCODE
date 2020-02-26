class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];  
        res[0] = 1;
        diam(root, res);
        return res[0] - 1;  //since when root == null return 1. so the degree of leaf node is 1, but it should be 0
    }
    private int diam(TreeNode root, int[] res){
        if(root == null) return 0;  //base case
        int right = diam(root.right, res);
        int left = diam(root.left, res);
        res[0] = Math.max(left + right + 1, res[0]);  //the res so far
        return Math.max(left, right) + 1;  //the max depth of each branch 
    }
}

//DFS
//calculate subtree using each node as root the diameter. and then return the maximum 
