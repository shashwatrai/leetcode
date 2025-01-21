class Solution {
    public long minCost(int n, int[][] cost) {

        int m = n/2;
        long [][][]dp = new long[m][3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                dp[m-1][i][j] = Long.MAX_VALUE;
                if(i==j)
                    continue;
                dp[m-1][i][j] = (long)cost[m-1][i] + (long)cost[m][j];
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k] = Long.MAX_VALUE;
                    if(j== k)
                        continue;
                    for(int x = 0;x<3;x++){
                        for(int y = 0;y < 3;y++){
                            if(x == j || y == k || x == y)
                                continue;
                            dp[i][j][k] = Math.min(dp[i][j][k],
                                dp[i+1][x][y] + (long)cost[i][j] + (long)cost[n-1-i][k]);
                        }
                    }
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ans = Math.min(ans,dp[0][i][j]);
            }
        }
        return ans;
    }
}