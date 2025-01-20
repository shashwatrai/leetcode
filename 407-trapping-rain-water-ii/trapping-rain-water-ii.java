class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean vis[][] = new boolean[m][n];
        boolean boundary[][] = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]]);
        for(int i=0;i<m;i++){
            pq.add(new int[]{i,0});
            pq.add(new int[]{i,n-1});
            boundary[i][0] = boundary[i][n-1] =true;
        }
        for(int j=0;j<n;j++){
            pq.add(new int[]{0,j});
            pq.add(new int[]{m-1,j});
            boundary[0][j] = boundary[m-1][j] =true;
        }
        int ans=0;
       
        int dir[][] = {{0,-1},{0,1},{-1,0},{1,0}};
        while(!pq.isEmpty()){
            int []curr= pq.poll();
            vis[curr[0]][curr[1]] = true;
            for(int i=0;i<4;i++){
                int x = curr[0] + dir[i][0];
                int y = curr[1] + dir[i][1];

                if(x < 0 || y < 0 || x >= m || y >= n || vis[x][y] || boundary[x][y])
                    continue;
                
                
                
                ans += Math.max(0, heightMap[curr[0]][curr[1]]-heightMap[x][y]);
                heightMap[x][y] = Math.max(heightMap[x][y],heightMap[curr[0]][curr[1]]);
                pq.add(new int[]{x,y});
                boundary[x][y] = true;
                
            }
        }
        return ans;
    }
}