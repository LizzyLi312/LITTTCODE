public static List<Integer> closestKValues(TreeNode root, double target, int k) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Queue<Double> maxheap = new PriorityQueue<>(k, (o1, o2) -> (int) (o2 - o1));
    while (root != null) {
        if (maxheap.size() < k ) maxheap.offer((double) root.val);
        else if (Math.abs(maxheap.peek() - target) > Math.abs(root.val - target)) {
            maxheap.poll();
            maxheap.offer((double) root.val);
         }
         if (target < root.val) root = root.left;
         else root = root.right;
     }
     while(!maxheap.isEmpty()){
         double temp = maxheap.poll();
         res.add((int) temp);
     }
     return res;
}
