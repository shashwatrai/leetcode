class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int dp[][] = new int[n][n];

        int sum[] = new int[n];
        sum[0] = stoneValue[0];
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1] + stoneValue[i];
        }

        for(int l= 2;l<=n;l++){
            for(int i =0 ;i<n-l+1;i++){
                int j = i+l-1;

                for(int k = i;k<j;k++){
                    int left = sum[k] - (i > 0 ? sum[i-1]:0);
                    int right = sum[j] - sum[k];
                    // if(i == 0 && j==2)
                    //     System.out.println(k+" "+dp[i][k]+" "+dp[k+1][j] +" "+left+" "+right);
                    if(left < right)
                        dp[i][j] = Math.max(dp[i][j],dp[i][k] + left);
                    else if(right < left)
                        dp[i][j] = Math.max(dp[i][j],dp[k+1][j] + right);
                    else{
                        dp[i][j] = Math.max(dp[i][j],left + Math.max(dp[i][k],dp[k+1][j]));
                    }
                    // if(i == 0 && j==2)
                    //     System.out.println(dp[i][j]);
                }
                // System.out.println(i+" "+j + " "+dp[i][j]);
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dp[i][j]+"  ");
        //     }
        //     System.out.println("");
        // }
        return dp[0][n-1];
    }


}