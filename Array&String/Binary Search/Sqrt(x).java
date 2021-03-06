class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int start = 1, end = x;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(mid  == x / mid) return mid; //do not use mid * mid since it could cause integer overflow. and we just need the decimal part
            else if(mid < x / mid) start = mid;
            else end = mid;
        }
        if(end < x / end) return end; //case: 2147395599. we could not handle if x is larger than the max value 
        return start; //if the res is between start and end. then return start
    }
}
