class Solution {

    public void traverse(int [][]heights,int [][]status, List<List<Integer>> start){

        Queue<List<Integer>> que = new LinkedList<>(start);
        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!que.isEmpty()){
            List<Integer> curr = que.poll();

            int r = curr.get(0);
            int c = curr.get(1);

            for(int i=0;i<4;i++){
                int x = r + dir[i][0];
                int y = c + dir[i][1];

                if(x < 0 || y < 0 || x >= heights.length || y >= heights[0].length || status[x][y] != 0 || heights[r][c] > heights[x][y]){
                    continue;
                }
                status[x][y] = 1;
                que.add(Arrays.asList(x,y));
            }
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        
        List<List<Integer>> source1 = new ArrayList<>();
        List<List<Integer>> source2 = new ArrayList<>();
        int [][]status1 = new int[m][n];
        int [][]status2 = new int[m][n]; 
        for(int i=0;i<n;i++){
            source1.add(Arrays.asList(0,i));
            source2.add(Arrays.asList(m-1,i));
            status1[0][i] = status2[m-1][i] = 1;
        }

        for(int i=0;i<m;i++){
            source1.add(Arrays.asList(i,0));
            source2.add(Arrays.asList(i,n-1));
            status1[i][0] = status2[i][n-1] = 1;
        }   

        
        
        traverse(heights,status1,source1);
        traverse(heights,status2,source2);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                status1[i][j] += status2[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(status1[i][j] == 2)
                    ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
}