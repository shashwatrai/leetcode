class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int dp[][][] = new int[m+1][n+1][3];
        dp[1][1][0] = coins[0][0] ;
        dp[1][1][1] = coins[0][0] > 0 ? coins[0][0]:0;
        dp[1][1][2] = coins[0][0]  > 0?coins[0][0]:0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i == 1 && j == 1)
                    continue;
                if(coins[i-1][j-1] >= 0){
                    dp[i][j][0] = coins[i-1][j-1] + Math.max( j > 1 ? dp[i][j-1][0]:Integer.MIN_VALUE,i > 1 ? dp[i-1][j][0]:Integer.MIN_VALUE);
                    dp[i][j][1] = coins[i-1][j-1] + Math.max( j > 1 ? dp[i][j-1][1]:Integer.MIN_VALUE,i > 1 ? dp[i-1][j][1]:Integer.MIN_VALUE);
                    dp[i][j][2] = coins[i-1][j-1] + Math.max( j > 1 ? dp[i][j-1][2]:Integer.MIN_VALUE,i > 1 ? dp[i-1][j][2]:Integer.MIN_VALUE);
                }else{
                    dp[i][j][0] = coins[i-1][j-1] + Math.max( j > 1 ? dp[i][j-1][0]:Integer.MIN_VALUE,i > 1 ? dp[i-1][j][0]:Integer.MIN_VALUE);
                    dp[i][j][1] = Math.max(Math.max(i > 1  ? dp[i-1][j][1]:Integer.MIN_VALUE,j>  1 ? dp[i][j-1][1]: Integer.MIN_VALUE) + coins[i-1][j-1]
                                            ,Math.max(j > 1 ?dp[i][j-1][0]: Integer.MIN_VALUE,i > 1 ?dp[i-1][j][0]: Integer.MIN_VALUE));
                    dp[i][j][2] = Math.max(Math.max(i > 1 ?dp[i-1][j][2]: Integer.MIN_VALUE,j > 1 ?dp[i][j-1][2]: Integer.MIN_VALUE) + coins[i-1][j-1]
                                            , Math.max(j > 1 ?dp[i][j-1][1]: Integer.MIN_VALUE,i > 1 ?dp[i-1][j][1]: Integer.MIN_VALUE));
                }
                // System.out.println(Arrays.toString(dp[i][j]));
            }
        }
        return Math.max(dp[m][n][0],Math.max(dp[m][n][1],dp[m][n][2]));
    }
}