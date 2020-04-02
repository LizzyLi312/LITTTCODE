class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        if(k >= prices.length / 2){
            int sum = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] - prices[i - 1] > 0) sum+= prices[i] - prices[i - 1];
            }
            return sum;
        }
        int[][] sell = new int[k + 1][prices.length]; //index corrensponse to the transaction's time 
        int[][] buy = new int[k + 1][prices.length];
        sell[0][]
        for(int i = 1; i <= k ; i++){
            for(int j = 0; j < prices.length; j++){
                if(j == 0){
                    buy[i][0] = -prices[0];
                    continue; //do not need to initialize the sell since it 0
                } 
                sell[0][j] = 0;
                sell[i][j] = Math.max(sell[i][j - 1], buy[i][j-1] + prices[j]);
                buy[i][j] = Math.max(buy[i][j - 1], sell[i - 1][j- 1] - prices[j]);
            }
        }
        return sell[k][prices.length - 1];

    }
}

//time: O(kn)
