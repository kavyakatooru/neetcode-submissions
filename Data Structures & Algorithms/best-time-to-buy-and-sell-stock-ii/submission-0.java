class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int j=0;j<prices.length;j++) {
            if (prices[j]-min > 0) {
                profit += prices[j] - min;
                min = prices[j];
            } else {
                min = Math.min(min, prices[j]);
            }
        }
        return profit;
    }
}