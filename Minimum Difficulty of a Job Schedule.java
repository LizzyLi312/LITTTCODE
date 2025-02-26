class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] f = new int[d + 1][n + 1]; // i-th day finished 0~j job 

        for (int i = 0; i < d + 1; i++) {
            Arrays.fill(f[i], (int)1e8);
        }
        f[0][0] = 0;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= n; j++) {
                int curDayMax = 0;
                for (int k = 1; k <= j; k++) {
                    curDayMax = Math.max(curDayMax, jobDifficulty[j - k + 1 - 1]); // since the job diff is 0-indexed arr but the job is 1 index-ed so we need to -1;
                    // if i-th day we finished k = 3 jobs, before i-th day we finished 2 jobs; so in total we finished 5 jobs. we need to traverse 3, 4, 5 jobs diff which is 5 - 3 + 1 = 3
                    f[i][j] = Math.min(f[i][j], curDayMax + f[i - 1][j - k]);
                }
            }
        }
        
        return f[d][n] == (int)1e8 ? -1 : f[d][n];
    }
}
