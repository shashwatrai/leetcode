class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit =0;
        for(int i=0;i<prices.length;i++){
            maxProfit = Math.max(maxProfit,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return maxProfit;
    }
}