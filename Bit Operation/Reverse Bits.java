public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n == 0) return n;
        for(int i = 0; i < 16; i++){
            int left = (n >> (31 - i)) & 1; //shift right
            int right = (n >> i) & 1;
            if(left == right) continue;
            else{
            //0 ^ any number = any number 
            //1 ^ any number = !(any number)
                n = n ^ (1 << i) ^ (1 << (31 - i));
            } 
        }
        return n;
    }
}
