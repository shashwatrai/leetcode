class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int [][] ans = new int[m][n];
        for(int i[]:ans)
            Arrays.fill(i,Integer.MAX_VALUE);

        boolean [][]vis = new boolean[m][n];

        PriorityQueue< int[] > pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

        pq.add(new int[]{0,0,0});

        int [][]dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!pq.isEmpty()){
            int []curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            if(vis[r][c])
                continue;
            
            if(r == m-1 && c == n-1)
                return cost;
            vis[r][c] = true;
            for(int i=0;i<4;i++){
                int x  = r + dir[i][0];
                int y = c + dir[i][1];

                if(x < 0 || y < 0 || x >= m || y >= n || ans[x][y] < Math.max(cost, Math.abs(heights[x][y] - heights[r][c])))
                    continue;
                
                ans[x][y] =Math.max(cost, Math.abs(heights[x][y] - heights[r][c]));
                // System.out.println(x+" "+y+" "+ans[x][y]);
                pq.add(new int[]{x,y,ans[x][y]});
            }
        }
        return -1;

    }
}