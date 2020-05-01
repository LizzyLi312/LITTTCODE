public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n == 0) return 0;
        if(n == -1) return 32;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if(((n >> i) & 1) != 0) count++;
        }
        return count;
    }
}
