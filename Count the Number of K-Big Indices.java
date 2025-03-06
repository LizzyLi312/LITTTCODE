class Solution {
    public int kBigIndices(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int n = nums.length;
        boolean[] prevK = new boolean[n];

        //prev K 
        for (int i = 0; i < n; i++) {
            if (pq.size() == k && pq.peek() < nums[i]) prevK[i] = true;
            pq.add(nums[i]); //need to add the cur elemtn firsrt just in case it is bigger than the ones in the pq
            if (pq.size() > k) pq.poll();
        }

        // after K
        pq.clear();
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (pq.size() == k && pq.peek() < nums[i] && prevK[i]) res++;
            pq.add(nums[i]);
            if (pq.size() > k) pq.poll();
        }
        return res;
    }
}
