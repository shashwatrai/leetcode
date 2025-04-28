class Solution {
    public void traverse(int [][]isConnected,boolean []vis,int curr){
        vis[curr] =true;

        for(int j = 0;j<isConnected[curr].length;j++){
            if(curr != j && !vis[j] && isConnected[curr][j] == 1)
                traverse(isConnected,vis,j);
        }
        
    }
    public int findCircleNum(int[][] isConnected) {
        
        int cnt =0 ;

        int n = isConnected.length;
        boolean vis[] = new boolean[n];


        for(int i=0;i<n;i++){
            if(!vis[i]) {
                cnt++;
                traverse(isConnected,vis,i);
            }
        }
        return cnt;
    }
}