class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int p : prices){
            //sell = max(sell, buy + p); buy & sell need each other so it doesnt work
	          //buy = max(buy, sell - p);  
            int nextBuy = Math.max(buy, sell - p);
            int nextSell = Math.max(sell, buy + p);
            sell = nextSell;
            buy = nextBuy;
        }
        return sell;
    }
}

//greedy: since the transaction time is not limited so if the next day price is higher then we do the transaction 
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int total = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i + 1] > prices[i]) total += prices[i + 1] - prices[i]; 
        }
        return total;
    }
}
