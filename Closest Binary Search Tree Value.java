public static int closestValue(TreeNode root, double target) {
    if(root == null) return root.val;
    double res = 0;
    while(root != null){
        if(root.val == target) return root.val;
        if(Math.abs(res - target) > Math.abs(res - root.val))
            res = root.val;
        root = target < root.val ? root.left : root.right;
    }
    return (int) res;
}
