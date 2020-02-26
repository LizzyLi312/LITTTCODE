class Solution {
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        Integer totalSize = helper(root, k);
        return totalSize == null ? res : -1;  //flag, if totalSize == null, then found the kth 
    }
    private Integer helper(TreeNode root, int k){
        if(root == null) return 0;
        Integer leftSize = helper(root.left, k);
        if(leftSize == null) return null; // as a flag
        if(k == leftSize + 1){  //+1 means root itself
            res = root.val;
            return null;  //as a flag
        }
        Integer rightSize = helper(root.right, k - leftSize - 1);
        return rightSize == null ? null : (leftSize + rightSize + 1);  //return to parent node 
    }
}

//BST. SORTED! if the there is no left child then the parent node is def smaller than the right child
//DFS. calculate the number of the nodes. 
//
