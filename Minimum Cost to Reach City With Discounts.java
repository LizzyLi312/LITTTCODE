class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] g = new List[n]; // connections between each city
        int[][] cost = new int[n][discounts + 1]; // to which node, discount used

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        
        for (int[] highway : highways) {
            int a = highway[0], b = highway[1], c = highway[2];
            g[a].add(new int[]{b, c});
            g[b].add(new int[]{a, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, 0, 0}); // cost, node, discount used

        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int price = t[0], node = t[1], dis = t[2];
            if (node == n - 1) return price;

            for (int[] conn : g[node]) {
                int a = conn[0], b = conn[1];
                if (price + b < cost[a][dis]) {
                    cost[a][dis] = price + b;
                    pq.offer(new int[]{price + b, a, dis});
                }
                if (dis < discounts && price + b / 2 < cost[a][dis + 1]) {
                    cost[a][dis + 1] = price + b / 2;
                    pq.offer(new int[]{price + b / 2, a, dis + 1});
                }
            }
        }
        return -1;
    }
}
