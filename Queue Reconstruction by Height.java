// solution1 main idea: greedy
// 2 cases: if 2 people have the same heights, the one with smaller k comes first; 
//           if 1 person is taller than the other, the shorter person should be in the indx K position. it won't affect any person that's taller than them behind them
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> temp = new LinkedList<>();
        for(int[] p : people) {
            temp.add(p[1], p);
        }
        return temp.toArray(new int[people.length][2]);
    }
}
// time: O(nlogn + n^2) insert into the list will take n^2

//solution2: segment tree O(nlogn)
class Solution {
    int N;
    Node[] nodes;
    public int[][] reconstructQueue(int[][] people) {
        N = people.length;
        nodes = new Node[N * 4];
        for (int i = 0; i < N * 4; i++) nodes[i] = new Node();
        build(0, 0, N - 1);

        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int[][] res = new int[N][2];
        for (int[] p : people) {
            int idx = query(0, 0, N - 1, p[1] + 1);
            res[idx] = p;
            update(0, 0, N - 1, idx);
        }
        return res;
    }

    private void build(int idx, int start, int end) { 
        if (start == end) {
            nodes[idx].val = 1; //node value stands for how many empty positions are between start and end 
            return;
        }
        int mid = start + (end - start) / 2;
        build(idx * 2 + 1, start, mid);
        build(idx * 2 + 2, mid + 1, end);
        nodes[idx].val = nodes[idx * 2 + 1].val + nodes[idx * 2 + 2].val;
    }

    private int query(int node, int start, int end, int k) { // k stands for how many people taller should be in front 
        if (start == end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (nodes[node * 2 + 1].val >= k) return query(2 * node + 1, start, mid, k);
        else return query(2 * node + 2, mid + 1, end, k - nodes[node * 2 + 1].val);
    }

    private void update(int node, int start, int end, int idx) {
        if (start == end) { 
            nodes[node].val = 0; // set this point to 0 if it is already opccupied
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) update(node * 2 + 1, start, mid, idx);
        else update(node * 2 + 2, mid + 1, end, idx);
        nodes[node].val = nodes[node * 2 + 1].val + nodes[node * 2 + 2].val; // update parents' value
    }

    class Node {
        int val;
        public Node() { 
            this.val = 0;
        }
    }
}
