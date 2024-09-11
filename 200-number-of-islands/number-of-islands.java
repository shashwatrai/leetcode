class Pair{
    int r,c;

    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {

    public void floodFill(char [][]grid, int x,int y){
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(x,y));
        grid[x][y] = '2';

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int r = p.r;
            int c = p.c;

            if(r > 0 && grid[r-1][c] == '1'){
                grid[r-1][c] = '2';
                queue.add(new Pair(r-1,c));
            }

            if(c > 0 && grid[r][c-1] == '1'){
                grid[r][c-1] = '2';
                queue.add(new Pair(r,c-1));
            }

            if(r < grid.length-1 && grid[r+1][c] == '1'){
                grid[r+1][c] = '2';
                queue.add(new Pair(r+1,c));
            }

            if(c < grid[0].length-1 && grid[r][c+1] == '1'){
                grid[r][c+1] = '2';
                queue.add(new Pair(r,c+1));
            }
        }

        return;
        
    }

    public int numIslands(char[][] grid) {
    
        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    floodFill(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }
}