class Solution {
    public int traverse(int [][]grid,int r,int c){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{r,c} );
        grid[r][c] = 0;
        int count=0;
        while(!queue.isEmpty()){
            int []curr = queue.poll();
            count++;
            int x = curr[0];
            int y = curr[1];
            for(int i=0;i<grid.length;i++){
                if(grid[i][y] == 1){
                    queue.add(new int[]{i,y});
                    grid[i][y] = 0;
                }
            }
            for(int i=0;i<grid[x].length;i++){
                if(grid[x][i] == 1){
                    queue.add(new int[]{x,i});
                    grid[x][i] = 0;
                }
            }
        }
        return count > 1 ? count : 0;
    }
    public int countServers(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1)
                    ans+=traverse(grid,i,j);
            }
        }
        return ans;
        
    }

    
}