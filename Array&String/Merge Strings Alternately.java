class Solution {
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2;
        if (word2 == null || word2.length() == 0) return word1;

        int n = word1.length(), m = word2.length();
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n || j < m) {
            if (i < n) sb.append(word1.charAt(i++));
            if (j < m) sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
