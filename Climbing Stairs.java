class Solution {
    public int climbStairs(int n) {
        if(n < 0) return -1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int ppre = 1;
        int pre = 2;
        int count = 1;
        int sum = 0;
        while(count + 2 <= n){
            sum = ppre + pre;
            ppre = pre;
            pre = sum;
            count++;
        }
        return sum;
    }
}
