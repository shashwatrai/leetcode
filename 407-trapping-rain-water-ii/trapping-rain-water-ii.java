class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        int [][]boundary = new int[m][n];

        for(int i[]:boundary){
            Arrays.fill(i,-1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> boundary[a[0]][a[1]] - boundary[b[0]][b[1]]);

        for(int j = 0;j<n;j++){
            boundary[0][j] = heightMap[0][j];
            pq.add(new int[]{0,j});

            boundary[m-1][j] = heightMap[m-1][j];
            pq.add(new int[]{m-1,j});

        }

        for(int i = 0;i<m;i++){
            boundary[i][0] = heightMap[i][0];
            pq.add(new int[]{i,0});

            boundary[i][n-1] = heightMap[i][n-1];
            pq.add(new int[]{i,n-1});
        }

        int ans =0 ;
        while(!pq.isEmpty()){
            int curr[] = pq.poll();

            int r = curr[0];
            int c = curr[1];

            // System.out.println(r+" "+c);

            if(r > 0 && boundary[r-1][c] == -1){
                ans += Math.max(boundary[r][c] - heightMap[r-1][c],0);
                boundary[r-1][c] = Math.max(boundary[r][c],heightMap[r-1][c]);
                pq.add(new int[]{r-1,c});
                // System.out.println("("+(r-1)+","+c+")"+ " "+ans);
            }
            if(c > 0 && boundary[r][c-1] == -1){
                ans += Math.max(boundary[r][c] - heightMap[r][c-1],0);
                boundary[r][c-1] = Math.max(boundary[r][c],heightMap[r][c-1]);
                pq.add(new int[]{r,c-1});
                // System.out.println("("+(r)+","+(c-1)+")"+ " "+ans);
            }
            if(r < m-1 && boundary[r+1][c] == -1){
                ans += Math.max(boundary[r][c] - heightMap[r+1][c],0);
                boundary[r+1][c] = Math.max(boundary[r][c],heightMap[r+1][c]);
                pq.add(new int[]{r+1,c});
                // System.out.println("("+(r+1)+","+c+")" + " "+ans);

            }
            if(c < n-1 && boundary[r][c+1] == -1){
                ans += Math.max(boundary[r][c] - heightMap[r][c+1],0);
                boundary[r][c+1] = Math.max(boundary[r][c],heightMap[r][c+1]);
                pq.add(new int[]{r,c+1});
                // System.out.println("("+(r)+","+(c+1)+")"+ " "+ans);
            }
        }
        return ans;
    }
}