class Pair{
    int r,  c;
    Pair(int r,int c){
        this.r= r;
        this.c = c;
    }
}
class Solution {
    public void floodFill(int [][]graph,int r, int c){
        int n = graph.length;

        Queue<Pair> q = new LinkedList<>();
        graph[r][c] = 2;
        q.add(new Pair(r,c));
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            
            if(p.r > 0 && graph[p.r-1][p.c] == 0){
                graph[p.r-1][p.c] = 2;
                q.add(new Pair(p.r-1,p.c));
            }

            if(p.r < n-1 && graph[p.r+1][p.c] == 0){
                graph[p.r+1][p.c] = 2;
                q.add(new Pair(p.r+1,p.c));
            }

            if(p.c > 0 && graph[p.r][p.c-1] == 0){
                graph[p.r][p.c-1] = 2;
                q.add(new Pair(p.r,p.c-1));
            }

            if(p.c < n-1 && graph[p.r][p.c+1] == 0){
                graph[p.r][p.c+1] = 2;
                q.add(new Pair(p.r,p.c+1));
            }
        }
    }
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        // Magnifying the grid 3 time and then counting the no of islands
        int [][]graph = new int[3*n][3*n];

        int r =0,c=0;
        for(String s : grid){
            for(int i=0;i<n;i++){
                if(s.charAt(i) == '/')
                    graph[r+2][c]  = graph[r+1][c+1] = graph[r][c+2] =  1;
                else if(s.charAt(i) == '\\')
                    graph[r][c]  = graph[r+1][c+1] = graph[r+2][c+2] =  1;

                c+=3;
            }
            r+=3;
            c=0;
        }

        int count =0 ;
        for(int i=0;i<3*n;i++){
            for(int j=0;j<3*n;j++){
                if(graph[i][j] == 0){
                    floodFill(graph,i,j);
                    count++;

                }

            }
        }
        return count;
    }
}
