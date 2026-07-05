class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();

        int grid[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(Character.isAlphabetic(board.get(i).charAt(j))){
                    grid[i][j] = 0;

                    if(board.get(i).charAt(j) == 'X')
                        grid[i][j] = -1;
                }else{
                    grid[i][j] = board.get(i).charAt(j) - '0';
                }
            }
        }

        int R=  1_000_000_007;

        long [][][]dp = new long[n][n][2];
        dp[0][0] = new long[]{0L,1L};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // System.out.println(i+" "+j+" "+dp[i][j][0] +" "+dp[i][j][1]+" "+grid[i][j]);
                if(i==0 && j==0)
                    continue;
                if(grid[i][j] == -1){
                    dp[i][j][0] = dp[i][j][1] = -1;
                    continue;
                }
                int max  = -1;

                if(i > 0 && dp[i-1][j][0] != -1L){
                    max = (int) dp[i-1][j][0];
                }

                if(j > 0 ){
                    if(i > 0 && dp[i-1][j-1][0] != -1L){
                        max = Math.max(max,(int)dp[i-1][j-1][0]);
                    }
                    if(j > 0 && dp[i][j-1][0] != -1L){
                        max = Math.max(max,(int)dp[i][j-1][0]);
                    }
                }
               
                if(max == -1){
                    dp[i][j][0] = dp[i][j][1] = -1;
                    continue;
                }
                long total = 0L;

                if(i > 0 && dp[i-1][j][0] == max){
                    total = (total%R + dp[i-1][j][1]%R)%R;
                }

                if(j > 0 ){
                    if(i > 0 && dp[i-1][j-1][0] == max){
                        total = (total%R + dp[i-1][j-1][1]%R)%R;
                    }
                    if(j > 0 && dp[i][j-1][0] == (long)max){
                        total = (total%R + dp[i][j-1][1]%R)%R;
                    }
                }
                max += grid[i][j];
                // System.out.println("max "+max);
                dp[i][j][0] = max;
                dp[i][j][1] = (int)total;
            }
        }
        int ans[] = new int[]{(int)dp[n-1][n-1][0],(int)dp[n-1][n-1][1]};

        if(ans[0] == -1)
            ans[0] = ans[1] = 0;
        
        return ans;
    }
}