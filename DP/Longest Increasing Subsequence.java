// solution1 dp
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            int maxval = 0; //to store the max seq before i 
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) maxval = Math.max(dp[j], maxval);
            }
            dp[i] = maxval + 1; 
            res = Math.max(res, dp[i]); 
        }
        return res;
    }
}

// solution2 segment tree 
class Solution {
    Node[] nodes;
    int N = 200100;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        nodes = new Node[N * 4];
        for (int i = 0; i < N * 4; i++) nodes[i] = new Node();

        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        build(1, min, max);
        for (int num : nums) {
            int len = query(1, min, num - 1);
            update(1, num, len + 1);
        }
        return query(1, min, max);
    }

    private void build(int node, int left, int right) {
        nodes[node].l = left;
        nodes[node].r = right;
        if (left == right) return;

        int mid = left + (right - left) / 2;
        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);
    }

    private int query(int node, int left, int right) {
        if (nodes[node].l >= left && nodes[node].r <= right) {
            return nodes[node].val;
        }
        if (nodes[node].r < left || nodes[node].l > right) return 0; // need to return 0 when it's out of boundary
        int mid = nodes[node].l + (nodes[node].r - nodes[node].l) / 2;
        int v = 0;
        if (left <= mid) v = query(node * 2, left, right);
        if (right > mid) v = Math.max(v, query(node * 2 + 1, left, right));
        return v;
    }

    private void update(int node, int cur, int val) {
        if (nodes[node].l == cur && nodes[node].r == cur){
            nodes[node].val = Math.max(nodes[node].val, val);
            return;
        }
        int mid = nodes[node].l + (nodes[node].r - nodes[node].l) / 2;
        if (cur <= mid) update(node * 2, cur, val);
        else update(node * 2 + 1, cur, val);
        pushUp(node);
    }

    private void pushUp(int node) {
        nodes[node].val = Math.max(nodes[node * 2].val, nodes[node * 2 + 1].val);
    }

    class Node {
        int l, r, val;
        public Node() {
            this.l = 0; 
            this.r = 0;
            this.val = 0;
        }
    }
}

// solution3 list + binary search 
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int n = nums.length;
        List<Integer> t = new ArrayList<>();
        for (int num : nums) {
            if (t.isEmpty() || t.get(t.size() - 1) < num) {
                t.add(num);
                continue;
            } else {
                int idx = bs(t, num);
                t.set(idx, num);
            }
        }
        return t.size();
    }

    private int bs(List<Integer> t, int target) {
        // look for the first element in the array that is bigger than num
        int l = 0, r = t.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (t.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
