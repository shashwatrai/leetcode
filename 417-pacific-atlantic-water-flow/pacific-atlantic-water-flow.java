class Solution {

    public boolean traverseToPacific(int [][]heights, int [][]status,int r,int c){
        if(r == 0 || c == 0 || status[r][c] == 2){
            status[r][c] =2;
            return true;
        }
        
        status[r][c] = 1;
        if(status[r-1][c] != 1 && heights[r][c] >= heights[r-1][c] && traverseToPacific(heights,status,r-1,c)){
            status[r][c] = 2;
            return true;
        }

        if(status[r][c-1] != 1 && heights[r][c] >= heights[r][c-1] && traverseToPacific(heights,status,r,c-1)){
            status[r][c] = 2;
            return true;
        }

        if(r+1 < status.length && status[r+1][c] != 1 && heights[r][c] >= heights[r+1][c] && traverseToPacific(heights,status,r+1,c)){
            status[r][c] = 2;
            return true;
        }

        if(c+1 < status[0].length && status[r][c+1] != 1 && heights[r][c] >= heights[r][c+1] && traverseToPacific(heights,status,r,c+1)){
            status[r][c] = 2;
            return true;
        }
        status[r][c] = 0;

        return false;
    }
    public boolean traverseToAntlantic(int [][]heights, int [][]status,int r,int c){
        if(r == heights.length - 1  || c == heights[0].length - 1 || status[r][c] == 2){
            status[r][c] = 2;
            return true;
        }
        status[r][c] = 1;
        
        if(status[r+1][c] != 1 && heights[r][c] >= heights[r+1][c] && traverseToAntlantic(heights,status,r+1,c)){
            status[r][c] = 2;
            return true;
        }

        if(status[r][c+1] != 1 && heights[r][c] >= heights[r][c+1] && traverseToAntlantic(heights,status,r,c+1)){
            status[r][c] = 2;
            return true;
        }

        if(r > 0 && status[r-1][c] != 1 && heights[r][c] >= heights[r-1][c] && traverseToAntlantic(heights,status,r-1,c)){
            status[r][c] = 2;
            return true;
        }

        if(c > 0 && status[r][c-1] != 1 && heights[r][c] >= heights[r][c-1] && traverseToAntlantic(heights,status,r,c-1)){
            status[r][c] = 2;
            return true;
        }
        status[r][c] = 0;
        return false;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int status1[][] = new int[m][n];
        int status2[][] = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(status1[i][j] == 0)
                    traverseToPacific(heights,status1,i,j);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(status2[i][j] == 0)
                    traverseToAntlantic(heights,status2,i,j);
            }
        }
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<m;i++){
            System.out.println(Arrays.toString(status1[i]));// +" "+Arrays.toString(status1[i]) );
            for(int j=0;j<n;j++){
                if(status1[i][j] ==2 && status2[i][j] == 2){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
}