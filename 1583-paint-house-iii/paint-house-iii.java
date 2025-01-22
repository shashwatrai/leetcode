class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int dp[][][] = new int[m+1][n+1][target+1];

        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++)
                for(int k=0;k<=target;k++)
                    dp[i][j][k] = Integer.MAX_VALUE;
        }

        for(int i=1;i<=m;i++){
            if(houses[i-1] == 0){
                for(int j=1;j<=n;j++){
                    for(int k = 1;k<=i && k <= target;k++){
                        dp[i][j][k]  = Math.min(dp[i][j][k], dp[i-1][j][k] != Integer.MAX_VALUE ? dp[i-1][j][k] + cost[i-1][j-1] : Integer.MAX_VALUE);
                        for(int l = 1;l<=n;l++){
                            if(j == l)
                                continue;
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][l][k-1] != Integer.MAX_VALUE ? dp[i-1][l][k-1] + cost[i-1][j-1] : Integer.MAX_VALUE );
                        }
                        System.out.print(dp[i][j][k]+" ");
                    }  
                    System.out.println(); 
                }
            }else{
                int j = houses[i-1];
                for(int k = 1;k<=i && k <= target;k++){
                    dp[i][j][k]  = Math.min(dp[i][j][k], dp[i-1][j][k] != Integer.MAX_VALUE ? dp[i-1][j][k] : Integer.MAX_VALUE);
                    for(int l = 1;l<=n;l++){
                        if(j == l)
                            continue;
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][l][k-1] != Integer.MAX_VALUE ? dp[i-1][l][k-1] : Integer.MAX_VALUE );
                    }
                }
            }
        }

        int ans  = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            ans = Math.min(ans,dp[m][i][target]);
        }
        return ans != Integer.MAX_VALUE? ans:-1;
    }
}