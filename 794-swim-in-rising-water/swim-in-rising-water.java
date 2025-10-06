class Solution {
    public int swimInWater(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int ans[][] = new int[m][n];
        boolean vis[][] = new boolean[m][n];

        for(int i =0;i<m;i++){
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> a[2] - b[2]);
        

        ans[0][0] = grid[0][0];

        pq.add(new int[]{0,0,grid[0][0]});

        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!pq.isEmpty()){
            int curr[] = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            if(r == m-1 && c == n-1)
                return cost;
            if(vis[r][c])
                continue;
            vis[r][c] = true;
            for(int i=0;i<4;i++){
                int x = r + dir[i][0];
                int y = c + dir[i][1];

                if(x < 0|| y < 0 || x >= m || y >= n || ans[x][y] < Math.max(cost,grid[x][y]))
                    continue;
                ans[x][y] = Math.max(cost,grid[x][y]);
                // System.out.println(ans[x][y]);
                pq.add(new int[]{x,y,ans[x][y]});
            }
        }
        return -1;
    }
}