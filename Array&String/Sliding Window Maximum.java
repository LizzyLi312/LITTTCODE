//using deque storing the index. from the first one to the last one is decreasing order
//so when each time we compare the new number with the last one element in the deque 
//when the first one is out of the window then we need to poll it out
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null) return null;
        if(nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> que = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(i >= k && que.getFirst() == i - k) que.pollFirst();
            while(!que.isEmpty() && nums[que.getLast()] <= nums[i]){ //compare the new element with the elements in the queue
                que.pollLast(); 
            }
            que.offerLast(i);
            if(i >= k - 1) res[i - k + 1] = nums[que.getFirst()]; //when index is bigger than or equal to 3, update the res array every time we visit a new element
        }
        return res;
    }
}
