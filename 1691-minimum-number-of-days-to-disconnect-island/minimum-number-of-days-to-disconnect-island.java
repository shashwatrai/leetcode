class Solution {
    public void dfs(int [][]grid,boolean [][]vis,int r, int c){
        vis[r][c] = true;

        if(r > 0 && grid[r-1][c] == 1 && !vis[r-1][c]) {
            dfs(grid,vis,r-1,c);
        }
        if(r < grid.length-1 && grid[r+1][c] == 1 && !vis[r+1][c]) {
            dfs(grid,vis,r+1,c);
        }
        if(c > 0 && grid[r][c-1] == 1 && !vis[r][c-1]) {
            dfs(grid,vis,r,c-1);
        }
        if(c < grid[0].length -1 && grid[r][c+1] == 1 && !vis[r][c+1]) {
            dfs(grid,vis,r,c+1);
        }
        
    }

    public void aPHelper(int [][]grid,boolean [][]vis,int []disc,int []low,int []artPointCount
    ,int r, int c,int []time,int parent){
        
        vis[r][c] = true;
        int n=grid[0].length;
        disc[r*n+c] = low[r*n+c] = ++time[0];
        int children =0;
        boolean  isAP = false;
        if(r > 0 && grid[r-1][c] == 1 && parent != (r-1)*n+c) {

            // System.out.println("UP "+parent+" "+ r+" "+c+" "+(r*n+c));
            if(!vis[r-1][c]){
                children++;
                aPHelper(grid,vis,disc,low,artPointCount,r-1,c,time,r*n+c);
                low[r*n+c] = Math.min(low[r*n+c],low[(r-1)*n+c]);
                if(low[(r-1)*n+c] >= disc[r*n+c] && parent != -1)
                    isAP = true;
            }else{
                low[r*n+c] = Math.min(low[r*n+c],disc[(r-1)*n+c]);
            }
        }
        if(r < grid.length-1 && grid[r+1][c] == 1 && parent != (r+1)*n+c) {

            // System.out.println("DOWN "+parent+" "+ r+" "+c+" "+(r*n+c));
            if(!vis[r+1][c]){
                children++;
                aPHelper(grid,vis,disc,low,artPointCount,r+1,c,time,r*n+c);
                low[r*n+c] = Math.min(low[r*n+c],low[(r+1)*n+c]);
                if(low[(r+1)*n+c] >= disc[r*n+c] && parent != -1)
                    isAP = true;
            }else{
                low[r*n+c] = Math.min(low[r*n+c],disc[(r+1)*n+c]);
            }
        }
        if(c > 0 && grid[r][c-1] == 1 && parent != r*n+c-1) {
            // System.out.println("LEFT "+parent+" "+ r+" "+c+" "+(r*n+c));

            if(!vis[r][c-1]){
                children++;
                aPHelper(grid,vis,disc,low,artPointCount,r,c-1,time,r*n+c);
                low[r*n+c] = Math.min(low[r*n+c],low[r*n+c-1]);
                if(low[r*n+c-1] >= disc[r*n+c] && parent != -1)
                    isAP = true;
            }else{
                low[r*n+c] = Math.min(low[r*n+c],disc[r*n+c-1]);
            }
        }
        if(c < grid[0].length -1 && grid[r][c+1] == 1 && parent != r*n+c+1) {
  
            // System.out.println("RIGHT "+parent+" "+ r+" "+c+" "+(r*n+c));
            if(!vis[r][c+1]){
                children++;
                aPHelper(grid,vis,disc,low,artPointCount,r,c+1,time,r*n+c);
                low[r*n+c] = Math.min(low[r*n+c],low[r*n+c+1]);
                if(low[r*n+c+1] >= disc[r*n+c] && parent != -1)
                    isAP = true;
            }else{
                low[r*n+c] = Math.min(low[r*n+c],disc[r*n+c+1]);
            }
        }
    //    System.out.println(parent/n+" "+(parent-(parent/n)*n)+" "+r+" "+c+" "+isAP+" "+disc[r*n+c]+" "+low[r*n+c]);
        if(isAP || (parent == -1 && children > 1)){
            // System.out.println(r+" "+c+" "+low[r*n+c]+" "+disc[r*n+c]+" "+(low[r*n+c] >= disc[r*n+c] && parent !=-1 )+" "+( (parent == -1 && children > 1)));
            artPointCount[0]++;
        }
    }

    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];
        int count=0;
        int rStart= -1,cStart = -1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    dfs(grid,vis,i,j);
                    if(rStart == -1 && cStart == -1){
                        rStart = i;
                        cStart = j;
                    }
                    count++;
                }
            }
        }
        if(count > 1 || count == 0)
            return 0;
        vis = new boolean[m][n];
        int []disc = new int[n*m+1];
        int []low = new int[n*m+1];
        int time[]={0};
        int []artPointCount = new int[1];

        aPHelper(grid,vis,disc,low,artPointCount,rStart,cStart,time,-1);
        int eleCount = 0;
        // System.out.println(Arrays.toString(disc)+"\n"+Arrays.toString(low)+" "+artPointCount[0]);
        for(int i: low){
            if(i >= 1)
                eleCount++;
        }
        return  artPointCount[0] > 0 ? 1 
                : eleCount >  3 ? 2
                    : eleCount;
    }
}