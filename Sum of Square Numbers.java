// similar to binary search
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;

        long l = 0, r = (long) Math.sqrt(c); // attn: the data type 

        while (l <= r) {
            if (l * l + r * r == c) return true;
            if (l * l + r * r < c) l++;
            else r--;
        }
        return false;
    }
}
