//iteration
public class Codec {
    // Encodes a tree to a single string.
    // using the stack preorder 
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder res = new StringBuilder();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(true){
            if(cur == null) res.append("#,");
            else res.append(cur.val + ",");
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                if(!stack.empty()){
                    TreeNode top = stack.pop();
                    cur = top.right;
                }
                else break; 
            }
        }
        res.setLength(res.length() - 1);  //there will be an extra , 
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //recover tree by pre order 
        if(data == null || data.length() == 0) return null;
        String[] tokens = data.split(",");
        if(tokens.length == 1 && tokens[0].equals('#')) return null; 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = new TreeNode(Integer.valueOf(tokens[0])), root = cur;
        stack.push(cur);
        int i = 1, len = tokens.length;
        while(i < len){
            while(i < len && !tokens[i].equals("#")){ //all the way left until we meet the first null(#)
                cur.left = new TreeNode(Integer.valueOf(tokens[i++]));
                cur = cur.left;
                stack.push(cur);
            }
            while(i < len && tokens[i].equals("#")){  //find the next non # character
                i++;
                if(stack.empty()) break;
                cur = stack.pop(); //find the root
            }
            if(i < len){
                cur.right = new TreeNode(Integer.valueOf(tokens[i++]));
                cur = cur.right;
                stack.push(cur);
            }
        }
        return root;
    }
}

//recursion 
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder res = new StringBuilder();
        build(res, root);
        res.setLength(res.length() - 1);
        return res.toString();
    }
    private void build(StringBuilder res, TreeNode root){
        if(root == null){
            res.append("null,");
            return;
        }
        res.append(root.val + ",");
        build(res, root.left);
        build(res, root.right);
    }

    // Decodes your encoded data to tree.
     public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] tokens = data.split(",");
        TreeNode root = decode(tokens);
        return root;
    }
    private int idx = 0;
    private TreeNode decode(String[] tokens){
        if(idx == tokens.length) return null;
        String val = tokens[idx++];
        if(val.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = decode(tokens);
        root.right = decode(tokens);
        return root;
    }
}
