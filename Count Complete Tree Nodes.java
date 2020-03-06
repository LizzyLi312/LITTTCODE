//using bfs, time: O(n)
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int res = 0;
        while(!que.isEmpty()){
            int size = que.size();
            res += size;
            while(size-- > 0){
                TreeNode cur = que.poll();
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }
        }
        return res;
    }
}

//maths solution, time: O((logn)^2)
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight > rightHeight) return countNodes(root.left) + (int) Math.pow(2, rightHeight);  //if the height of left tree is bigger then need to check left subtree
        else if(leftHeight == rightHeight) return countNodes(root.right) + (int) Math.pow(2, leftHeight);  //if the height is the same it doesnt mean it is a full tree, so gotta check right subtree
        else return 0;
    }
    private int getHeight(TreeNode root){
        int res = 0;
        while(root != null){
            root = root.left;
            res++;
        }
        return res;
    }
}
