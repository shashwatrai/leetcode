class Solution {
    public int change(int amount, int[] coins) {
        
        Arrays.sort(coins);
        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int i=0;i<n;i++){
            dp[i][0]  = 1;

            for(int j= 1;j<=amount;j++){
                dp[i][j] = ( j >= coins[i] ? dp[i][j-coins[i]] : 0 )+ (i> 0 ? dp[i-1][j]:0);
            }
        }

        return dp[n-1][amount];

    }
}