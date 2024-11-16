class Solution {

    public boolean tryKuhn(int v,boolean []vis,int []matching,int [][]grid){
        if(vis[v])
            return false;
        vis[v] = true;

        for(int i=0;i<grid[v].length;i++){
            if(grid[v][i] == 1){
                if(matching[i] == -1 || tryKuhn(matching[i],vis,matching,grid)){
                    matching[i] = v;
                    return true;
                }
            }
        }
        return false;
    }

    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int []matching = new int[n];
        Arrays.fill(matching,-1);

        for(int i=0;i<m;i++){
            boolean vis[] = new boolean[m];
            tryKuhn(i,vis,matching,grid);
        }
        int cnt=0;
        for(int i:matching)
            if(i != -1)
                cnt++;
        return cnt;
    }
}