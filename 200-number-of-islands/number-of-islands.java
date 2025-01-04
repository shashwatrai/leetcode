class Solution {

    public void traverse(char [][]grid,int r,int c){
        
        if( r > 0 && grid[r-1][c] == '1'){
            grid[r-1][c] = '2';
            traverse(grid,r-1,c);
        }
        if(c > 0 && grid[r][c-1] == '1'){
            grid[r][c-1] = '2';
            traverse(grid,r,c-1);
        }
        if(r + 1 < grid.length && grid[r+1][c] == '1'){
            grid[r+1][c] = '2';
            traverse(grid,r+1,c);
        }
        if(c + 1 < grid[r].length && grid[r][c+1] == '1'){
            grid[r][c+1] = '2';
            traverse(grid,r,c+1);
        }
    }

    public int numIslands(char[][] grid) {
        int ans =0 ;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    traverse(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
}