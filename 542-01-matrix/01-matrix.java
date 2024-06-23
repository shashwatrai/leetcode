class Pair{
    int x,y;
    int dist;
    Pair(int x,int y,int d){
        this.x = x;
        this.y = y;
        this.dist = d;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.dist - b.dist;
            }
        });

        int n = mat.length;
        int m = mat[0].length;

        int res[][] = new int[n][m];
        boolean vis[][] =new boolean [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    pq.add(new Pair(i,j,0));
                    res[i][j] = 0;
                }else
                    res[i][j] = Integer.MAX_VALUE;
            }
        }
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(vis[curr.x][curr.y] )
                continue;
            vis[curr.x][curr.y] = true;
            int i = curr.x,j = curr.y;
            
            if(i > 0 && mat[i-1][j] == 1 && !vis[i-1][j] && res[i-1][j] > res[i][j] +1 ){
                res[i-1][j] = res[i][j] +1;
                
                pq.add(new Pair(i-1,j,res[i-1][j]));
            }
            if(i<n-1 && mat[i+1][j] == 1 && !vis[i+1][j] && res[i+1][j] > res[i][j]+1){
                res[i+1][j] = res[i][j]+1;
                
                pq.add(new Pair(i+1,j,res[i+1][j]));
            } 
            if(j<m-1 && mat[i][j+1] == 1 && !vis[i][j+1] && res[i][j+1] > res[i][j]+1){
                res[i][j+1] = res[i][j]+1;
                pq.add(new Pair(i,j+1,res[i][j+1]));
            } 
            if(j > 0 && mat[i][j-1] == 1 && !vis[i][j-1] && res[i][j-1] > res[i][j]+1){
                res[i][j-1] = res[i][j]+1;
                
                pq.add(new Pair(i,j-1,res[i][j-1]));
            }
        }
        return res;
    }
}