class Solution {
    public int traverse(int [][] grid,int r,int c){
        int [][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int childs = 0;
        int score = grid[r][c];
        grid[r][c] = 0;
        for(int i=0;i<4;i++){
            int x = dir[i][0] + r;
            int y = dir[i][1] + c;

            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0)
                continue;
            
            childs += traverse(grid,x,y);
        }
        return score + childs;
    }
    public int findMaxFish(int[][] grid) {
        
        int max = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] > 0)
                    max = Math.max(max,traverse(grid,i,j));
            }
        }
        return max;

    }
}