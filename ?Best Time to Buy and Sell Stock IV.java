class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] sell = new int[k + 1][prices.length];
        int[][] buy = new int[k + 1][prices.length];
        for(int i = 1; i <= k ; i++){
            for(int j = 0; j < prices.length; j++){
                if(j == 0){
                    buy[i][0] = -prices[j];
                    continue;
                }
                sell[i][j] = Math.max(sell[i][j-1], buy[i][j - 1] + prices[j]);  
                buy[i][j] = Math.max(buy[i][j - 1], sell[i - 1][j - 1]-prices[j]); //buy i shoud be after i - 1 transaction 
            }
        }
        return sell[k][prices.length - 1];

    }
}
