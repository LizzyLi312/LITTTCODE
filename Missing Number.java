class Solution {
    public int missingNumber(int[] nums) {
        //HashMap 2 passes
        //time: O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, 1);
        }
        int i = 0;
        for(i = 0; i <= nums.length; i++){
            if(!map.containsKey(i)) break;
        }
        return i;
        //HashSet 2 passes
        //time: o(n)
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int i;
        for(i = 0; i <= nums.length; i++){
            if(!set.contains(i))
                break;
        }
        return i;
        //Sort + one pass check index and value 
        //time: O(n + nlogn)
    }
}
