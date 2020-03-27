class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0) return 0;
        int sell = 0, buy = -prices[0]; //the initial value of buy cannot be Integer.MIN_VALUE. since if p = 1, after add p. the buy + p = Integer.MAX_VALUE
        for(int i = 1; i < prices.length; i++){ 
            int p = prices[i];
            int nextSell = Math.max(sell, buy + p - fee);
            int nextBuy = Math.max(buy, sell - p);
            buy = nextBuy;
            sell = nextSell;
        }
        return sell;
    }
}
