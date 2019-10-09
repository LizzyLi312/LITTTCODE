class Solution {
    public int findDuplicate(int[] nums) {
        //HashSet 1 pass
        //time: O(n) space: O(n)
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int num : nums){
            if(!set.contains(num))
                set.add(num);
            else{
                res = num;
                break;
            }
        }
        return res;
        //sort + check array[n] == array[n-1]
        //time: O(n + nlogn)
    }
}
