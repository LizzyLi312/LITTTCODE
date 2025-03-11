// solution1: brutal force
// time: O(n^3) 
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (check(s, i, j)) cnt++;
            }
        }
        return cnt;
    }

    private boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

//solution2 using every element as the center and expand from the middle 
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] cnt = new int[1];
        for (int i = 0; i < s.length(); i++) {
            check(s, i, i, cnt);
            if (i != s.length() - 1) check(s, i, i + 1, cnt);
        }
        return cnt[0];
    }

    private void check(String s, int left, int right, int[] cnt) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt[0]++;
            left--;
            right++;
        }
    }
}
