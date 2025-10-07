class Solution {
    public void traverse(List<List<Integer>> grid, int [][]cost,boolean [][]vis){
        int m = grid.size();
        int n = grid.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(i).size();j++){
                if(grid.get(i).get(j) == 1){
                    queue.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        int t = 0;
        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){

            Queue<int[]> temp = new LinkedList<>();
            int l = queue.size();
            while(l-- > 0){
                int []curr = queue.poll();

                int r  = curr[0];
                int c = curr[1];

                cost[r][c] = t;

                for(int i=0;i<4;i++){
                    int x = r + dir[i][0];
                    int y = c + dir[i][1];

                    if(x < 0 || y < 0 || x >= m || y >= n || vis[x][y])
                        continue;
                    temp.add(new int[]{x,y});
                    vis[x][y] = true;
                }
            }
            queue = temp;
            t++;
        }
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();

        int cost[][] = new int[m][n];
        boolean vis[][] = new boolean[m][n];

        traverse(grid,cost,vis);   

        PriorityQueue<int []>pq = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        pq.add(new int[]{0,0,cost[0][0]});
        vis = new boolean[m][n];
        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        // for(int i[]:cost){
        //     System.out.println(Arrays.toString(i));
        // }
        int [][]path = new int[m][n];
        for(int i[]:path)
            Arrays.fill(i,1000);
        path[0][0] = cost[0][0];
        while(!pq.isEmpty()){
            int []curr = pq.poll();
            int r = curr[0];
            int c = curr[1];

            if(vis[r][c])
                continue;
            if(r == m-1 && c == n-1)
                return curr[2];
            
            path[r][c] = curr[2];
            vis[r][c] = true;

            for(int i=0;i<4;i++){
                int x = r + dir[i][0];
                int y = c + dir[i][1];

                if(x < 0 || y < 0 || x >= m || y >= n || vis[x][y] || path[x][y] < Math.min(cost[x][y], curr[2]))
                    continue;
                path[x][y] = Math.min(cost[x][y], curr[2]);
                pq.add(new int[]{x,y,path[x][y]});
            }
        } 
        return -1;   
    }
}