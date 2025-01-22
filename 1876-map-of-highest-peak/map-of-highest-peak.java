class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int ans[][] = new int[m][n];
        boolean [][]vis = new boolean[m][n];
        Queue<int[]> queue= new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j] == 1){
                    queue.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        
        int h = 0;
        while(!queue.isEmpty()){
            int len = queue.size();

            while(len-- > 0){
                int []curr = queue.poll();

                ans[curr[0]][curr[1]] = h;

                int dir [][] = {{0,-1},{0,1},{-1,0},{1,0}};

                for(int i=0;i<4;i++){
                    int x = curr[0] + dir[i][0];
                    int y = curr[1] + dir[i][1];
                    if(x>= m || x < 0 || y>=n || y<0 || vis[x][y])
                        continue;
                    
                    queue.add(new int[]{x,y});
                    vis[x][y] = true;
                }
            }
            h++;
        }
        return ans;
    }
}