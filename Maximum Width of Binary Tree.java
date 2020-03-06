class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> nodeQue = new LinkedList<>();
        Queue<Integer> idxQue = new LinkedList<>();
        nodeQue.offer(root);
        idxQue.offer(0);
        while(!nodeQue.isEmpty()){
            int size = nodeQue.size();
            int left = 0; 
            int right = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = nodeQue.poll();
                int index = idxQue.poll();
                if(i == 0) left = index;
                if(i == size - 1) right = index;
                if(node.left != null){
                    nodeQue.offer(node.left);  //the relation between the left child and parent node 
                    idxQue.offer(index * 2);
                }
                if(node.right != null){
                    nodeQue.offer(node.right);
                    idxQue.offer(index * 2 + 1);
                }
            }
            max = Math.max(max, right - left + 1);  //compare it with the # of nodes
        }
        return max;
    }
}
