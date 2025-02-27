class Solution {
    public int rotatedDigits(int n) {
        int cnt = 0;
        int[] memo = new int[n + 1]; // good: 2, not good: 0, potential good: 1
        for (int i = 0; i <= Math.min(n, 9); i++) {
            if (i == 2 || i == 5 || i == 6 || i == 9) {
                memo[i] = 2;
                cnt++;
            } else if (i == 0 || i == 1 || i == 8) { // also need to record the potential good since 51 can also be an answer it will rotate to 15
                memo[i] = 1;
            }
            else memo[i] = 0;
        }

        for (int i = 10; i <= n; i++) { // 55 -> 5, 5 , 552 -> 55, 2
            int a = i / 10, b = i % 10;
            if (memo[a] == 1 && memo[b] == 1) memo[i] = 1;
            else if (memo[a] >= 1 && memo[b] >= 1) { // if there is only 1 good digit and 1 potential good digit it counts as an answer 
                memo[i] = 2;
                cnt++;
            }
            else memo[i] = 0;
        }
        return cnt++;
    }
}
