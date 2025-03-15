class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (j < t.length() && i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else j++;
        }
        return i == s.length();
    }
}

// followup: if s is a streaming input - using binary search
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        List<Integer>[] map = new List[26];

        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i) - 'a'] == null) map[t.charAt(i) - 'a'] = new ArrayList<>();
            map[t.charAt(i) - 'a'].add(i);
        }

        int idx = -1;
        for (char c : s.toCharArray()) {
            if (map[c - 'a'] == null || map[c - 'a'].isEmpty()) return false;
            List<Integer> temp = map[c - 'a'];
            int pos = bs(temp, idx);
            
            if (pos == temp.size()) return false;

            idx = temp.get(pos);
        }

        return true;
    }

    private int bs(List<Integer> arr, int idx) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) > idx) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
