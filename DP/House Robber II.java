class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int len = nums.length;
        return Math.max(robSub(nums, 0, len - 2), robSub(nums, 1, len - 1)); //since the last one is the first one's neighbor
    }
    private int robSub(int[] nums, int start, int end){
        int m1 = 0, m2 = nums[start]; //at day i m1: not rob, m2: rob
        for(int i = start + 1; i<= end; i++){
            int next = m1 + nums[i]; //rob: m1: did not rob on the day before 
            m1 = Math.max(m1, m2); //not rob
            m2 = next;
        }
        return Math.max(m1, m2);
    }
}

//[1, 2, 3, 1]
