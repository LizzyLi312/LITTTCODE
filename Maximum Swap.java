// look for the last occurence of every digits; find the 1st digit that has a digit which is bigger than itself -> swap and return 
class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        int[] idx = new int[10];
        for (int i = 0; i < digits.length; i++) {
            char d = digits[i];
            idx[d - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (idx[k] > i) {
                    char temp = digits[i];
                    digits[i] = digits[idx[k]];
                    digits[idx[k]] = temp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}
