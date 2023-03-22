public class BestTimeToBuy {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length;
        int profitDay = 0;

        for(int i = 0; i < len; i++){
            if (prices[profitDay] > prices[i]) {
                profitDay = i;
            }
            profit = Math.max(profit, (prices[i] - prices[profitDay]));
        }
        return profit;
    }
}
