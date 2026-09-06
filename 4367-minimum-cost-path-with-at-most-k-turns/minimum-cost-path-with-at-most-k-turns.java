class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid[0].length;
        int m = grid.length;
        PriorityQueue<int[]> pq =  new PriorityQueue<>((a,b)->{
            if(a[3] != b[3])
                return a[3] - b[3];
            return a[4] - b[4];
        });

        pq.add(new int[]{0,0,-1,grid[0][0],0});
        int dir[][] = {{0,-1},{-1,0},{0,1},{1,0}};
        int vis[][][][] = new int[m][n][4][k+1];
        for(int i[][][]:vis)
            for(int j[][]:i)
                for(int l[]: j)
                    Arrays.fill(l,Integer.MAX_VALUE);

        int reverse[] = new int[]{2,3,0,1};
        vis[0][0][0][0]= vis[0][0][1][0] = vis[0][0][2][0] = vis[0][0][3][0] = grid[0][0];
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            if(curr[0] == m-1 && curr[1] == n-1)
                return curr[3];

        
            for(int i=0;i<4;i++){
                if(curr[2] != -1 && reverse[curr[2]] == i)
                    continue;
                int x = curr[0] + dir[i][0];
                int y = curr[1] + dir[i][1];

                int turnCount = curr[2] == -1 ? 0 : curr[2] == i ? curr[4]: curr[4]+1;
                int turn =  i;

               
                if(x >= m || x < 0 || y >= n || y < 0 || turnCount > k || vis[x][y][turn][turnCount] <= curr[3] + grid[x][y] )
                    continue;
                vis[x][y][turn][turnCount] = curr[3] + grid[x][y];
                pq.add(new int[]{x,y,turn,curr[3] + grid[x][y],turnCount});
            }
        }
        return -1;
    }
}