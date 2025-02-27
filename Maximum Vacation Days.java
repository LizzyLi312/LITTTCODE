class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        // dp[i][j]: week-ith max vaca day in city j-th, dp[0][0] = 0
        // dp[i][j] = max(dp[i - 1][j] + days[j][i], dp[i - 1][j - 1] + days[j][i], dp[i - 1][j + 1] + days[j][i])
        int weeks = days[0].length;
        int cities = flights.length;
        int[][] dp = new int[weeks][cities];

        for (int i = 0; i < weeks; i++) Arrays.fill(dp[i], -1); 

        dp[0][0] = days[0][0];
        for (int i = 1; i < weeks; i++) {
            if (flights[0][i] == 1) dp[0][i] = days[i][0]; // since the first day we can only fly from city 0 to other city so dp[0][i] is fixed 
        }
        
        for (int i = 1; i < weeks; i++) {
            for (int j = 0; j < cities; j++) { // to
                for (int k = 0; k < flights[j].length; k++) {// fly from other cities
                    if ((flights[k][j] == 1 || k == j) && dp[i - 1][k] != -1) { // dp[i - 1][k] != -1 means this city k cannot be visited 
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + days[j][i]); 
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < cities; i++) { // find the maximum day of last week
            if (dp[weeks - 1][i] > res) res = dp[weeks - 1][i];
        }
        return res;
    }
}
