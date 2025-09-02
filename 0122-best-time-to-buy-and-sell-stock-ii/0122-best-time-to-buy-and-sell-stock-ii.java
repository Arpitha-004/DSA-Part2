class Solution {
    public int maxProfit(int[] prices) {
        int aheadBuy,aheadSell,curBuy,curSell;
        aheadBuy=0;
        aheadSell=0;
        int n = prices.length;
        for(int i=n-1;i>=0;i--){

            curBuy = Math.max(-prices[i]+aheadSell , 0+aheadBuy);
            curSell = Math.max(prices[i]+aheadBuy , 0+aheadSell);

            aheadBuy = curBuy;
            aheadSell = curSell;
        }
        return aheadBuy;    //In dp[0][0] profit will be stored finally in bottom up
    }
}