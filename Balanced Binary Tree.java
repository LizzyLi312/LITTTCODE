class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;  //base case. If the recursion could reach the null below leaf node, then it never returned false. So it is balanced
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left - right) > 1) return false;
        return isBalanced(root.right) && isBalanced(root.left);  //check if left subtree and right subtree is balanced or not
        //else return true; is not right. cause it only check the right subtree
    }
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;  //need the maximum length
    }
}

//balanced binary tree: the depth bewteen left subtree and right subtree is no greater than 1
//time: O(nlogn)
