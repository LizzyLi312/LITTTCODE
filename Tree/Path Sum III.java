class Solution {
    private int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return find(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum); //top-down solution
    }
    private int find(TreeNode root, int sum){
        if(root == null) return 0; //base case
        if(root.val == sum) return (1 + find(root.left, sum - root.val) + find(root.right, sum - root.val)); 
        else return find(root.left, sum - root.val) + find(root.right, sum - root.val);

    }
}
