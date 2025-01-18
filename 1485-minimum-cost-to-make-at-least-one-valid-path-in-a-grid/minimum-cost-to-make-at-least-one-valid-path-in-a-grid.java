class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int dp[][] =new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[0][0] = 0;
        while(true){
            int [][]prev = new int[m][];

            for(int i=0;i<m;i++){
                prev[i] = Arrays.copyOf(dp[i],n);
            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if( i > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + (grid[i-1][j] == 3 ? 0:1));
                    if(j > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + (grid[i][j-1] == 1?0:1));
                }
            }

            for(int i=m-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    if( i+1< m)
                        dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + (grid[i+1][j] == 4 ? 0:1));
                    if(j +1 < n)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + (grid[i][j+1] == 2?0:1));
                }
            }

            if(Arrays.deepEquals(dp,prev))
                break;
            // System.out.println(Arrays.deepToString(dp));
        }
        return dp[m-1][n-1];
        
    }
}