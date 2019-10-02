//using heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for(int num : nums){
            heap.offer(num);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.poll();
    }
}

//using partition and quick 
