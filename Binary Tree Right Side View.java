class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        TreeNode last = null;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                TreeNode cur = que.poll();
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
                last = cur;
            }
            res.add(last.val);
        }
        return res;
    }
}

//dfs
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return res;
        helper(root, 0);
        return res;
    }
    private void helper(TreeNode root, int level){
        if(level == res.size()) res.add(root.val);
        if(root.right != null) helper(root.right, level + 1);
        if(root.left != null) helper(root.left, level + 1);
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        int[] t = new int[100];
        Arrays.fill(t, -200);
        dfs(root, 0, t);
        
        List<Integer> res = new ArrayList<>();
        for (int a : t) {
            if (a != -200) res.add(a);
        }
        return res;
    }

    private void dfs(TreeNode root, int layer, int[] t) {
        if (root == null) return;
        
        if (t[layer] == -200) t[layer] = root.val;
        dfs(root.right, layer + 1, t);
        dfs(root.left, layer + 1, t);
    }
}
