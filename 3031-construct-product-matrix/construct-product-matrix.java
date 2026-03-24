class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        long R = 12345L;
        int n = grid.length;
        int m = grid[0].length;

        int pre[] = new int[m*n];
        int suff[] = new int[m*n];

        long prev1= 1L, prev2 = 1L;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pre[i*m+j] = (int)prev1;
                suff[(n-1-i)*m+ (m-1-j)] = (int)prev2;
                prev1 = ((prev1%R) * (long)grid[i][j]%R)%R;
                prev2 = ((prev2%R) * (long)grid[n-1-i][m-1-j]%R)%R;
            }
        }
        int ans[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j] = (int)((long)(((long)pre[i*m+j]%R)*((long)suff[i*m+j]%R))%R);
            }
        }
        return ans;
    }
}