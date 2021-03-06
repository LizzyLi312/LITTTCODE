class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        //search the target location 
        if(root.val < key) root.right = deleteNode(root.right, key);  
        else if(root.val > key) root.left = deleteNode(root.left, key);
        //if we found it, we need to consider 2 cases
        else{
            if(root.left != null && root.right != null){  //1st: if the node has children
                root.val = findMin(root.right).val;  //let the min node in the right subtree to replace the node
                root.right = deleteNode(root.right, root.val);  //and then delete the min node from subtree
                //root.right need to be cahced here since after the node got deleted there might not be a connection between the root and the child
            }
            else root = root.left == null ? root.right : root.left;  //2nd + 3rd: only has one child, return the child directly. If the child is null, root = null
        }
        return root;
    }
    private TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;  //bc it is binary search tree so the left child always is smaller than the root 
        }
        return root;
    }
}

//time: O(logn)
