//search: 2 branches: buy or not buy; sell or not sell
class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int buy = Integer.MIN_VALUE;
        for(int p : prices){
            sell = Math.max(buy + p, sell);
            buy = Math.max(-p, buy);
        }
        return sell;
    }
}
