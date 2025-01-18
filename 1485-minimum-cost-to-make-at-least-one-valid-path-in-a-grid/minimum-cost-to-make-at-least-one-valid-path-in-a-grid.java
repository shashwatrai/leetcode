class Pair{
    int r,c,cost;
    Pair(int r,int c,int cost){
        this.r=r;
        this.c= c;
        this.cost =cost;
    }
}
class Solution {
    public int minCost(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);

        pq.add(new Pair(0,0,0));
        boolean [][]vis = new boolean[m][n];

        int cost[][] = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(cost[i],Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(vis[p.r][p.c])
                continue;
            if(p.r == m-1 && p.c == n-1)
                return p.cost;
            
            vis[p.r][p.c] = true;
            cost[p.r][p.c] = p.cost;

            int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};

            for(int i=0;i<dir.length;i++){
                int r = p.r + dir[i][0];
                int c = p.c + dir[i][1];
                if(r >= m || r <0 || c >= n || c<0)
                    continue;
                int newCost = p.cost + (grid[p.r][p.c] == i+1 ?  0 : 1);
                if(cost[r][c] > newCost){
                    pq.add(new Pair(r,c,newCost));
                    cost[r][c] = newCost;
                }
            }
        }
        return -1;
    }
}