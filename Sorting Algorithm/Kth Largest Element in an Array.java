//Quickselect is a selection algorithm to find the k-th smallest/Largest element in an unordered list
//same idea as Quick sort 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) return -1;
        return quickSelection(nums, 0, nums.length - 1, nums.length - k); //1st largest: nums.length - 1 2nd largest : nums.length - 2 kth largest nums.length - k
    }
    private int quickSelection(int[] nums, int begin, int end, int k){
        if(begin > end) return Integer.MAX_VALUE;
        int pivot = nums[end]; //choose a pivot 
        int idx = begin;
        for(int i = begin; i < end; i++){ //put the element who are smaller than the pivot into the right position 
            if(nums[i] <= pivot){
                swap(nums, idx++, i);
            }
        }
        swap(nums,idx,end); //put the pivot after the elements which are smaller than it
        if(idx == k) return nums[idx]; //if the pivot's idx is k then it is the k largest. since the order doesnt matter
        else if(idx < k) return quickSelection(nums, idx + 1, end, k); //pivot is too small so recur the right part
        else return quickSelection(nums, 0, idx - 1, k);  //pivot is too large so recur the lefrt part
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//time: O(n)
