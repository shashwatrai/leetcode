class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int row[] = new int[m];
        int col[] = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }

        int total = 0;
        for(int i: row)
            total += i;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i] == col[j] && row[i] == 1 && grid[i][j] == 1)
                    total--;
            }
        }
        return total;
    }
}