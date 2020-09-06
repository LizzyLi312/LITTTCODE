public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        res.setLength(res.length() - 1); //remove the last comma
        return res.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder res){ //pre order
        if(root == null) return;  //do not need to put the null in the string since it has order 
        res.append(root.val + ",");
        serialize(root.left, res);
        serialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] tokens = data.split(",");
        Queue<Integer> que = new LinkedList<>();
        for(String e : tokens){
            que.offer(Integer.valueOf(e));
        }
        return getNode(que);
    }
    private TreeNode getNode(Queue<Integer> que){
        if(que.isEmpty()) return null;
        TreeNode root = new TreeNode(que.poll());
        Queue<Integer> smaller = new LinkedList<>();  //find the left subtree
        while(!que.isEmpty() && que.peek() < root.val){
            smaller.offer(que.poll());
        }
        root.left = getNode(smaller);
        root.right = getNode(que);
        return root;
    }
}

