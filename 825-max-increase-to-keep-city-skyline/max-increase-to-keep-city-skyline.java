class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int ver[] = new int[n];

        int hor[]= new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                hor[i] = Math.max(hor[i],grid[i][j]);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ver[i] = Math.max(ver[i],grid[j][i]);
            }
        }
        // System.out.println(Arrays.toString(hor)+" \n" + Arrays.toString(ver));
        int ans =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans += Math.max(grid[i][j],Math.min(hor[i],ver[j]))-grid[i][j];
            }
        }
        return ans;
    }
}