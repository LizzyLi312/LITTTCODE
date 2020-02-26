class Solution {
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        Integer totalSize = helper(root, k);
        return totalSize == null ? res : -1;  //flag, if totalSize == null, then found the kth 
    }
    private Integer helper(TreeNode root, int k){
        if(root == null) return 0;
        Integer leftSize = helper(root.left, k);  //need to be initialized with Integer since int only can be number. but Integer can be null
        if(leftSize == null) return null; // as a flag
        if(k == leftSize + 1){  //+1 means root itself
            res = root.val;
            return null;  //as a flag
        }
        Integer rightSize = helper(root.right, k - leftSize - 1);
        return rightSize == null ? null : (leftSize + rightSize + 1);  //when the target is at right side return null. Otherwise return the number of node to the parent node
    }
    //Or use flag, -1 means we found the kth. When we found the kth mark the flag to true
    //so when either the right side or the left side equals to -1 then we return -1.
    //else return the number of nodes
    private int res = 0;
    private boolean flag = false;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return flag == true ? res : -1;
    }
    private int helper(TreeNode root, int k){
        if(root == null) return 0;
        int leftSize = helper(root.left, k);
        if(leftSize == -1) return -1;
        if(leftSize + 1 == k){
            res = root.val;
            flag = true;
            return -1;
        }
        int rightSize = helper(root.right, k - leftSize - 1);  // k - leftSize - 1 means except left side node and the root itself 
        if(rightSize == -1) 
            return -1;
        return leftSize + rightSize + 1;
    }
}

//BST. SORTED! if the there is no left child then the parent node is def smaller than the right child
//DFS. calculate the number of the nodes. 
//in-order traverse: left node, do something, right node 
