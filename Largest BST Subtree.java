//use the property of bst. compare the left subtree and right subtree's value
//so make a wrapper 
class Solution {
    private class Result{
        public int min, max, size;
        public Result(int min, int max, int size){
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    private int res = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        find(root);
        return res;
    }
    private Result find(TreeNode root){
        if(root == null) return new Result(0,0,0);
        Result left = find(root.left);
        Result right = find(root.right);
        if(left == null || right == null) return null; //if one side is null means that side is not BST, so we cut it 
        int size = 1;
        if((left.size == 0 || left.max < root.val) && (right.size == 0 || right.min > root.val)){ //BST
            size = left.size + 1 + right.size;
            res = Math.max(res, size);
        }
        else return null; //no BST
        int min = (left.size > 0) ? left.min : root.val; //keep min for the left side
        int max = (right.size > 0) ? right.max : root.val;  //keep max for the right side 
        return new Result(min, max, size);
    }
}
