class Solution {
    public long elevatorRequests(int n, int start, int[][] requests) {
        int m = requests.length;
        long dp[][] = new long[1<<m][m];
        
        for(long []i:dp)
            Arrays.fill(i,Long.MAX_VALUE);

        for(int i=1;i<(1<<m);i++){
            for(int j=0;j<m;j++){
                if((i & (1 << j)) == 0)
                    continue;
                if((i ^ (1<<j)) == 0){
                    long deltaMov = (long)Math.abs(requests[j][1] - start);
                    long deltaWt = Math.max( (long)requests[j][0]- deltaMov, 0L);
                    dp[i][j] = Math.min(dp[i][j],deltaMov + deltaWt);
                    // System.out.println(((1<<m)) +" "+i+" "+j+" -1 "+m+" "+dp[i][j]);
                    continue;
                }
                for(int k=0;k<m;k++){
                    if((i&(1<<k)) == 0)
                        continue;
                   
                    long deltaMov =  (long)Math.abs(requests[j][1]-requests[k][1]);
                    long deltaWt = Math.max( (long)requests[j][0] - dp[i ^ (1<<j)][k] - deltaMov, 0L);
                    dp[i][j] = Math.min(dp[i][j],deltaMov + deltaWt + dp[i ^ (1<<j)][k]);
                    // System.out.println(((1<<m)) +" "+i+" "+j+" "+k+" "+m+" "+dp[i][j]);
                }
                
            }
        }
        long ans = Long.MAX_VALUE;

        for(int i=0;i<m;i++){
            ans  = Math.min(ans,dp[(1<<m)-1][i]);
        }
        // System.out.println(ans);
        return ans;
    }
}