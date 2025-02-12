// segment tree 
class Solution {
    int N = 100010;
    Node[] nodes;
    public int lengthOfLIS(int[] nums, int k) {
        nodes = new Node[N * 4]; // The reason for defining the segment tree array as segTree[4 * N] is to ensure we have enough space to store all the nodes of the tree efficiently.
        for (int i = 0; i < N * 4; i++) nodes[i] = new Node();
        int max = nums[0];
        for (int num : nums) max = Math.max(num, max);
        build(1, 1, max);

        for (int num : nums) {
            int len = query(1, Math.max(1, num - k), num - 1); // since the min value is 1 so x - k might be out of boundary so ww taking the max
            modify(1, num, len + 1);
        }
        return query(1, 1, max);
    }

    private void build(int node, int left, int right) {
        nodes[node].left = left;
        nodes[node].right = right;
        if (left == right) return;
        int mid = left + (right - left) / 2;
        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);
    }

    private void modify(int node, int cur, int val) {
        if (nodes[node].left == cur && nodes[node].right == cur) nodes[node].val = Math.max(nodes[node].val, val);
        else {
            int left = nodes[node].left, right = nodes[node].right;
            int mid = left + (right - left) / 2;
            if (mid >= cur) modify(node * 2, cur, val);
            else modify(node * 2 + 1, cur, val);
            pushUp(node);
        }
    }

    private void pushUp(int node) {
        nodes[node].val = Math.max(nodes[node * 2].val, nodes[node * 2 + 1].val);
    }

    private int query(int node, int left, int right) {
        if (nodes[node].left >= left && nodes[node].right <= right) return nodes[node].val;
        int mid = nodes[node].left + (nodes[node].right - nodes[node].left) / 2;
        int v = 0;
        if (left <= mid) v = query(node * 2, left, right);
        if (right > mid) v = Math.max(v, query(node * 2 + 1, left, right));
        return v;
    }

    class Node {
        int val, left, right;
        public Node() {
            val = 0;
            left = 0;
            right = 0;
        }
    }
}

// The reason for defining the segment tree array as segTree[4 * N] is to ensure we have enough space to store all the nodes of the tree efficiently.
