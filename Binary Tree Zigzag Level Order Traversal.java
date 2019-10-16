class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ress = new LinkedList<>();
        if(root == null) return ress;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int count = 1;
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> res = new ArrayList<>();
            while(size-- > 0){
                TreeNode temp = que.poll();
                if(count % 2 == 0)  //tell the even and odd here
                    res.add(0, temp.val);
                else 
                    res.add(temp.val);
                if(temp.left != null) que.offer(temp.left);  //do not tell the even and odd here
                if(temp.right != null) que.offer(temp.right);
            }
            count++;
            ress.add(res);
        }
        return ress;
    }
}
