class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        StringBuilder sb = new StringBuilder();
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x = 0 - x;
        }
        while (x != 0) {
            int a = x / 10, b = x % 10;
            if (sb.length() > 0 && Integer.valueOf(sb.toString()) > (Integer.MAX_VALUE - b) / 10 ) return 0; // since we need to keep Integer_MAX_VALUE < x * 10 + b
            sb.append(b);
            x = a;
        }
        String s = (isNeg ? "-" : "") + sb.toString();
        
        return Integer.valueOf(s);
    }
}
