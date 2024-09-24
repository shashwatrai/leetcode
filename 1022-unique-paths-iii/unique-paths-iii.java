class Solution {
    int count;
    public void helper(int [][]grid,boolean [][]vis,int r,int c,int visitedCount){
        vis[r][c] = true;
        // System.out.println(r+" "+c+" "+visitedCount);
        if(visitedCount == 0 && grid[r][c] == 2){
            count++;
        }
        int [][]dir = {{-1,0},{0,-1},{0,1},{1,0}};

        for(int d[]:dir){
            if(r+d[0] < 0 || c+d[1] < 0 || r+d[0] >= grid.length || c+d[1] >= grid[0].length || vis[r+d[0]][c+d[1]] || grid[r+d[0]][c+d[1]] == -1){
                continue;
            }

            helper(grid,vis,r+d[0],c+d[1],visitedCount-1);
        }
        vis[r][c] = false;
    }
    public int uniquePathsIII(int[][] grid) {
        count=0;
        int visitedCount =0;
        int r=-1,c=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    r = i;
                    c = j;
                }
                if(grid[i][j] == 0)
                    visitedCount++;
            }
        }
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        helper(grid,vis,r,c,visitedCount+1);
        return count;
    }
}