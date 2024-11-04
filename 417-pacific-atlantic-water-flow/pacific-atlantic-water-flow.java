class Solution {
    public void traversePacific(int [][]heights,boolean [][]status){
        Queue<int []> queue  = new LinkedList<>();

        for(int i=0;i<heights.length;i++){
            status[i][0] = true;
            queue.add(new int[]{i,0});
        }
        for(int i=0;i<heights[0].length;i++){
            status[0][i] =true;
            queue.add(new int[]{0,i});
        }

        while(!queue.isEmpty()){
            int []pos = queue.poll();
            int r = pos[0],c = pos[1];
            if( r > 0 && !status[r-1][c] && heights[r-1][c] >= heights[r][c]){
                status[r-1][c] = true;
                queue.add(new int[]{r-1,c});
            }
            if( c > 0 && !status[r][c-1] && heights[r][c-1] >= heights[r][c]){
                status[r][c-1] = true;
                queue.add(new int[]{r,c-1});
            }
            if( r < heights.length-1 && !status[r+1][c] && heights[r+1][c] >= heights[r][c]){
                status[r+1][c] = true;
                queue.add(new int[]{r+1,c});
            }
            if( c < heights[0].length -1  && !status[r][c+1] && heights[r][c+1] >= heights[r][c]){
                status[r][c+1] = true;
                queue.add(new int[]{r,c+1});
            }
        }
    }
    public void traverseAntalntic(int [][]heights,boolean [][]status){
        Queue<int []> queue  = new LinkedList<>();

        for(int i=0;i<heights.length;i++){
            status[i][heights[0].length-1] = true;
            queue.add(new int[]{i,heights[0].length-1});
        }
        for(int i=0;i<heights[0].length;i++){
            status[heights.length-1][i] =true;
            queue.add(new int[]{heights.length-1,i});
        }

        while(!queue.isEmpty()){
            int []pos = queue.poll();
            int r = pos[0],c = pos[1];
            if( r > 0 && !status[r-1][c] && heights[r-1][c] >= heights[r][c]){
                status[r-1][c] = true;
                queue.add(new int[]{r-1,c});
            }
            if( c > 0 && !status[r][c-1] && heights[r][c-1] >= heights[r][c]){
                status[r][c-1] = true;
                queue.add(new int[]{r,c-1});
            }
            if( r < heights.length-1 && !status[r+1][c] && heights[r+1][c] >= heights[r][c]){
                status[r+1][c] = true;
                queue.add(new int[]{r+1,c});
            }
            if( c < heights[0].length -1  && !status[r][c+1] && heights[r][c+1] >= heights[r][c]){
                status[r][c+1] = true;
                queue.add(new int[]{r,c+1});
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;  

        boolean status1[][] = new boolean[m][n] ;
        boolean status2[][] = new boolean[m][n];
        traversePacific(heights,status1);
        traverseAntalntic(heights,status2);
        List<List<Integer>>res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(status1[i][j] && status2[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
}