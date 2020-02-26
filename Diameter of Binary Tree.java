class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];  
        res[0] = 1;
        diam(root, res);
        return res[0] - 1;  //the return value is the number of the node, the number of edge = number of node -1 
    }
    private int diam(TreeNode root, int[] res){
        if(root == null) return 0;  //base case
        int right = diam(root.right, res);
        int left = diam(root.left, res);
        res[0] = Math.max(left + right + 1, res[0]);  //the res so far, plus 1 means the root itself 
        return Math.max(left, right) + 1;  //the max depth of each branch, plus 1 means the root itself 
    }
}

//DFS
//calculate subtree using each node as root the diameter. and then return the maximum 
