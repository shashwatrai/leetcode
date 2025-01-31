class Solution {
    public int traverse(int [][]grid,int [][]group,int n,int r,int c,int g){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        boolean [][] vis = new boolean[n][n];
        int ans=0;
        vis[r][c] = true;
        while(!queue.isEmpty()){
            int len = queue.size();
            ans+=len;
            while(len-- > 0){
                int []curr = queue.poll();
                group[curr[0]][curr[1]] = g;
                int [][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
                for(int j=0;j<4;j++){
                    int x = dir[j][0] + curr[0];
                    int y = dir[j][1] + curr[1];
                    if(x < 0 || y< 0 || x >= n || y >= n || vis[x][y] || grid[x][y] == 0)
                        continue;
                    queue.add(new int[]{x,y});
                    vis[x][y] = true;
                }
                
            }
        }
        return ans;
    }
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;

        int group[][] = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(group[i] , -1);
        
        int g = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && group[i][j] == -1){
                    traverse(grid,group,n,i,j,g++);
                }
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(group[i][j] != -1)
                    map.put(group[i][j], map.getOrDefault(group[i][j],0)+1);
            }
        }
        // for(int i[]:group)
        //     System.out.println(Arrays.toString(i));
        int ans =0;
        for(int i:map.keySet())
            ans = Math.max(ans,map.get(i));
        // System.out.println(map);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    int temp =0;
                    int [][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
                    Set<Integer> allowedGroups = new HashSet<>();
                    for(int k=0;k<4;k++){
                        int x = dir[k][0] + i;
                        int y = dir[k][1] + j;
                        if(x < 0 || y< 0 || x >= n || y >= n || group[x][y] == -1)
                            continue;
                        allowedGroups.add(group[x][y]);
                    }
                    // System.out.println(allowedGroups);
                    for(int k:allowedGroups)
                        temp += map.get(k);
                    ans = Math.max(temp+1,ans);
                }
            }
        }
        return ans;
    }
}