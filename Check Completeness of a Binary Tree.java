class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = false;
        while(!que.isEmpty()){
            int size = que.size();
            TreeNode temp = que.poll();
            if(temp != null){
                if(flag == true) return false;
                que.offer(temp.left);
                que.offer(temp.right);
            }
            else flag = true;
        }
        return true;
        
        //s2: check before 
        if(root == null) return true;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = false;
        while(!que.isEmpty()){
            TreeNode temp = que.poll();
            if(temp.left != null){
                if(flag == true) return false;
                else que.offer(temp.left);
            }
            else flag = true;
            if(temp.right != null){
                if(flag == true) return false;
                else que.offer(temp.right);
            }
            else flag = true;
        }
        return true;
    }
}

//recursion works too
//using level order traversal to traversal tree. bc it traverse left first so when it is null the flag will turn to true and end while loop
