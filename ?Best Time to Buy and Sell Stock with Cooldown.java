class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int buy2 = -prices[0], sell2 = 0, buy1 = -prices[0], sell1 = 0;
        for(int i = 1; i < len; i++){
            int cBuy2 = sell1 - prices[i];
            int cSell2 = Math.max(buy1, buy2) + prices[i];
             
            int cBuy1 = Math.max(buy1, buy2);
            int cSell1 = Math.max(sell1, sell2);
            
            buy2 = cBuy2;
            sell2 = cSell2;
            buy1 = cBuy1;
            sell1 = cSell1;
        }
        return Math.max(sell1, sell2);
    }
}
