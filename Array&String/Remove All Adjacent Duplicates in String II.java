// 2 pointers, [0, i] result, (i, j) abondoned, [j, s.length()) we need to check
class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() < k) return s;

        char[] res = s.toCharArray();
        int l = 0; 
        int[] cnt = new int[s.length()];

        for (int r = 0; r < s.length(); r++) {
            res[l] = res[r];
            if (l > 0 && res[r] == res[l - 1]) cnt[l] = cnt[l - 1] + 1;
            else cnt[l] = 1;
            if (cnt[l] == k) l = l - k;
            l++;
        }
        return new String(res, 0, l);
    }
}
