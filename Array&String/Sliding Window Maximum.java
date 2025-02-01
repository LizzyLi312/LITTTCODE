//using deque storing the index. from the first one to the last one is decreasing order
//so when each time we compare the new number with the last one element in the deque 
//when the first one is out of the window then we need to poll it out

// deque does not have a natrual sorting function so we need to maintain the decreasing order by ourselves. to do that we compare the new element to the last element in the deque
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};

        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && i - dq.peekFirst() + 1 > k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) {
                res[idx] = nums[dq.peekFirst()];
                idx++;
            }
        }
        return res;
    }
}
