// solution1 using dfs
class Solution {
    int level, idx; // keep level and idx as global since when we return it will be the same level and same idx
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.length() == 0) return new TreeNode();

        level = 0;
        idx = 0;
        TreeNode dummy = new TreeNode();
        rec(traversal, 0, dummy);
        return dummy.left;
    }

    public void rec(String traversal, int curLvl, TreeNode node) {
        while (idx < traversal.length() && curLvl == level) { 
            int num = 0;

            while (idx < traversal.length() && Character.isDigit(traversal.charAt(idx))) {
                num = num * 10 + Integer.valueOf(traversal.charAt(idx) - '0');
                idx++;
            }
            
            TreeNode cur = new TreeNode(num);
            if (node.left == null) { // populate the left node first 
                node.left = cur;
            } else {
                node.right = cur;
            }
            level = 0;
            while (idx < traversal.length() && traversal.charAt(idx) == '-') {
                level++;
                idx++;
            }
            rec(traversal, curLvl + 1, cur);
        }
    }
}

// solution2: stack keep treeNode, the first treeNode would be the root 
// the size of the stack is the current level
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.length() == 0) return new TreeNode();

        Stack<TreeNode> st = new Stack<>();
        int idx = 0, level = 0;
        while (idx < traversal.length()) {
            level = 0; 
            while (idx < traversal.length() && traversal.charAt(idx) == '-') {
                level++;
                idx++;
            }

            int num = 0;
            while (idx < traversal.length() && Character.isDigit(traversal.charAt(idx))) {
                num = num * 10 + (traversal.charAt(idx) - '0');
                idx++;
            }

            while (st.size() > level) st.pop();
            TreeNode t = new TreeNode(num);
            if (!st.isEmpty()) {
                if (st.peek().left == null) {
                    st.peek().left = t;
                } else {
                    st.peek().right = t;
                }
            }
            st.push(t);
        }
        while (st.size() > 1) st.pop();
        return st.peek();
    }
}
