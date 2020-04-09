class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> tree = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k){ //constrain the index range
                tree.remove(Long.valueOf(nums[i - k - 1]));
            }
            long upperBound = (long) nums[i] + t;
            long lowerBound = (long) nums[i] - t;
            //Long low = tree.floor(upperBound); works too 
            //the greatest element less than or equal to e, or null if there is no such element
            Long low = tree.lower(upperBound + 1); //Returns the greatest element in this set strictly less than the given element, or null if there is no such element
            //find if there is an element in this range 
            if(low != null && low >= lowerBound) return true;
            tree.add(Long.valueOf(nums[i])); //if there is not then put this element in set 
        }
        return false;
    }
}
