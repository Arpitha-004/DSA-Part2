class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] cur = new int[amount+1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0)
                prev[t] = t/coins[0];
            else
                prev[t] = (int)1e9;
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int nottake = 0 + prev[t];
                int take = (int)1e9;
                if(coins[i]<=t){
                    take = 1 + cur[t-coins[i]];
                }
                cur[t] = Math.min(take,nottake);
            }
            prev = cur;
        }
        int ans = prev[amount];
        if(ans>=1e9)
            return -1;
        return ans;
    }
}