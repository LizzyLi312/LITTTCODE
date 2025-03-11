class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;

        int l = 0, r = s.length() - 1;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] res = s.toCharArray();

        while (l < r) {
            while (l < s.length() && !set.contains(s.charAt(l))) l++;
            while (r >= 0 && !set.contains(s.charAt(r))) r--;
            if (l < r) swap(res, l++, r--);
        }
        return new String(res);
    }

    private void swap(char[] s, int l, int r) {
        char t = s[l];
        s[l] = s[r];
        s[r] = t;
    }
}
