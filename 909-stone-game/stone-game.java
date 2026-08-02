class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int dp[][][] = new int[n][n][2];
       

        for(int i=0;i<n;i++){
           
            dp[i][i][1] = piles[i];
        }
        
        for(int l=1;l<n;l++){
            int i = 0;
            int j = l;
            int sum =0;
            for(int x = i;x<j;x++)
                sum += piles[x];
            int turn = (l+1)%2;
            for(;j < n ; i++ ,j++){
                sum += piles[j];
                dp[i][j][turn] = Math.max(dp[i][j-1][turn] + piles[j], dp[i+1][j][turn] + piles[i]);
                dp[i][j][1-turn] = sum - dp[i][j][turn];
                sum -= piles[i];
                // System.out.println(i+" "+j+" "+turn+" "+dp[i][j][turn]+" "+dp[i][j][1 - turn]);
            }
        }
       
        return dp[0][n-1][0] > dp[0][n-1][1];
    }
}