class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        PriorityQueue<int []> pq =  new PriorityQueue<>((a,b) -> a[2] - b[2]);

        pq.add(new int[]{0,0,0});
        int time[][] = new int[m][n];
        for(int i[]:time)
            Arrays.fill(i ,Integer.MAX_VALUE);
        time[0][0] = 0;
        while(!pq.isEmpty()){    
            int curr[] = pq.poll();

            int r = curr[0];
            int c = curr[1];
            if(r == m-1 && c == n-1)
                return time[r][c];

            int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
            for(int i[]:dir){
                int x = r+i[0];
                int y = c+i[1];
                if(x >= m || x < 0 || y >= n || y < 0)
                    continue;
                
                if(time[x][y] > Math.max(moveTime[x][y], time[r][c])+1  ){
                    time[x][y] =  Math.max(moveTime[x][y], time[r][c])+1;
                    pq.add(new int[]{x,y,time[x][y]});
                }
            }
        }
        return -1;
    }
}