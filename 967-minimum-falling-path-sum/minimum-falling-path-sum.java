class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int prev[] = Arrays.copyOf(matrix[0],n);

        for(int i = 1;i<n;i++){
            
            int curr[] = new int[n];
            Arrays.fill(curr,Integer.MAX_VALUE);
            for(int j=0;j<n;j++){
                if(j > 0)
                    curr[j] = Math.min(curr[j],prev[j-1]+matrix[i][j]);
                curr[j] = Math.min(curr[j],prev[j]+matrix[i][j]);
                if(j<n-1)
                    curr[j] = Math.min(curr[j],prev[j+1]+matrix[i][j]);
            }
            prev = curr;
        }
        int ans = Integer.MAX_VALUE;
        for(int i:prev)
            ans = Math.min(i,ans);
        return ans;
    }
}